package stepdevination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobileweb.WhatsAppTest;
import mobilewebpages.AppiumEnv;
import mobilewebpages.WhatsAppPage;

public class WhatsAppLaumchingStepDefination extends AppiumEnv {
	static WhatsAppTest whatsAppTest = new WhatsAppTest();
	private WhatsAppPage whatsAppPage = null;

	static WhatsAppLaumchingStepDefination contactApplicationTest = new WhatsAppLaumchingStepDefination();
	
	static{
		try {
			contactApplicationTest.startRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Given("^launched the what's app APP$")
	public void launched_the_what_s_app_APP() throws Throwable {
		setUp();
		whatsAppPage = new WhatsAppPage();
	}
	
	@Given("^launched the whats app APP$")
	public void launched_the_whats_app_APP() throws Throwable {
		setUp();
		whatsAppPage = new WhatsAppPage();
	}

	@When("^user accept the alert$")
	public void user_accept_the_alert() throws Throwable {
		whatsAppPage.clickOnAlert();
	}

	@Then("^user clicks on agree and continue button$")
	public void user_clicks_on_agree_and_continue_button() throws Throwable {
		whatsAppPage.agreeAndConitnueButton();
	}

	@Then("^user select the country from the dropdown$")
	public void user_select_the_country_from_the_dropdown() throws Throwable {
		whatsAppPage.clickOnDropDown();
	}

	@Then("^verify the selected country$")
	public void verify_the_selected_country() throws Throwable {
		whatsAppPage.getCountriesNames("India");
	}

	@Then("^user fill the phone number$")
	public void user_fill_the_phone_number() throws Throwable {
		whatsAppPage.fillPhoneNo();
		contactApplicationTest.stopRecording();
	}

}
