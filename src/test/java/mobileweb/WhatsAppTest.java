package mobileweb;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobilewebpages.AgreeAndContinuePage;
import mobilewebpages.AppiumEnv;
import mobilewebpages.ChooseCountryPage;
import mobilewebpages.VerifyYourPhoneNumberPage;

public class WhatsAppTest extends AppiumEnv {
	private AndroidDriver<AndroidElement> mobileDriver = null;
	static WhatsAppTest whatsAppTest = new WhatsAppTest();
	private AgreeAndContinuePage agreeAndContinuePage = null;

	String messageAppPackageName = "com.android.mms";
    String messageAppActivityName = "com.android.mms.ui.MmsTabActivity";
    
	public WhatsAppTest() {
		super();
	}

	@BeforeClass
	public void beforSetup() throws Exception {
		mobileDriver = setUp();
		agreeAndContinuePage = new AgreeAndContinuePage();
	}

	@Test(description = "Whats app testcase")
	public void accountCreationTest() throws InterruptedException, IOException {

		String whatsAppWelcomeText = agreeAndContinuePage.getWhatsAppWelcomeText();
		Assert.assertEquals("Welcome to WhatsApp", whatsAppWelcomeText, "Welcome to WhatsApp text verification failed");

		VerifyYourPhoneNumberPage verifyYourPhoneNumberPage = agreeAndContinuePage.agreeAndConitnueButton();
		String verifyYourPhoneNumber = verifyYourPhoneNumberPage.getVerifyYourPhoneNumberText();
		Assert.assertEquals("Verify your phone number", verifyYourPhoneNumber,
				"Verify your phone number text verification failed");

		ChooseCountryPage chooseCountryPage = verifyYourPhoneNumberPage.clickOnDropDown();
		String chooseCountryText = chooseCountryPage.getChooseCountryText();
		Assert.assertEquals("Choose a country", chooseCountryText, "Choose a country text verification failed");

		verifyYourPhoneNumberPage = chooseCountryPage.selectCountry("India");
		verifyYourPhoneNumberPage.fillPhoneNo("9108371221");
		verifyYourPhoneNumberPage.clickNextButtion();
		verifyYourPhoneNumberPage.clickOnOkButton();
		verifyYourPhoneNumberPage.fillOTP("523654");
		//mobileDriver.startActivity(new Activity(messageAppPackageName, messageAppActivityName));
		
	}

	@AfterClass
	public void teardown() {
		if (mobileDriver != null) {
			System.out.println("******************************************************");
			System.out.println("Destroying Test Environment");
			mobileDriver.quit();
		}
	}
}
