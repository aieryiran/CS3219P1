package SharedData;

public class output {
	public void printTitles(String[] titles){
		String title;
		int first_word;
		System.out.println("Outputting list of circularly shifted titles:");
		
		for(int i = 0; i < titles.length; i++){
			// Capitalize the first word
			first_word = titles[i].indexOf(" ");
			title = titles[i].substring(0, first_word).toUpperCase() + titles[i].substring(first_word);
			
			System.out.println(title);
		}
	}
}
