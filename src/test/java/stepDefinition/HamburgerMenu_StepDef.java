package stepDefinition;


import static org.junit.Assert.assertEquals;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HamburgerMenu;

public class HamburgerMenu_StepDef {

	HamburgerMenu hm=new HamburgerMenu(DriverFactory.getDriver());
	
	@When("User clicks on the hamburger menu icon")
	public void user_clicks_on_the_hamburger_menu_icon() {
	hm.clickOnMenuIcon();
	}

	@Then("User should see the hamburger menu open")
	public void user_should_see_the_hamburger_menu_open() throws InterruptedException {
		Thread.sleep(1000);
		hm.menuBanner();
	}

	@And("user should see navigation menus")
	public void user_should_see_navigation_menus() {
	    hm.allMenuIcons();
	}

	@Then("click on Drone Query menu option")
	public void click_on_drone_query_menu_option() {
	  hm.clickDroneQueryOption();
	}

	@Then("verify that is opening")
	public void verify_that_is_opening() {
	    String actual=hm.verifyOpening();
	    assertEquals(actual, "DRONE QUERY");
	}



}


