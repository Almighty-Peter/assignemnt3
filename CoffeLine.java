package assignment3;
import java.util.Random;


public class CoffeLine extends Thread {
	
	CoffeeMachine coffeeMachine;
	
    public CoffeLine() {
    	coffeeMachine = new CoffeeMachine();
    	coffeeMachine.start(); 
    }
	
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis()-startTime < Fika.simlationLength*1000) {
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
			if (coffeeMachine.reserveget() > 0) {
				if (Fika.coffeRoom.getPersons().isEmpty() == false) {
					
					coffeeMachine.drinkcoffe();
					
					Worker person = Fika.coffeRoom.getPersons().get(0);
					randomCoffe(person);
					
					
					Fika.coffeRoom.getPersons().remove(0);
					Fika.coffeRoom.getPersons().add(person);
				}
				
			}

			
			
		}
	}
	
	private void randomCoffe(Worker person) {
		Random random = new Random();
		int type = random.nextInt(2+1);

		
		Coffee coffee = null;
		
		switch(type)
		{
		case 0:
			coffee = new BlackCoffee();
			break;
		case 1:
			coffee = new Capuccino();
			break;
		case 2:
			coffee = new Latte();
			break;
		}

		
		int ranInt = coffee.getEnergy();
		person.addEnergyLevel(ranInt);
		P.P(person.getWorker()+" enjoyed a "+coffee.getType()+" with "+ranInt+" energy");
		
	}
}
