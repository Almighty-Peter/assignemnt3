package assignment3;

import java.util.ArrayList;
import java.util.List;

public class Fika {

	public static void main(String[] args) {
		Fika fika = new Fika();
        fika.startSimulation();


	}
	

	public static int simlationLength = 20;
	
	public static Room home = new Room();
	public static CoffeRoom coffeRoom = new CoffeRoom();
	public static Room office = new Room();
	
	public static void startSimulation() {
		
		String[] names = {"Axel","Edwa","Emil","Nils","Moha","Pita","Mimi","Alhu","Moaa","Zeus","Apol","Omar"};	
		
		for (String name : names) {
			Worker person = new Worker(name);
			person.wakeUp();
			person.start();
		    office.getPersons().add(person);
		}
	}
}
