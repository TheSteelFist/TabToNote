import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 * This program converts tabs to musical notes
 * </p>
 * @author Divesh
 *
 */
public class TabToChord {
	public static String string;
	public static Integer fret;
	public static Map<Integer, String> chords = new HashMap<Integer, String>();
	
	/**
	 * <p>
	 * Initialising the musical notes
	 * </p>
	 */
	public static void init() {
		chords.put(0, "C");
		chords.put(1, "C#");
		chords.put(2, "D");
		chords.put(3, "D#");
		chords.put(4, "E");
		chords.put(5, "F");
		chords.put(6, "F#");
		chords.put(7, "G");
		chords.put(8, "G#");
		chords.put(9, "A");
		chords.put(10, "A#");
		chords.put(11, "B");
	}
	/**
	 * <p>
	 * This method calculates the musical chord by taking in the tab notation
	 * </p>
	 * @param string is the string name
	 * @param tab is the fret number
	 */
	public static void calculate(String string, Integer fret){
		if (!chords.containsValue(string)) {
			throw new IllegalArgumentException("Error! Please enter the correct string name");
		} else {
			Integer tabNum = 0, actualTab;
			for (Integer i : chords.keySet()) {
				if (chords.get(i).equals(string)) {
					tabNum = i;
				}
			}
			actualTab = (tabNum + fret)%12;
			System.out.println("The Note for "+ string + fret +" is: "+chords.get(actualTab));
		}
	}
	
	public static void main(String[] args) {
		init();
		Scanner s = new Scanner(System.in);
		System.out.print("Please input the string name: ");
		string = s.next().toUpperCase();
		System.out.print("Please input the fret number: ");
		fret = s.nextInt();
		calculate(string, fret);
		s.close();
	}
}
