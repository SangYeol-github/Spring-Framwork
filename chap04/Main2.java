import java.util.Date;

public class Main2 {

	public static void main(String[] args) {
		
		threadTest();
	}
	static void threadTest() {
		
//		VCPU(Virtual CPU) 에게 아래의 코드를 할당하고 실행하게 한다.
//		VCPU(Thread)에게 아래의 코드를 할당하려면 따라야 할 규칙이 있다.
//		Thread에게 전달할 코드는 Runnable 인터페이스를 구현해야 한다.
		
		class DataPrinter implements Runnable {

			@Override
			public void run() {
				
				while(true) {
					System.out.println(new Date());
					try {
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
			
		}
		class NumPrinter implements Runnable {

			@Override
			public void run() {
				
				int num = 0;
				while(true) {
					System.out.println(++num);
					try {
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
	
		}
		
//		new DataPrinter().run();
//		new NumPrinter().run();
		
		DataPrinter code1 = new DataPrinter();
		NumPrinter code2 = new NumPrinter();
		
		Thread t1 = new Thread(code1);
		Thread t2 = new Thread(code2);
		
		t1.start();
		t2.start();
	}
}
