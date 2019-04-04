package mobilewebpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyYourPhoneNumberPage extends AppiumEnv {
	public VerifyYourPhoneNumberPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "android.widget.TextView")
	public WebElement verifyYourPhoneNumber;

	@FindBy(id = "com.whatsapp:id/registration_country")
	public WebElement countryDropdown;

	@FindBy(id = "com.whatsapp:id/registration_phone")
	public WebElement phoneNumberInputField;

	@FindBy(id = "com.whatsapp:id/registration_submit")
	public WebElement nextButton;
	
	@FindBy(id = "android:id/button1")
	public WebElement okButtion;
	
	@FindBy(id = "com.whatsapp:id/verify_sms_code_input")
	public WebElement whatsappOTP;
	
	
	public void fillOTP(String phoneNumber){
		sendKeys(driver, 10, whatsappOTP,phoneNumber);
	}
	
	public void clickOnOkButton(){
		click(driver, 10,okButtion);
		waitForSeconds(6);
	}
	
	public void clickNextButtion(){
		click(driver, 10,nextButton);
		waitForSeconds(6);
	}
	
	public String getVerifyYourPhoneNumberText() throws IOException {
		waitForSpecificTime(driver, 10, verifyYourPhoneNumber);
		takeScreenShots(System.currentTimeMillis());
		return verifyYourPhoneNumber.getText();
	}

	public ChooseCountryPage clickOnDropDown() throws IOException {
		click(driver, 10, countryDropdown);
		takeScreenShots(System.currentTimeMillis());
		return new ChooseCountryPage();
	}

	public void fillPhoneNo(String phoneNumber) {
		sendKeys(driver, 10, phoneNumberInputField,phoneNumber);
		waitForSeconds(2);
		try {
			takeScreenShots(System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
