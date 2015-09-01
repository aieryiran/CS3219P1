package ImplicitInvocation;

public class IIOutput {
	public void outputResults() {
		IILineStorage2 line2 = IILineStorage2.getInstance();
		
		int lineSize = line2.getLineSize();
		for (int i = 0; i < lineSize; i++) {
			System.out.println(line2.getLineByIndex(i));
		}
	}
}
