package mobilewebpages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseCountryPage extends AppiumEnv {
	public ChooseCountryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.whatsapp:id/country_first_name")
	public List<WebElement> countriesList;

	@FindBy(id = "com.whatsapp:id/country_code")
	public List<WebElement> countryCode;

	@FindBy(className = "android.widget.TextView")
	public WebElement chooseCountryText;

	public String getChooseCountryText() throws IOException {
		waitForSpecificTime(driver, 10, chooseCountryText);
		return chooseCountryText.getText();
	}

	public VerifyYourPhoneNumberPage selectCountry(String countryName) {

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
		return new VerifyYourPhoneNumberPage();
	}

}
