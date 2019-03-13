package mobilewebpages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumEnv {

	public static AndroidDriver<AndroidElement> driver = null;
	public static AndroidDriver<MobileElement> mdriver = null;
	public static AppiumDriver<MobileElement> adriver = null;
	public static WebDriver webdriver;

	public static Properties prop;
	public static DesiredCapabilities capabilities;

	public static final String USERNAME = "Naveen2868";
	public static final String ACCESS_KEY = "a681efcb-9f12-4a3c-b966-735a96c88ef5";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public AppiumEnv() {
		String path = System.getProperty("user.dir") + "\\config.properties";
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(path);
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public AndroidDriver<AndroidElement> setUp() throws MalformedURLException {

		String context = prop.getProperty("context");
		System.out.println("context-------------->>>" + context);
		System.out.println("Setting up device and desired capabilities");

		if (context.equals("nativeView")) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, prop.getProperty("appiumVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
			capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (context.equals("webView")) {
			capabilities = new DesiredCapabilities();
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			//URL url = new URL(URL);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			cap.setCapability("noReset", true);
			cap.setCapability("appPackage", "com.android.chrome");
			cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			driver = new AndroidDriver<AndroidElement>(url, cap);

		} else if (context.equals("hybridView")) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, prop.getProperty("appiumVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.ANDROID);
			capabilities.setCapability("appPackage", "com.android.calculator2");
			capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	public void waitForSeconds(int value) {
		try {
			Thread.sleep(1000 * value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Parameters({"device","apppackage","activity","version","appiumServer"})
	public void deviceSetUp(String device, String apppackage, String activity, String version, String appiumServer)
			throws InterruptedException, MalformedURLException, InterruptedException {

		System.out.println("*****************************************************");
		System.out.println("Setting up device and desired capabilities");

		DesiredCapabilities cap = DesiredCapabilities.android();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.UDID, device);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.ANDROID);
		cap.setCapability(MobileCapabilityType.VERSION, version);
		URL url = new URL(appiumServer);
		mdriver = new AndroidDriver<MobileElement>(url, cap);
		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

}
