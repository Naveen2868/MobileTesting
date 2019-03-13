package desktop.fdsf;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcTest {
	WiniumDriver driver = null;
	WiniumDriverService service = null;
	DesktopOptions desktopOptions = null;

	@BeforeClass
	public void setupEnvironment() throws IOException {
		desktopOptions = new DesktopOptions();// Instantiate Winium desktop
		desktopOptions.setApplicationPath("C:\\Windows\\System32\\calc.exe"); // set
																				// calculator
																				// application
		//desktopOptions.setDebugConnectToRunningApp(false);															// path
		File driverPath = new File("C:\\Users\\naleti\\Desktop\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
				.withSilent(false).buildDesktopService();
		service.start();
		//winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
	}

	@BeforeMethod
	public void statrtDriver() {
		driver = new WiniumDriver(service, desktopOptions);
	}

	//@Test
	public void selectScinitificModeAddTwoNos() throws InterruptedException {
		WebElement calcFrame = driver.findElement(By.className("CalcFrame"));
		WebElement menu = calcFrame.findElement(By.id("MenuBar"));
		WebElement viewMenu = menu.findElement(By.name("View"));
		viewMenu.click();
		viewMenu.findElement(By.name("Scientific")).click();
		waitForLoadElement(2);
		calcFrame.findElement(By.id("132")).click();// id for number '2' in
													// calculator app is '132'
		waitForLoadElement(2);
		calcFrame.findElement(By.id("93")).click();// id for Addition in
													// calculator app is '93'
		waitForLoadElement(2);
		calcFrame.findElement(By.id("134")).click();// id for number '4' in
													// calculator app is '134'
		waitForLoadElement(2);
		calcFrame.findElement(By.id("121")).click();// id for number 'equals' in
													// calculator app is '121'
		waitForLoadElement(2);
	}

	@Test
	public void selectStandardViewSubtractNumbersTest() throws InterruptedException {
		WebElement calcFrame = driver.findElement(By.className("CalcFrame"));
		WebElement menu = calcFrame.findElement(By.id("MenuBar"));
		WebElement viewMenu = menu.findElement(By.name("View"));
		viewMenu.click();
		viewMenu.findElement(By.name("Standard")).click();
		waitForLoadElement(2);
		calcFrame.findElement(By.id("134")).click();
		waitForLoadElement(2);
		calcFrame.findElement(By.id("94")).click();
		waitForLoadElement(2);
		calcFrame.findElement(By.id("132")).click();// id for number '4' in
													// calculator app is '134'
		waitForLoadElement(2);
		calcFrame.findElement(By.id("121")).click();
		waitForLoadElement(2);

	}

	@AfterMethod
	public void stopDriver() {
		driver.close();
		driver.quit();
	}

	//@AfterClass
	public void tearDown() {
		service.stop();
	}

	public void waitForLoadElement(int i) throws InterruptedException {
		Thread.sleep(i * 1000);
	}
}
