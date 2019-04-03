package mobilewebpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgreeAndContinuePage extends AppiumEnv {
	public AgreeAndContinuePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "android.widget.TextView")
	public WebElement welcomeToWhatsAppText;

	@FindBy(id = "com.whatsapp:id/eula_accept")
	public WebElement agreeAndContinue;

	@FindBy(className = "android.widget.TextView")
	public WebElement verifyYourPhoneNumber;

	public String getWhatsAppWelcomeText() throws IOException {
		waitForSpecificTime(driver, 10, welcomeToWhatsAppText);
		takeScreenShots(System.currentTimeMillis());
		return welcomeToWhatsAppText.getText();
	}

	public VerifyYourPhoneNumberPage agreeAndConitnueButton() throws IOException {
		click(driver, 10, agreeAndContinue);
		return new VerifyYourPhoneNumberPage();
	}

}
