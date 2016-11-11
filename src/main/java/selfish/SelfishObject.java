package selfish;

import java.util.HashMap;
import java.util.Map;

import selfish.type.Type;

public class SelfishObject {
	public Map<Integer,Association> assocs = new HashMap<>();
	public Type type;
	public Object value;
	
	protected SelfishObject(Type type, Object value) {
		this.type = type;
		this.value = value;
	}

	public static SelfishObject temporal(Type type, Object value) {
		return new SelfishObject(type, value);
	}

	public Association lookup(int number, boolean recursive) {
		Association assoc = assocs.get(number);
		if (assoc == null && number > 0) assoc = assocs.get(-number);
		if (assoc != null) return assoc;
		if (!recursive) return null;

		for (Map.Entry<Integer,Association> entry : assocs.entrySet()) {
			if (entry.getKey() < 0) {
				assoc = entry.getValue().value.lookup(number, true);
				if (assoc != null) return assoc;
			}
		}
		
		return null;
	}

	public String toString() {
		return value == null ? "<null>" : value.toString();
	}
}
