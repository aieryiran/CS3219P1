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
				if (line1.getIgnore().contains(components[j])) {
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
				line2.insertLine(newString.toString());
			}
		}
		
		setChanged();
		notifyObservers();
	}
}
