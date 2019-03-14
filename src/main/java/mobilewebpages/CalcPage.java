package mobilewebpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		Assert.assertEquals("18", result.getText().trim());
		System.out.println("Result --> " + result.getText().trim());
	}

	public void subtraction() {
		System.out.println("sbutraction two nos");
		clickOnDigits(9);
		clickOnFunction("sub");
		clickOnDigits(8);
		waitForSeconds(2);
		Assert.assertEquals("1", result.getText().trim());
		System.out.println("Result --> " + result.getText().trim());
	}

	public void multiplication() {
		System.out.println("multiplication two nos");
		clickOnDigits(5);
		clickOnFunction("mul");
		clickOnDigits(6);
		waitForSeconds(2);
		Assert.assertEquals("30", result.getText().trim());
		System.out.println("Result --> " + result.getText().trim());
	}

	public void devide() {
		System.out.println("devide two nos");
		clickOnDigits(5);
		clickOnFunction("div");
		clickOnDigits(5);
		waitForSeconds(2);
		Assert.assertEquals("1", result.getText().trim());
		System.out.println("Result --> " + result.getText().trim());
	}

	public void goToPreviousAction() {
		driver.findElementById("com.android.calculator2:id/back").click();
	}

	public void goToHome() {
		driver.findElementById("home").click();
	}

	public void clearResult() {
		driver.findElementById("com.android.calculator2:id/del").click();
	}

}
