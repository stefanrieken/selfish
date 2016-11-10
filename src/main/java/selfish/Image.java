package selfish;

import java.util.ArrayList;
import java.util.List;

import selfish.type.Type;

public class Image {

	public List<SelfishObject> objects = new ArrayList<>();
	public Nametable names = new Nametable();

	public SelfishObject newObject(Type type, Object value) {
		SelfishObject obj = new SelfishObject(type, value);
		objects.add(obj);
		return obj;
	}
}
