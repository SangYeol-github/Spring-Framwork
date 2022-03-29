
@FunctionalInterface
interface MyInterface { // 함수형 인터페이스 -> method가 하나
	
	void println(String msg);
//	void printMsg();
}

// 인터페이스를 사용하는 방법 1
// 인터페이스를 구현한 클래스를 정의한다.
class ImplMyinterface implements MyInterface {

	@Override
	public void println(String msg) {
		System.out.println(msg);
		
	}
	
}

public class Main1 {

	public static void main(String[] args) {
		MyInterface mi = new ImplMyinterface();
		mi.println("Hello");
		
//		인터페이스를 구현한 익명 클래스를 선언하고 사용하는 방법
//		Anonymous Class(이름 없는 클래스 선언/ 인스턴스 생성/사용)
		MyInterface m1 = new MyInterface() {

			@Override
			public void println(String msg) {
				System.out.println(msg);
				
			}
			
		}/* .println("익명 클래스 테스트") */;
//		인터페이스 구현한 클래스 정의, 인스턴스 생성, 메소드 호출
		
		m1.println("익명 클래스");
		
//		Lambda 표현식으로 함수형 인터페이스를 구현하는 예
		MyInterface mi2 = msg -> System.out.println(msg);
		mi2.println("람다식으로 표현한 익명 클래스");
		
//		test("테스트",mi2);
		test("테스트",(msg) -> {
			System.out.println(msg);
//			여러개의 문장 정의 가능
			return;
			} );

	}
	static void test(String msg, MyInterface mi) {
		
		mi.println(msg);
	
	}

}
