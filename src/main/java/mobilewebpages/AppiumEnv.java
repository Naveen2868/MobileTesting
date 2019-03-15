package mobilewebpages;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.SpecializedScreenRecorder;
import com.qa.utils.TestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumEnv {

	public static AndroidDriver<AndroidElement> driver = null;
	public static Properties prop;
	public ScreenRecorder screenRecorder;
	public static DesiredCapabilities capabilities;

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

		String platform = prop.getProperty("context");
		System.out.println("<---Setting up device and desired capabilities for " + platform + " application--->");

		if (platform.equals("nativeView")) {

			// File file = new
			// File("D:\\NewDownloads\\apkfiles\\com.whatsapp_v2.19.73-452714_Android-4.0.3.apk");
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, prop.getProperty("appiumVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			// capabilities.setCapability("noReset", true);
			// capabilities.setCapability("app", file.getAbsolutePath());
			capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
			capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (platform.equals("webView")) {// browser

			capabilities = new DesiredCapabilities();
			URL url = new URL("http://127.0.0.1:4725/wd/hub");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
			cap.setCapability("noReset", true);
			cap.setCapability("appPackage", "com.android.chrome");
			cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			driver = new AndroidDriver<AndroidElement>(url, cap);

		}

		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return driver;
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
		driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public void click(@SuppressWarnings("rawtypes") AndroidDriver driver, int timeout, WebElement ele) {
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void sendKeys(@SuppressWarnings("rawtypes") AndroidDriver driver, int timeout, WebElement ele,
			String value) {
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(value);
	}

	public void waitForSpecificTime(@SuppressWarnings("rawtypes") AndroidDriver driver, int timeout, WebElement ele) {
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(ele));
	}

	public void takeScreenShots(long ScreenName) throws IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("D:\\DesktopApplication\\fdsf\\screenshots\\" + ScreenName + ".png");
		FileUtils.copyFile(srcFile, targetFile);
	}

	public void waitForSeconds(int value) {
		try {
			Thread.sleep(1000 * value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void startRecording() throws Exception {

		String path = System.getProperty("user.dir") + "\\screenrecordingvideos";

		File file = new File(path);

		// We can use this code for full screen recording only
		/*
		 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 * int width = screenSize.width; int height = screenSize.height;
		 */

		Rectangle captureSize = new Rectangle(0, 0, 440, 768);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, "MyVideo");
		this.screenRecorder.start();

	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}

}
