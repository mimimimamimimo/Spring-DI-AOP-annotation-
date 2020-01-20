package com.springbook.user;
//test는 여기서~~클래스따로뺴기
//스프링구동은 설정파일 돌리기부터지

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String args[]) {
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService)container.getBean("userService");
		
		UserVO vo=new UserVO();
		
		vo.setId("test");
		vo.setPassword("test123");
		UserVO user=userService.getUser(vo);
		if(user!=null)
			System.out.println(user+"님 환영합니다");  //sysout최공
		else
			System.out.println("로그인에 실패하셨습니다");
		
		container.close();
	}
}


//왜 이렇게 짜게 되는가
/*
 * 1.커넥션 만드는 애는 하나만 있으면 되니 공통 패키지로 하나만 클래스 만들어서 쓴다.
 * 커넥션을 뒀을때 잉 커넥션을 타고 다닐만한, 즉 db에 있는 친구들에 맞는 vo와 dao를 각각 만들어준다.
 * vo는 커넥션에서 리턴받을때 커스텀객체로 들어오지 않기 때문에 그 징검다리가 되기위해 만들며 징검에 넣고 뺴고를 위해 getset과 그 인스턴스 확인위한 tostring만든다.
 * 변수의 값이 주가 되는 객체이므로 tostring을 만든다고 봐도 된다
 * dao는 vo를 쓰는 애다. 징검다리가 커넥션과 무엇과 이어져야하지 않겠는가. 일단 커넥션에서 그 객체ㅔ 대해 동작하는 가장
 * 공통된 단위인 dao를 쓴다. 여기서 커넥션을 생성하고 vo도 생성해서 커넥션에서 가져온걸 vo로 변환하는 것이다. 
 * 이렇게하면 커넥션이 여기 종속되있으면 여러번 생성되지 않냐는 생각 들수도 있는데 당연히 커넥션 여러개 되야한다.
 * 그래도 메소드마다가 아니라 서비스마다니 그나마 ㄱㅊ..
 * dao는 쿼리가 담겨있는 클래스라고 봐도 된다. 어떤 클래스를 위한 dao는 그 클래스를 위한 쿼리를 가지고 있다. 
 * vo가 여기서 존재하기 때문에 리턴도 vo로 해주면된다. 들어오는 vo는 이 dao를 쓸 service에서 만들어서 넣어준다.
 * 여기서,왜 vo는 빈등록을 안하나?
 * 징검다리일뿐이지, 싱글톤으로 만들어서 쓸 필요도 없고 써서도 안된다. 
 * 왜 커넥션은 빈등록을 안하나?왜 주입안하나?
 * 마찬가지.
 * vo는 왜 주입을 했나?
 * dao에 종속되있으면 vo 정의 바뀌면 어떻게 얘 코드 직접 고쳐줘야하는데..
 * 왜 try캐치썼나?
 * uservo주입을 했는데,그 말은 userdao클래스가 uservo에 의존을 가지고 있다는거고
 * 외부에서 날라온걸 쓸때는 항상 그게 빈 경우를 확인해야한다.
 * 어쨋든, 이 userdao를 갖다 쓸 user관련 서비스가 엄청 많을거니 인터페이스로 뺴주고 그걸 확장한 서비스 있어도
 * dao에서 할 수 있는 기능이 crud한정이므로 crud관련한 서비스듣ㄹ을 만들어줌.
 * 확장해서 완성된건 정의느낌이 아니라 모듈느낌이니까 따로 떼서 패키지 관리함.
 * 
 * Service 구현할때 dao와 vo생성해서 지지고볶고 해야하는데
 * 1.dao는 의존할 것인가 . Service에서 무조건 있어야하므로 의존. 그것도 생성자로. 런타임에 바꿀 필요가 없다.바뀔걸 걱정하는건, 정의자체가 바뀔까봐 의존하는거지 
 * 2.dao는 자동주입할것인가 . 이 서비스에서 공통으로 쓸거니 멤버변수로 나올거고, 자동주입하면 된다
 * 3.vo는 의존할것인가. Service에 종속된 vo는 없다. vo는 dao와 커넥션사이를 위해서 혹은 vo내 쿼리위해서 쓰는건데
 * 사용자값은 클라이언트에서 생성되므로 여기서 vo객체를 생성할 일은 없다.
 * 4.vo는 자동주입할것인가. 이하 동문이다. 
 * 5.이 클래스는 빈등록 할 것인가.그렇다. 빈은 한번 생성해서 같은걸 여러번 쓰기 좋을 때 쓰는거다. 
 * 6.try캐치 할 것인가. 안해도된다. 보니까, try캐치나 if(!null)같은 처리는
 * 내 코드동작 안에서가 아니라 아예 다른..실수가능한 것과 통신할 떄 쓰는거같다. 사용자입력이나 디비네트워크연결같은..
 * 
 * 이 정도의 고민은 해야된다. 아무생각없이 동작순서 이해하고 왜 이렇게 짰는지 생각안하고
 * 무의식적으로 암기된대로 코드 비슷하게 짜면 그건 이해한게 아니다. 왜 그렇게 썼는지 알아야한다.
 * 이런 방식의 생각을 하기위해선 암것도 안보고 코딩해보면 된다. 안써도 되는걸 내가 이유가 있을때만 쓰게 되니까
 * 이유를 확실히 알게 된다
 * */

//왜 sql 켜져있을떄만 되는가
