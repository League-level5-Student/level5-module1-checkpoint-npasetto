
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		Thread r1=new Thread(()->SlowFunctions.slowSortLargeArray());
		Thread r2=new Thread(()->SlowFunctions.ackermann(3, 15));
		Thread r3=new Thread(()->SlowFunctions.millionsOfSqrts());
		r1.start();
		r2.start();
		r3.start();
		try {
			r1.join();
			r2.join();
			r3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
