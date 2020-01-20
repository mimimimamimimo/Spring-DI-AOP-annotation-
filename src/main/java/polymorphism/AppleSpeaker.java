package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")  //꼭 네임 지정해주자. 안해도 돌아갈수도 있지만 겟빈할떄 이런 아이디로 찾기 때문이다. error 났었음
public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("애플 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("애플높여");
	}

	@Override
	public void volumeDown() {
		System.out.println("애플내려");
	}
	
}
