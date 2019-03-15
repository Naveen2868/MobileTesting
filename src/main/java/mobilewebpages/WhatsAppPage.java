package mobilewebpages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WhatsAppPage extends AppiumEnv {
	public WhatsAppPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.whatsapp:id/alertTitle")
	public WebElement alertTitle;

	@FindBy(id = "android:id/message")
	public WebElement alertText;

	@FindBy(id = "android:id/button2")
	public WebElement alertAcceptButton;

	@FindBy(id = "android:id/button1")
	public WebElement alertMoreInfoButton;

	@FindBy(className = "android.widget.TextView")
	public WebElement welcomeToWhatsAppText;

	@FindBy(id = "com.whatsapp:id/eula_accept")
	public WebElement agreeAndContinue;

	@FindBy(className = "android.widget.TextView")
	public WebElement verifyYourPhoneNumber;

	@FindBy(id = "com.whatsapp:id/registration_country")
	public WebElement countryDropdown;

	@FindBy(id = "com.whatsapp:id/registration_phone")
	public WebElement phoneNumberInputField;

	@FindBy(id = "com.whatsapp:id/country_first_name")
	public List<WebElement> countriesList;

	@FindBy(id = "com.whatsapp:id/country_code")
	public List<WebElement> countryCode;

	@FindBy(className = "android.widget.TextView")
	public WebElement chooseCountryText;

	public void clickOnAlert() throws IOException {
		waitForSpecificTime(driver, 10, alertTitle);
		takeScreenShots(System.currentTimeMillis());
		Assert.assertEquals("Alert", alertTitle.getText());
		if (alertAcceptButton.isDisplayed()) {
			click(driver, 10, alertAcceptButton);
			takeScreenShots(System.currentTimeMillis());
		}
		Assert.assertEquals("Welcome to WhatsApp", welcomeToWhatsAppText.getText());
	}

	public void agreeAndConitnueButton() throws IOException {
		click(driver, 10, agreeAndContinue);
		Assert.assertEquals("Verify your phone number", welcomeToWhatsAppText.getText());
		takeScreenShots(System.currentTimeMillis());
	}

	public void clickOnDropDown() throws IOException {
		click(driver, 10, countryDropdown);
		waitForSeconds(5);
		Assert.assertEquals("Choose a country", chooseCountryText.getText());
		takeScreenShots(System.currentTimeMillis());
	}

	public void getCountriesNames(String countryName) {

		if (countriesList.size() > 0) {
			for (WebElement webElement : countriesList) {
				String name = webElement.getText();
				if (name.equals(countryName)) {
					webElement.click();
					break;
				}
			}
		} else {
			System.out.println("Country size less than zero");
		}

	}

	public void fillPhoneNo() {
		sendKeys(driver, 10, phoneNumberInputField, "8798654344");
		waitForSeconds(5);
		try {
			takeScreenShots(System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
