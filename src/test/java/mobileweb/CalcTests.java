package mobileweb;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

	@Test(priority = 1)
	public void plus() {
		calcPage.plus();
	}

	@Test(priority = 2)
	public void subtraction() {
		calcPage.subtraction();
	}

	@Test(priority = 3)
	public void devide() {
		calcPage.devide();
	}

	@Test(priority = 4)
	public void multiplication() {
		calcPage.multiplication();
	}

	@AfterMethod
	public void clearResult() {
		for (int i = 1; i <= 4; i++) {
			calcPage.clearResult();
		}
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
