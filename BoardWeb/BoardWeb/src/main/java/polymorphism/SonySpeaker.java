package polymorphism;
import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("소니 생성");
	}
	public void volumeUp() {
		System.out.println("소니올려");
	}
	public void volumeDown() {
		System.out.println("소니내려");
	}
}
