package ImplicitInvocation;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class IIAlphabetizer implements Observer {
	private IICircularShift shifter;
	private IILineStorage2 line2;
	
	public IIAlphabetizer(IICircularShift circularShift) {
		this.shifter = circularShift;
		line2 = IILineStorage2.getInstance();
	}
	
	public void update(Observable circularShift, Object arg) {
		alphabetize();
	}
	
	private void alphabetize() {
		int lineSize = line2.getLineSize();
		
		for (int i = 0; i < lineSize; i++) {
			for (int j = i+1; j < lineSize; j++) {
				if(line2.getLineByIndex(i).compareTo(line2.getLineByIndex(j))>0){
					String temp;
		            temp=line2.getLineByIndex(i);
		            line2.setLineByIndex(i, line2.getLineByIndex(j));
		            line2.setLineByIndex(j, temp);
		        }
			}
		}
	}
}
