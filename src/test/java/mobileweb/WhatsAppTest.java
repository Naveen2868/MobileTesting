package mobileweb;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobilewebpages.AppiumEnv;
import mobilewebpages.WhatsAppPage;

public class WhatsAppTest extends AppiumEnv {
	private AndroidDriver<AndroidElement> mobileDriver = null;
	static WhatsAppTest whatsAppTest = new WhatsAppTest();
	private WhatsAppPage whatsAppPage = null;
	private static Logger logger = LogManager.getLogger(WhatsAppTest.class);

	static {
		try {
			whatsAppTest.startRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WhatsAppTest() {
		super();
	}

	@BeforeClass
	public void beforSetup() throws MalformedURLException, InterruptedException {
		mobileDriver = setUp();
		whatsAppPage = new WhatsAppPage();
	}

	@Test(description = "Whats app testcase")
	public void navigateContact() throws InterruptedException, IOException {
		logger.info("Test case started***************************");
		whatsAppPage.clickOnAlert();
		whatsAppPage.agreeAndConitnueButton();
		whatsAppPage.clickOnDropDown();
		whatsAppPage.getCountriesNames("India");
		whatsAppPage.fillPhoneNo();
	}

	@AfterClass
	public void teardown() {
		if (mobileDriver != null) {
			System.out.println("******************************************************");
			System.out.println("Destroying Test Environment");
			mobileDriver.quit();
		}
		try {
			whatsAppTest.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Test case ended***************************");
	}
}
