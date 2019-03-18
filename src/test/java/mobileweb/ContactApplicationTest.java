package mobileweb;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobilewebpages.AppiumEnv;
import mobilewebpages.ContactPage;

public class ContactApplicationTest extends AppiumEnv {
	
	AndroidDriver<AndroidElement> mobileDriver = null;
	ContactPage contactPage = null;
	static ContactApplicationTest contactApplicationTest = new ContactApplicationTest();
	
	static{
		try {
			contactApplicationTest.startRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ContactApplicationTest() {
		super();
	}

	@BeforeClass
	public void beforSetup() throws MalformedURLException, InterruptedException {
		mobileDriver = setUp();
		contactPage = new ContactPage();
	}

	@Test(description = "Navigating to contact and adding new contact")
	public void navigateContact() throws InterruptedException, IOException {
		contactPage.addNewContact();
	}

	@AfterClass
	public void teardown() {
		if (mobileDriver != null) {
			System.out.println("******************************************************");
			System.out.println("Destroying Test Environment");
			mobileDriver.quit();
		}
		try {
			contactApplicationTest.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
