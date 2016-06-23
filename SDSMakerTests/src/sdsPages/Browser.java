package sdsPages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {

	public static WebDriver driver;
	public static FirefoxProfile profile;
	public static ChromeOptions opts;
	public static String mainwin;
	
	public Browser() {

	}

	public static WebDriver driver() {
		return driver;
	}

	public static void initFF() {
		FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\milka.stankova\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\t53k05xa.default"));
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		mainwin = driver.getWindowHandle();
		System.out.println(mainwin);
	}

	public static void initChrome() {                  
		System.setProperty("webdriver.chrome.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("C:\\Users\\milka.stankova\\AppData\\Local\\Google\\Chrome\\User Data");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	public static void initIE() {
		/*InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
		InternetExplorerDriverService srvc = builder.usingPort(5555).withHost("127.0.0.1").build();*/
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		cap.setCapability(InternetExplorerDriver.SILENT, true);

		System.setProperty("webdriver.ie.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
	}

	public static void initHeadlessBrowser() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("cssSelectorsEnabled", true);
		capabilities.setVersion("42.0");
		capabilities.setJavascriptEnabled(true);
		//driver = new HtmlUnitDriver(capabilities);
		// driver=new FirefoxDriver();
	}

	public static void open(String url) {
		driver.get(url);
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

 
	public static void ClosePopFrame() {
			driver.switchTo().window(mainwin);
			WebElement CloseBtn = driver.findElement(By.id("TB_closeWindowButton"));
			CloseBtn.click();	
			System.out.println("Close popup frame");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void SwitchToMain() {
		Browser.driver.switchTo().window(Browser.mainwin);
	}
}
