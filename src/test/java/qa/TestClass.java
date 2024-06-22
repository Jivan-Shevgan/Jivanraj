package qa;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestClass
{
	protected  AppiumDriver driver;
	
	@Given("appPackage And appActivity Land on open a Free Account")
	public void app_package_and_app_activity_land_on_open_a_free_account() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "76891dd6");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi_Note_9_Pro");
		dc.setCapability("appPackage", "com.fivepaisa.trade");
		dc.setCapability("appActivity", "com.fivepaisa.activities.SplashActivity");
		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I enter mobile No and Belongs to")
	public void i_enter_mobile_no_and_belongs_to() 
	{
		System.out.println("**********I enter mobile No and Belongs to");
	}
	@Then("click on register button")
	public void click_on_register_button() 
	{
		System.out.println("**********click on register button");
	}

	@Given("I am Jivan")
	public void i_am_jivan()
	{
		System.out.println("********I am Jivan");
		
	}
	@When("JivanRaj Hello")
	public void jivan_raj_hello()
	{
		System.out.println("*******JivanRaj Hello");
		
	}
	@Then("Bye Bye miss good night")
	public void bye_bye_miss_good_night()
	{
		System.out.println("*********Bye Bye miss good night");
		
	}

}