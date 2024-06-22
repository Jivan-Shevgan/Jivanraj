package TC1_Activation_Web;

import java.io.File;
import java.net.MalformedURLException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks 
{
//	AppiumDriverLocalService server;
	@Before // import from only : io.cucumber.java
	public void startAnAppiumServer() throws MalformedURLException
	{
		System.out.println("Yes i am before");
//		System.out.println("write a code to start an appium server");
//		server =  new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//		.withAppiumJS(new File("C:\\Users\\rajpu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
////		server = AppiumDriverLocalService.buildDefaultService();
//		String appiumServiceUrl = server.getUrl().toString();
//		System.out.println(appiumServiceUrl);
//		server.start();
	}
	@After
	public void stopAnAppiumServer()
	{
//		server.stop();
		System.out.println("I am After");
	}
}
