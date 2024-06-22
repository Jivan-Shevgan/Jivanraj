package TC1_Activation_Web;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn
{
	protected AndroidDriver driver;
	@Given("appPackage And appActivity Land on open a Free Account")
	public void apppackage_and_appactivity_land_on_open_a_free_account() throws Throwable
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("I enter mobile No and Belongs to")
	public void i_enter_mobile_no_and_belongs_to() throws Throwable
	{
		try {
			try {
				driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='English']")).click(); 
				driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Open a Free Account']")).click(); 
				
			} catch (NoSuchElementException e) {
				driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Open a Free Account']")).click(); 
			}
			driver.findElement(MobileBy.xpath("//android.widget.EditText[@text='Mobile No.']")).sendKeys("8855873119");
			driver.findElement(MobileBy.id("com.fivepaisa.trade:id/spnConsent")).click();
			
			WebElement drop = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='POA']"));
			Actions act =  new Actions(driver);
			act.moveToElement(drop).click().perform();
			
			String regi = driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Register']")).getText();
			System.out.println(regi);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("click on register button")
	public void click_on_register_button() throws Throwable
	{
		
	}

}
