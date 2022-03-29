
public class Main3 {

	public static void main(String[] args) {
		
//		arr에 저장된 정수의 합이 화면에 표시되도록 함수형 인터페이스
//		를 정의하고 활용해보세요.
		int[] arr = {1,2,3};
		exec(arr, nums -> {
			int total = 0;
			for(int i=0; i<nums.length; i++) {
				total += nums[i];
			}
			return total;
		});

	}

	@FunctionalInterface
	interface Operation {
		public int process(int[] nums);
	}
	
	static void exec(int[] arr, Operation op) {
		
		int total = op.process(arr);
		System.out.println("total = " + total);
	}
}
