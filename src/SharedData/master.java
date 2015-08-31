package SharedData;

import java.util.HashMap;
import java.util.List;

public class master {
	public void kwic(){
		String[][] input_arrays;
		HashMap<Integer, List<Integer>> shifts;
		String[] sorted_titles;
		
		input in = new input();
		shifter shift = new shifter();
		alphabetizer a = new alphabetizer();
		output o = new output();
		
		input_arrays = in.getInput();
		shifts = shift.circularShift(input_arrays[0], input_arrays[1]);
		sorted_titles = a.alphabetize(shifts, input_arrays[0]);
		o.printTitles(sorted_titles);
	}
}
