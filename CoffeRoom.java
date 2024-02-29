package assignment3;

public class CoffeRoom extends Room {
	
	
    CoffeLine coffeLine;

   
    public CoffeRoom() {
        coffeLine = new CoffeLine();
        coffeLine.start(); 
    }
}
