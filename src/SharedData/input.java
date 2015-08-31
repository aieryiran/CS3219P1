package SharedData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class input {
	public String[][] getInput(){
		String[][] arrays = new String[2][];
		String[] titles_arr, ignore_arr;

		titles_arr = readFromFile("titles");
		arrays[0] = titles_arr;
		
		ignore_arr = readFromFile("words to ignore");
		arrays[1] = ignore_arr;
		
		return arrays;
	}
	
	private String[] readFromFile(String type){
		Scanner in = new Scanner(System.in);
		String file, input;
		List<String> input_arr = new ArrayList<String>();
		boolean done = false;
		
		while(!done){
			System.out.println("Enter filename and extension of "+type+" file:");
			file = in.nextLine();
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				while((input = br.readLine()) != null){
					input_arr.add(input);
				}
				
				done = true;
			}
			catch (IOException e) {
				System.out.println("There was an error reading from the file. Please try again.");
			}
		}
		
		String[] string_arr = new String[0];
		return input_arr.toArray(string_arr);
	}
}
