package polymorphism;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV{

	@Autowired   //빈 직접 생성할땐 생성자 주입으로 객체 직접 넣어줬지만 auto쓰면 선언만 해도 생성자 적을 필요 없이 넣을 수 있는거 빈중에서 알아서 넣어줌(samsung과 비교 ㄱㄱ)
	//즉, 빈 직접 주입할땐 생성자도 직접 적고 파라미터 있으면 constructor 값 넣어서 달아줬는데 어노테이션 쓰면 그걸 어디 선언하냐는거지. autowired한다이거야
	//물론 apple,소니 둘다 빈등록 되있으면 충돌나겠지만 하난 xml로 빈등록해두면 auto로 되있는거로 지정되고, 그렇게 하면 xml 부담도 줄여진다.
	
	@Qualifier("apple")//대신 같은 타입 여러개면 안되니까 조금 명확히 해줘야할땐 퀄리파~
	private Speaker speaker;
	public void powerOn(){
		System.out.println("lg킨다");
	}
	public void powerOff(){
		System.out.println("lg끈다");
		}
	public void volumeUp(){
		speaker.volumeUp();
		System.out.println("lg볼륨업");
	}
	public void volumeDown(){
		speaker.volumeDown();
		System.out.println("lg볼륨다운");
	}
}
