package assignment3;

public class CoffeeMachine extends Thread {
	
	//synronized list of  coffee 
	private int reserve = 0;
	
	
	@Override
	public void run() {
		
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis()-startTime < Fika.simlationLength*1000) {

			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (reserve != 20) {
				reserve += 1;
				P.P("Drink created. Coffee Machine has "+reserve+" drinks in reserve.");
				
			}
			

		}
	}
	
	
	public int reserveget() {
		return this.reserve;
	}
	
	public void drinkcoffe() {
		this.reserve -= 1;
	}
}
