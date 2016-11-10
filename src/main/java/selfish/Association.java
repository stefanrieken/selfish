package selfish;

public class Association {
	public SelfishObject attr;
	public SelfishObject value;

	public Association(SelfishObject attr, SelfishObject value) {
		this.attr = attr;
		this.value = value;
	}
	
	public String toString() {
		if (value == null) return "<null>";
		return value.toString();
	}
}
