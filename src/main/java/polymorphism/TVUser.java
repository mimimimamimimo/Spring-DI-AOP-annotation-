package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser {

	public static void main(String[] args) {
		//TV samsungtv=new SamsungTV();
		//TV lgtv=new SamsungTV();
		//BeanFactory factory=new BeanFactory();
		//TV tv=(TV)factory.getBean(args[0]);  //잉?진짜 포문느낌으로 돌리려고 배열쓰네!!
		//tv.powerOn();   //참고로 args쓰는건 커맨드라인이라서 겉에서 넣어줘야함
		//tv.volumeUp();
	   //명심하자. 종류에 대한 코드를 명시한다는건 종류가 바뀔때 그 클래스를 직접 수정해줘야한다는걸 뜻하고, 그게  싫으면 빼내라.

		
		
		
		//자 빈을 등록하고 왔으니 BeanFactory대신에 진짜 빈 써보자. 스프링 구동은 스프링설정파일 구동으로 시작된다
		AbstractApplicationContext factory2=new GenericXmlApplicationContext("applicationContext.xml");
		//generic~~ : 파일시스템이나 클래스경로에 있는 xml파일 로딩
		TV tv3=(TV)factory2.getBean("lg");
		tv3.powerOn();
		tv3.volumeUp();
		/*스프링 구동하면 등록된 빈 객체 자동으로 적힌 순서대로 생성된다. 실제로 이 밑에 세 줄을 지워도 객체는 생성이 된다
		tv3 코드가 밑에 있으면 어떻게 될까?
		samsung클래스에는 컴포넌트 지정을 안해뒀다. 하지만 getbean때문에 samsung빈을 찾으려 할 것이고 그럼 
		에러가 나서 코드가 수행되지않는다. 근데 그렇다고 삼성을 무작정 빈으로 등록하면 삼성tv생성되면서
		생성자 작동해서 스피커도 넣어야하는데 파라미터를 받는 부분을 auto가 해야되서 소니도 등록해줘야한다. 
		빈 등록하면 무조건 먼저 생성되고 의존되있는거도 같이 등록되니까 등록시 조심~
		*/
		TV tv2=(TV)factory2.getBean("samsung");  //잉?진짜 포문느낌으로 돌리려고 배열쓰네!!
		tv2.powerOn();
		//실행시키면 @달려있는거 바로 객체생성 한꺼번에 되고 안되있는건 안되네.메모리 문제 안생기나..
		
		factory2.close(); //컨테이너 팩토리																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																ㄷ 종료
	}

}
