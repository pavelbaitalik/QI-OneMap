package stepDefinition;



import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePage_stepDef {

	HomePage hp=new HomePage(DriverFactory.getDriver());
	
	@Given("User navigates to the OneMap website")
	public void user_navigates_to_the_one_map_website() throws InterruptedException {
		DriverFactory.getDriver().get("https://www.onemap.gov.sg/");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		 while (!jsExecutor.executeScript("return document.readyState").equals("complete")) {
	            // Wait for a short period before checking again
	            try {
	                Thread.sleep(100); // Wait for 100 milliseconds
	            } catch (InterruptedException e) {
	                // Handle InterruptedException
	            }
		  }
		 Thread.sleep(5000);
		 }

	@When("The homepage is loaded")
	public void the_homepage_is_loaded() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		}

	@Then("The homepage should be displayed and page title should be Mached with {string}")
	public void the_homepage_should_be_displayed_and_page_title_should_be_mached_with(String string) throws InterruptedException {
		Thread.sleep(2000);
		String actualTitle=DriverFactory.getDriver().getTitle();
		assertEquals(string, actualTitle );
	}
}


