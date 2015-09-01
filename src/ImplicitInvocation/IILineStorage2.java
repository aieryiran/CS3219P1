package ImplicitInvocation;

import java.util.ArrayList;

public class IILineStorage2 {
	private ArrayList<String> stringData;
	
	private IILineStorage2() {
		stringData = new ArrayList<String>();
	}
	
	private static class SingletonHolder { 
		private static final IILineStorage2 INSTANCE = new IILineStorage2();
	}

	public static IILineStorage2 getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public void insertLine(String line) {
		stringData.add(line);
	}
	
	public String getLineByIndex(int index) {
		return stringData.get(index);
	}
	
	public int getLineSize() {
		return stringData.size();
	}
	
	public void setLineByIndex(int index, String line) {
		stringData.set(index, line);
	}
}
