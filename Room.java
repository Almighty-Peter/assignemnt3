package assignment3;
import java.util.List;
import java.util.ArrayList;


public class Room {
	private List<Worker> persons = new ArrayList<Worker>();

	public List<Worker> getPersons() {
		return persons;
	}

	public void setPersons(List<Worker> persons) {
		this.persons = persons;
	}
	
	public List<Worker> move(Worker person,List<Worker> otherRoom) {
		this.persons.remove(person);
		otherRoom.add(person);
		return otherRoom;
	}
}
