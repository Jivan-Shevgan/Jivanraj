package TC1_Activation_Web;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UsingMainMethod
{
	protected static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "76891dd6");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi_Note_9_Pro");
		dc.setCapability("appPackage", "com.fivepaisa.trade");
		dc.setCapability("appActivity", "com.fivepaisa.activities.SplashActivity");
		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='English']")).click(); 
			driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/btnLoginIn")).click(); 

		} catch (NoSuchElementException e) 
		{
			driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/btnLoginIn")).click(); 
		}
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/txtMobile")).sendKeys("7038751868");
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/btnContinue")).click();
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/txtPassword")).sendKeys("Kittu@12345");
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/txtDOB")).sendKeys("05051997");
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/btnLogin")).click();

		WebElement skipButton = driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/btnSkip"));
		new Actions(driver).moveToElement(skipButton).click().build().perform();
		
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/imgUser")).click();

		Thread.sleep(5000);
		try
		{
			WebElement ele = driver.findElement(AppiumBy.id("com.fivepaisa.trade:id/txtLogout"));
			Actions action = new Actions(driver);
			action.moveToElement(ele, ele.getRect().x, ele.getRect().y).click().build().perform();
			action.perform();
		} catch(Exception e)
		{
			System.out.println("catch block");
			Dimension d =  driver.manage().window().getSize();
			int commonX = d.width/2;
			int startY = (int) (d.height*0.9);
			int endY = (int) (d.height*0.1);
			PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
			// creating sequence object to add actions
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), commonX, startY));
			// finger comes down into contact with screen 
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			
			swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), commonX, endY));
			// 20 seconds means it will take slow action to swipe as 20 sec (0 sec not works)
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			// before the action
			driver.perform(Arrays.asList(swipe));
			System.out.println("Thank you");
			e.printStackTrace();
		}
	}
}