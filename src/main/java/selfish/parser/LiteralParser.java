package selfish.parser;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.type.BlockType;
import selfish.type.IntegerType;
import selfish.type.ReflectiveType;
import selfish.type.StringType;
import selfish.type.Type;

/* Parses and returns object literals. Does not add to the current object */
public class LiteralParser {

	static Type[] literalTypes = new Type[] {
			BlockType.instance,
			IntegerType.instance,
			StringType.instance,
			ReflectiveType.instance
	};

	public static SelfishObject parseLiteral(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		for (Type type : literalTypes) {
			SelfishObject obj = type.parse(rd, code, image, current);
			if (obj != null) return decorate(image, obj);
		}
		
		return null;
	}
	
	public static SelfishObject decorate(Image image, SelfishObject obj) {
		SelfishObject parent = findObject(image, "selfish", obj.type.getName());
		if (parent != null)
			obj.assocs.put(-image.names.add("parent"), new Association(null, parent));
		
		return obj;
	}

	public static SelfishObject findObject(Image image, String ... path) {
		SelfishObject obj = image.objects.get(0);
		if (obj == null) return null;
		
		for (String entry : path) {
			Association assoc = obj.lookup(image.names.add(entry), false);
			if (assoc == null) return null;
			obj = assoc.value;
		}
		
		return obj;
	}

}
