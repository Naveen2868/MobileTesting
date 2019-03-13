package mobilewebpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class CalcPage extends AppiumEnv {

	public CalcPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "com.android.calculator2:id/result")
	public WebElement result;

	public void clickOnDigits(int value) {
		driver.findElementById("com.android.calculator2:id/digit_" + value + "").click();
	}

	public void clickOnFunction(String value) {
		driver.findElementById("com.android.calculator2:id/op_" + value + "").click();
	}

	public void plus() {
		System.out.println("Addin two nos");
		clickOnDigits(9);
		clickOnFunction("add");
		clickOnDigits(9);
		waitForSeconds(2);
		System.out.println("Result --> " + result.getText().trim());
	}

	public void subtraction() {
		System.out.println("sbutraction two nos");
		clickOnDigits(9);
		clickOnFunction("sub");
		clickOnDigits(8);
		waitForSeconds(2);
		System.out.println("Result --> " + result.getText().trim());
	}

	public void multiplication() {
		System.out.println("multiplication two nos");
		clickOnDigits(5);
		clickOnFunction("mul");
		clickOnDigits(6);
		waitForSeconds(2);
		System.out.println("Result --> " + result.getText().trim());
	}

	public void devide() {
		System.out.println("devide two nos");
		clickOnDigits(5);
		clickOnFunction("div");
		clickOnDigits(5);
		waitForSeconds(2);
		System.out.println("Result --> " + result.getText().trim());
	}

	public void goToPreviousAction() {
		System.out.println("Navigate to previous action");
		driver.findElementById("com.android.calculator2:id/back").click();
	}

	public void goToHome() {
		System.out.println("Navigate to Home");
		driver.findElementById("home").click();
	}

	public void clearResult() {
		System.out.println("Clear the result");
		driver.findElementById("com.android.calculator2:id/del").click();
		;
	}

}
