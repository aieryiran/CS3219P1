package SharedData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class alphabetizer {
	public String[] alphabetize(HashMap<Integer, List<Integer>> shifts, String[] titles){
		ArrayList<String> alphabetized_titles = new ArrayList<String>();
		String shifted;
		List<Integer> shifts_index;
		
		for(int i = 0; i < titles.length; i++){
			Integer temp = new Integer(i);
			shifts_index = shifts.get(temp);
			
			for(int j = 0; j < shifts_index.size(); j++){
				shifted = shiftTitle(titles[i], shifts_index.get(j).intValue());
				alphabetized_titles = insertTitle(shifted, alphabetized_titles);
			}
		}
		
		String[] s = new String[0];
		return alphabetized_titles.toArray(s);
	}
	
	public String shiftTitle(String original, int index){
		String shifted;
		
		if(index == 0){
			shifted = original;
		}
		else {
			shifted = original.substring(index) + " " + original.substring(0,index-1);
		}
		
		return shifted;
	}
	
	public ArrayList<String> insertTitle(String shifted, ArrayList<String> alphabetized_titles){
		char title_char, array_char;
		int char_index = 0;
		int result;
		boolean doneComparing;
		
		if(alphabetized_titles.size() == 0){
			alphabetized_titles.add(shifted);
		}
		else {
			// Use insertion sort to insert the title into its correct position
			for(int i = 0; i < alphabetized_titles.size(); i++){
				doneComparing = false;
								
				while(!doneComparing){
					title_char = shifted.charAt(char_index);
					array_char = alphabetized_titles.get(i).charAt(char_index);
					result = compare(title_char, array_char);
										
					if(result == 1){
						// The title should be inserted somewhere after the current element
						// If it is the last element, insert after it
						// Else, continue to the next element
						if(i == alphabetized_titles.size()-1){
							alphabetized_titles.add(i+1, shifted);
							return alphabetized_titles;
						}
						else {
							doneComparing = true;
						}
					}
					else if (result == -1){
						// The title is smaller than the current element; insert it here
						// All other elements are shifted by 1 element
						alphabetized_titles.add(i, shifted);
						return alphabetized_titles;
					}
					else {
						// The title matches the current element for this char
						// Continue comparing with the next character
						char_index++;
					}
				}
			}
		}
		
		return alphabetized_titles;
	}
	
	public int compare(char title_char, char array_char){
		if(title_char > array_char){
			return 1;
		}
		else if(title_char < array_char){
			return -1;
		}
		else {
			return 0;
		}
	}	
}
