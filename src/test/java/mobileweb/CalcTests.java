package mobileweb;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobilewebpages.AppiumEnv;
import mobilewebpages.CalcPage;

public class CalcTests extends AppiumEnv {

	AndroidDriver<AndroidElement> mobileDriver = null;
	CalcPage calcPage = null;

	public CalcTests() {
		super();
	}

	@BeforeClass
	public void beforSetup() throws MalformedURLException, InterruptedException {
		mobileDriver = setUp();
		calcPage = new CalcPage();
	}

	@Test
	public void plus() {
		calcPage.plus();
	}

	@Test
	public void subtraction() {
		calcPage.subtraction();
	}

	@Test
	public void devide() {
		calcPage.devide();
	}

	@Test
	public void multiplication() {
		calcPage.multiplication();
	}

	@Test
	public void clearResult() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Clear times: " + i);
			calcPage.clearResult();
		}
	}

	@Test
	public void goToHome() {
		calcPage.goToHome();
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			System.out.println("******************************************************");
			System.out.println("Destroying Test Environment");
			driver.quit();
		}
	}
}
