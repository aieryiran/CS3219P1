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
		
		while (true) {
			System.out.println("Enter filename and extension of titles file:");
			titlePath = in.nextLine();
			System.out.println("Enter filename and extension of words to ignore file:");
			ignorePath = in.nextLine();
			
			try {
				titleData = openFile(titlePath);
				ignoreData = openFile(ignorePath);
			}
		    catch (Exception IOException) {
		    	System.out.println("Error occurs during opening the file. Please try again.");
		    }
			
			if ((titleData != null) && (ignoreData != null)) {
				break;
			}
		}
		
		IILineStorage1 line1 = new IILineStorage1();
		line1.insertTitle(titleData);
		line1.insertIgnore(ignoreData);
		/*for (int i = 0; i < titleData.size(); i++) {
			line1.insertLine(titleData.get(i));
		}
		for (int j = 0; j < ignoreData.size(); j++) {
			line1.insertIgnore(ignoreData.get(j));
		}*/
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
		/*
		String[] dataArray = data.toArray(new String[0]);
		return dataArray;
		*/
	}
}
