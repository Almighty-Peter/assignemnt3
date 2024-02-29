package assignment3;
import java.util.List;
import java.util.Random;


public class Worker extends Thread { 
	private String name;
	private int energyLevel;
	private int T;
	
	public Worker(String name) {
        this.name = name;
    }
	
	public void wakeUp() {
		Random random = new Random();
		this.energyLevel = random.nextInt(60 + 1) + 30;
		this.T = random.nextInt(1000 + 1) + 500;
	}
	
	
	public String getWorker() {
		return name;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void addEnergyLevel(int energyLevel) {
		this.energyLevel += energyLevel;
	}

	public int getT() {
		return T;
	}
	
	@Override
	public void run() {
		
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis()-startTime < Fika.simlationLength*1000) {
		
			
			try {
				Thread.sleep(T);
			} catch (InterruptedException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//energyLevel < 30 --> coffee room
			//energyLevel < 0 --> home
			//energyLevel >= 100 --> work
			
			
			
			if (Fika.office.getPersons().contains(this)) {
				
				if (energyLevel <= 30) {
					Fika.office.move(this,Fika.coffeRoom.getPersons());
				}
				
				P.P(this.name+" is working with energy level "+this.energyLevel);
				
				energyLevel -= 1;
				
			}
			
			
			else if (Fika.coffeRoom.getPersons().contains(this)) {
				
				if (energyLevel >= 100) {
					Fika.coffeRoom.move(this,Fika.office.getPersons());
					P.P(this.name+" goes back to work with energy level "+this.energyLevel);
				}
				else if (energyLevel <= 0) {
					P.P(this.name+" went home");
					Fika.coffeRoom.move(this,Fika.home.getPersons());
				}
				
				else {
					P.P(this.name+" is taking a break with energy level "+this.energyLevel);
				}
				energyLevel -= 1;
				
			}
			
			
			

			
			
		}

	}
}

