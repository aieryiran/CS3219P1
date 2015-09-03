/*
 * Student: Wen Yiran
 * Matric No: A0105610Y
 */

package ImplicitInvocation;

import java.util.Observable;
import java.util.ArrayList;

public class IILineStorage1 extends Observable {
	ArrayList<String> titleData;
	ArrayList<String> ignoreData;
	
	public IILineStorage1() {
		titleData = new ArrayList<String>();
		ignoreData = new ArrayList<String>();
		IICircularShift shifter = new IICircularShift(this);
		addObserver(shifter);
	}
	
	public void insert(ArrayList<String> titles, ArrayList<String> ignores) {
		titleData = titles;
		ignoreData = ignores;
		setChanged();
		notifyObservers();
	}
	
	public int getTitleSize() {
		return titleData.size();
	}
	
	public String getTitleByIndex(int index) {
		return titleData.get(index);
	}
	
	public ArrayList<String> getIgnore() {
		return ignoreData;
	}
	
	public void updateIgnore(ArrayList<String> newIgnore) {
		ignoreData = newIgnore;
	}
}
