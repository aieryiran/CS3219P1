/*
 * Student: Wen Yiran
 * Matric No: A0105610Y
 */

package ImplicitInvocation;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class IICircularShift extends Observable implements Observer  {
	private IILineStorage1 line1;
	private IILineStorage2 line2;
	
	public IICircularShift(IILineStorage1 lineStorage1) {
		this.line1 = lineStorage1;
		IIAlphabetizer alpha = new IIAlphabetizer(this);
		addObserver(alpha);
		line2 = IILineStorage2.getInstance();
	}
	
	@Override
	public void update(Observable lineStorage1, Object arg) {
		line1 = (IILineStorage1) lineStorage1;
		changeIgnoreToLowercase();
		updateLineStorage2();
	}
	
	private void updateLineStorage2() {
		int titleSize = line1.getTitleSize();
		
		for (int i = 0; i < titleSize; i++) {
			String currentTitle = line1.getTitleByIndex(i);
			String[] components = currentTitle.split(" ");
			for (int j = 0; j < components.length; j++) {
				StringBuilder newString = new StringBuilder();
				int index = j, count = 0;
				if (line1.getIgnore().contains(components[j].toLowerCase())) {
					continue;
				}
				while (count < components.length) {
					if (index >= components.length) {
						index = 0;
					}
					newString.append(components[index] + " ");
					index++;
					count++;
				}
				String capitalized = newString.substring(0, 1).toUpperCase() + newString.substring(1);
				line2.insertLine(capitalized);
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	private void changeIgnoreToLowercase() {
		ArrayList<String> ignore = line1.getIgnore();
		for (int i = 0; i < ignore.size(); i++) {
			ignore.set(i, ignore.get(i).toLowerCase());
		}
		line1.updateIgnore(ignore);
	}
}
