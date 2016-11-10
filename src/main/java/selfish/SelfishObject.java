package selfish;

import java.util.HashMap;
import java.util.Map;

import selfish.type.Type;

public class SelfishObject {
	public Map<Integer,Association> assocs = new HashMap<>();
	public Type type;
	public Object value;
	
	public SelfishObject(Type type, Object value) {
		this.type = type;
		this.value = value;
	}

	public Association lookup(int number) {
		Association assoc = assocs.get(Math.abs(number));
		if (assocs != null) return assoc;

		for (Map.Entry<Integer,Association> entry : assocs.entrySet()) {
			if (entry.getKey() < 0) {
				assoc = entry.getValue().value.lookup(number);
				if (assoc != null) return assoc;
			}
		}
		
		return null;
	}

	public String toString() {
		return value == null ? "<null>" : value.toString();
	}
}
