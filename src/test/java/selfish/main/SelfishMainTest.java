package selfish.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SelfishMainTest {
	
	@Test
	public void testSelfishMain() {
		assertEquals(42, SelfishMain.main(new String[]{"src/test/resources/examples/42.selfish"}));
	}
}
