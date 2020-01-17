package polymorphism;

import org.springframework.stereotype.Component;


public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	public SamsungTV(Speaker speaker,int price) {
		this.speaker=speaker;  //xml봐라
		this.price=price;
		System.out.println("생성자주입");
	}
	public void powerOn(){
		System.out.println("삼성킨다. 가격:"+price);
	}
public void powerOff(){
	System.out.println("삼성끈다");
	}
public void volumeUp(){
	System.out.println("삼성볼륨업");
	//speaker=new SonySpeaker();   
	speaker.volumeUp();
}
public void volumeDown(){
	System.out.println("삼성볼륨다운");
	//speaker=new SonySpeaker();   //다른 클래스인 스피커클래스에 의존성이 생겼을때, 이렇게 여기서 코드로 생성하면 스피커 바꾸기 힘들고 객체 두 개나 생성되니 생성자 주입으로 다른 곳으로뺀다.
	speaker.volumeDown();
}
	public void initMethod(){  //xml파일봐라
		System.out.println("삼성객체 초기화중..");
	}
	public void destroyMethod(){
		System.out.println("삼성객체 파괴전 처리중..");
	}
}
