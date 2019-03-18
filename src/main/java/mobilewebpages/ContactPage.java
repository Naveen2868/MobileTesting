package mobilewebpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ContactPage extends AppiumEnv {

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Contacts']")
	public WebElement title;

	@FindBy(id = "com.android.contacts:id/create_contact_button")
	public WebElement createAccount;

	@FindBy(id = "com.android.contacts:id/right_button")
	public WebElement addAccount;

	@FindBy(className = "android.widget.TextView")
	public WebElement accountSetupText;

	@FindBy(id = "com.android.email:id/account_email")
	public WebElement enterEmailAddress;

	@FindBy(id = "com.android.email:id/next")
	public WebElement next;

	@FindBy(id = "com.android.email:id/ab_button_b")
	public WebElement personal;

	@FindBy(id = "com.android.email:id/regular_password")
	public WebElement password;

	@FindBy(id = "android:id/alertTitle")
	public WebElement problemWithAccountSetup;

	@FindBy(id = "android:id/button1")
	public WebElement editSettings;

	@FindBy(id = "com.android.email:id/wrong_password_warning_label")
	public WebElement errorMessageIncorrectPassword;

	public void addNewContact() throws IOException {

		Assert.assertEquals("Contacts", title.getText());

		waitForSpecificTime(driver, 10, createAccount);
		click(driver, 10, createAccount);
		takeScreenShots(System.currentTimeMillis());

		waitForSpecificTime(driver, 10, addAccount);
		click(driver, 10, addAccount);
		takeScreenShots(System.currentTimeMillis());

		waitForSpecificTime(driver, 10, accountSetupText);
		Assert.assertEquals("Account setup", accountSetupText.getText());

		sendKeys(driver, 10, enterEmailAddress, prop.getProperty("user"));

		waitForSpecificTime(driver, 10, next);
		click(driver, 10, next);
		takeScreenShots(System.currentTimeMillis());

		waitForSpecificTime(driver, 10, personal);
		click(driver, 10, personal);
		takeScreenShots(System.currentTimeMillis());

		waitForSpecificTime(driver, 10, password);
		sendKeys(driver, 10, password, prop.getProperty("pass"));

		click(driver, 10, next);
		waitForSeconds(5);
		takeScreenShots(System.currentTimeMillis());

		Assert.assertEquals("Problem with account setup", problemWithAccountSetup.getText());

		click(driver, 10, editSettings);
		takeScreenShots(System.currentTimeMillis());

		Assert.assertEquals("Email address or password are incorrect", errorMessageIncorrectPassword.getText().trim());
		waitForSeconds(5);
	}

}
