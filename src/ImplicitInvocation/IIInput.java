/*
 * Student: Wen Yiran
 * Matric No: A0105610Y
 */

package ImplicitInvocation;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class IIInput {
	public void getInput() {
		String titlePath, ignorePath;
		Scanner in = new Scanner(System.in); 
		ArrayList<String> titleData = null, ignoreData = null;
		IILineStorage1 line1 = new IILineStorage1();
		
		while (true) {
			if (titleData == null) {
				System.out.println("Enter filename and extension of titles file:");
				titlePath = in.nextLine();
				
				try {
					titleData = openFile(titlePath);
				}
			    catch (Exception IOException) {
			    	System.out.println("Error occurs during opening the file. Please try again.");
			    	continue;
			    }
			}
			
			if (ignoreData == null) {
				System.out.println("Enter filename and extension of words to ignore file:");
				ignorePath = in.nextLine();
				
				try {
					ignoreData = openFile(ignorePath);
				}
			    catch (Exception IOException) {
			    	System.out.println("Error occurs during opening the file. Please try again.");
			    	continue;
			    }
			}
			
			break;
		}
		
		line1.insert(titleData, ignoreData);
	}
	
	private ArrayList<String> openFile(String path) throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		String currentLine;
		
		ArrayList<String> data = new ArrayList<String>();
		while ((currentLine = textReader.readLine()) != null) {
		    data.add(currentLine);
		}
		
		textReader.close();
		return data;
	}
}
