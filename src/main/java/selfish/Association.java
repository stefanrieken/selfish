package selfish;

public class Association {
	public SelfishObject attr;
	public SelfishObject type;
	public SelfishObject value;

	public Association(SelfishObject attr, SelfishObject type, SelfishObject value) {
		this.attr = attr;
		this.type = type;
		this.value = value;
	}
	
	public String toString() {
		if (value == null) return "<null>";
		return value.toString();
	}
}
