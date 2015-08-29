import java.util.Scanner;

//User selects architecture type here
public class main {
	public static void main(String args[]) {
		String s;
		boolean hasInput = false;
		Scanner in = new Scanner(System.in);
		
		while(!hasInput){
			System.out.println("Enter 1 to select Architecture 1 or 2 to select Architecture 2");
			s = in.nextLine();
			
			if(s.equals("1")){
				useA1();
				hasInput = true;
			}
			else if(s.equals("2")){
				useA2();
				hasInput = true;
			}
			else {
				System.out.println("Invalid input");
			}
		}
		
		in.close();
	}
	
	static void useA1() {

	}
	
	static void useA2() {
		
	}
}
