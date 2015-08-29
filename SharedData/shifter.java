package SharedData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shifter {
	public Map<Integer, List<Integer>> circularShift(String[] titles, String[] ignore){
		String[] split;
		List<Integer> indices = new ArrayList<Integer>();
		Integer word_index, title_index;
		Map<Integer, List<Integer>> shifts = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < titles.length; i++){
			// Split the title into different strings
			split = titles[i].split(" ");
			
			// Check if each word in the title is an ignored word
			for(int j = 0; j < split.length; j++){
				for(int k = 0; k < ignore.length; k++){
					if(split[j].equals(ignore[k])){
						// Move on to the next word in the title
						break;
					}
					else {
						// Create a circular shift with the word's index in the title
						word_index = new Integer(titles[i].indexOf(split[j]));
						indices.add(word_index);
					}
				}
			}
			
			// Store the circular shifts for this title
			title_index = new Integer(i);
			shifts.put(title_index, indices);
			
			// Reset variables
			indices.clear();
		}
		
		return shifts;
	}
}
