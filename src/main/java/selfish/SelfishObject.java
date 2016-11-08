package selfish;

import java.util.HashMap;
import java.util.Map;

import selfish.type.Type;

public class SelfishObject {
	public Map<String,Association> assocs = new HashMap<>();
	public Type type;
	public Object value;
	
	public SelfishObject(Type type, Object value) {
		this.type = type;
		this.value = value;
	}
	
	public String toString() {
		return value == null ? "<null>" : value.toString();
	}
}
