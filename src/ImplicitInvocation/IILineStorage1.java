package ImplicitInvocation;

import java.util.Observable;
import java.util.ArrayList;

public class IILineStorage1 extends Observable {
	ArrayList<String> titleData;
	ArrayList<String> ignoreData;
	ArrayList<String> circularData;
	
	public IILineStorage1() {
		titleData = new ArrayList<String>();
		ignoreData = new ArrayList<String>();
		IICircularShift shifter = new IICircularShift(this);
		addObserver(shifter);
	}
	
	public void insertTitle(ArrayList<String> titles) {
		titleData = titles;
		//setChanged();
		//notifyObservers();
	}
	
	public void insertIgnore(ArrayList<String> ignores) {
		ignoreData = ignores;
		setChanged();
		notifyObservers();
	}
	
	public int getTitleSize() {
		return titleData.size();
	}
	
	/*public void insertLine(String line) {
		titleData.add(line);	
		setChanged();
		notifyObservers();
	}
	
	public void insertIgnore(String ignore) {
		ignoreData.add(ignore);
		setChanged();
		notifyObservers();
	}*/
	
	public String getTitleByIndex(int index) {
		return titleData.get(index);
	}
	
	public ArrayList<String> getIgnore() {
		return ignoreData;
	}
}
