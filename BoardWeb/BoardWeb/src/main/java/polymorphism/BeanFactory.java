package polymorphism;

public class BeanFactory {  //이게 왜 생성코드를 줄여주는거지..어차피 이 클래스 생성하고 이름만 갖다바꾸는건데.
	public Object getBean(String beanName) {  //차라리 이름바꾸는거 포문으로 하면서 생성해가면 몰ㄹ...
		if(beanName.equals("samsung")) {
			return new SamsungTV(new SonySpeaker(),270000);
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;  //다 아닐땐 null리턴
	}  //이런 팩토리를 스프링에선 컨테이너라고 하고, 컨테이너 등록이 가능하다. 컨테이너는 마치 서블릿 컨테이너와 비슷하다.
}   //서블릿페이지 대신 메소드가 들어있을 뿐이다. 컨테이너 등록하려면 스프링 써야하고, 스프링플젝에 sts가 자동적으로 pom에 스프링 모듈 추가해주고
//스프링도 스프링만의 설정파일인 aptx에서 빈을 등록해준다.
