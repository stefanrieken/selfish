package selfish.type;

import java.lang.reflect.Method;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.ParseException;
import selfish.parser.SelfishLexer;
import selfish.parser.SelfishReader;

public class ReflectiveType implements Type {

	public static ReflectiveType instance = new ReflectiveType();

	public void invoke(Image image, Association meth, Stack<SelfishObject> stack) {
		String methName = (String) meth.value.value;
		
		SelfishObject ctx = stack.pop();
		Object target = ctx.type;
		
		try {
			Method m = target.getClass().getMethod(methName, SelfishObject.class, Image.class, Stack.class);
			m.invoke(target, ctx, image, stack);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peekNonWs() != '#') return null;
		rd.next();
		String value = SelfishLexer.readName(rd);
		if (value == null) throw new ParseException("expected name", rd);
		return image.newObject(this, value);
	}
	
	@Override
	public String getName() {
		return "primitive";
	}
}
