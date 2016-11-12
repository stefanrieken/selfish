package selfish;

import java.util.ArrayList;
import java.util.List;

public class Nametable {
	private List<String> names = new ArrayList<>();
	
	public Nametable() {
		names.add(";"); // 0
	}

	public int add(String name) {
		if (names.contains(name) && !"".equals(name)) return names.indexOf(name);
		// else
		names.add(name);
		return names.size()-1;
	}
	
	public String lookup(int number) {
		return names.get(number);
	}

	public String toString() {
		return names.toString();
	}
}
