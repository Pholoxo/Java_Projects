/**
 * This is a DotCom class
 * @author Max Morales
 *
 */
import java.util.*;
public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	//This sets the arraylist to loc
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
	
	public void setName(String n) {
		name = n;
		System.out.println();
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! You sunk " + name + " : ( " );
			}
			else {
				result = "hit";
			} // close if
		} // close if
		return result;
	} // close method
	
} // close class
