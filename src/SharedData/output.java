package SharedData;

public class output {
	public void printTitles(String[] titles){
		System.out.println("Outputting list of circularly shifted titles:");
		for(int i = 0; i < titles.length; i++){
			System.out.println(titles[i]);
		}
	}
}
