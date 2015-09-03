/*
 * Student: Wen Yiran
 * Matric No: A0105610Y
 */

package ImplicitInvocation;

public class IIOutput {
	public void outputResults() {
		IILineStorage2 line2 = IILineStorage2.getInstance();
		
		int lineSize = line2.getLineSize();
		for (int i = 0; i < lineSize; i++) {
			System.out.println(line2.getLineByIndex(i));
			if ((i % 10 == 0) && (i != 0)) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
