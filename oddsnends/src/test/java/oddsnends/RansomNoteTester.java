package oddsnends;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OddsAndEndsTester {

	@Before
	public void setUp() throws Exception { }

	@Test
	public void instantiationTest1a() {
		LambdaInterface lambdaExImpl = (what, howMany) -> what +" " +howMany +" times";
		System.out.print("\n" +lambdaExImpl.doSomething ("Did it", 3) );
		assertTrue(true);
	}

	@Test
	public void instantiationTest1b() {
		LambdaInterface lambdaExImpl = (String s, int i) -> s +" " +i +" times";
		System.out.print("\n" +lambdaExImpl.doSomething ("Did it", 3) );
		assertTrue(true);
	}

	@Test
	public void instantiationTest2() {
		LambdaInterface lambdaExImpl = (what, howMany) -> "Didn't " +what +" " +howMany +" times";
		System.out.print("\n" +lambdaExImpl.doSomething ("do it", 2) );
		assertTrue(true);
	}

}
