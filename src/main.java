import java.util.Scanner;
import SharedData.*;
import ImplicitInvocation.*;

//User selects architecture type here
public class main {
	public static void main(String args[]){
		String s;
		boolean hasInput = false;
		Scanner in = new Scanner(System.in);
		
		while(!hasInput){
			System.out.println("Enter 1 to select Shared Data Architecture or 2 to select Implicit Invocation Architecture");
			s = in.nextLine();
			
			if(s.equals("1")){
				useSharedData();
				hasInput = true;
			}
			else if(s.equals("2")){
				useImplicitInvocation();
				hasInput = true;
			}
			else {
				System.out.println("Invalid input");
			}
		}
		
		in.close();
	}
	
	static void useSharedData(){
		master SD = new master();
		SD.kwic();
	}
	
	static void useImplicitInvocation(){
		IIMaster II = new IIMaster();
		II.KWIC();
	}
}
