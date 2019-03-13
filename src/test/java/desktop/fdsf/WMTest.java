package desktop.fdsf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMTest {
	WebDriver driver = null;
	//String CHROME = "CHROME";
	/*@BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }*/
	
	@BeforeMethod
	public void statrtDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
    public void test() {
        driver.get("https://github.com/bonigarcia/webdrivermanager");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
