package assignment3;

import java.util.Random;

public class Coffee {
	protected String type;
	protected int range;
	protected int minimum;
	
	public int getEnergy() {
		Random random = new Random();
		return random.nextInt(range+1)+minimum;
	}
	
	public String getType() {
		return this.type;
	}
}
