package mobileweb;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobilewebpages.AppiumEnv;

public class Appium_01_FacebookLogin extends AppiumEnv {
	public Appium_01_FacebookLogin() {
		super();
	}

	AndroidDriver<AndroidElement> driver = null;

	@BeforeClass
	public void beforSetup() throws MalformedURLException, InterruptedException {
		driver = setUp();
	}

	@Test
	public void facebookLoginPageCheck() {
		driver.navigate().to("https://m.facebook.com");
		System.out.println("Title " + driver.getTitle());
		if (driver.getTitle().contains("Facebook")) {
			System.out.println(driver.getTitle() + " opened successfully");
		} else {
			System.out.println("Facebook page failed to load");
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("******************************************************");
			System.out.println("Destroying Test Environment");
			driver.quit();
		}
	}

}
