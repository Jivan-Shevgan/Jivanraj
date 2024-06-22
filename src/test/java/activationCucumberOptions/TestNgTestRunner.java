package activationCucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/Activation/features",tags="@CreateAccount",
		glue = "qa", monochrome= true, publish=true,dryRun = false,
			 plugin = {"pretty","html:target/cucumber.html"}) 
public class TestNgTestRunner  extends AbstractTestNGCucumberTests 
{
	public static void main(String[] args) {
		System.out.println("Jivan added this line");

		// Jivan 
	}
}
