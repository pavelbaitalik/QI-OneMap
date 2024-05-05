package stepDefinition;

import static org.junit.Assert.assertTrue;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Search;

public class SearchFunctinality_StepDef {

	Search search=new Search(DriverFactory.getDriver());
	
	@When("User enters a place name {string} into the search field")
	public void user_enters_a_place_name_into_the_search_field(String string) throws InterruptedException {
		Thread.sleep(2000);
		search.enterPlaceNameInSearchField(string);
		Thread.sleep(5000);
	}

	@When("Hit enter")
	public void hit_enter() throws InterruptedException {
		Thread.sleep(2000);
	    search.keyboardEnter();
	    Thread.sleep(2000);
	}

	@Then("The selected place {string} should be displayed on the screen with detailed information")
	public void the_selected_place_should_be_displayed_on_the_screen_with_detailed_information(String string) {
	   String actual=search.validateSearchResult();
	   assertTrue(actual.contains(string));
	}

	@When("User selects the suggested place {string} from the search results")
	public void user_selects_the_suggested_place_from_the_search_results(String string) throws InterruptedException {
	   search.selectSuggestiveField(string);
	}

	@When("User selects the route planning button")
	public void user_selects_the_route_planning_button() throws InterruptedException {
		search.clickOnRoutePlaningBtn();
	}
	@When("User enters name {string} as the starting location")
	public void user_enters_name_as_the_starting_location(String string) throws InterruptedException {
	    search.routeStartLocation(string);
	}
	@Then("User enters name {string} as the destination")
	public void user_enters_name_as_the_destination(String string) throws InterruptedException {
	    search.routeEndLocation(string);
	}
	@Then("verify step-by-step directions should be visible for Transit, Bus, Car, Cycle,Walk")
	public void verify_step_by_step_directions_should_be_visible_for_transit_bus_car_cycle_walk() {
	  search.verifyRouteOptions();
	  
	}



	
}


