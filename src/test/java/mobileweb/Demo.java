package mobileweb;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
		Assert.assertFalse(true);
	}

	@Test
	public void test3() {
		System.out.println("test3");
		Assert.assertFalse(true);
	}

	@Test
	public void test4() {
		System.out.println("test4");
	}
}
