package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Search {


	public  WebDriver driver;
	final WebDriverWait wait;
	
	
	
	@FindBy(xpath="//*[@id='search_property']")
	WebElement searchField;
	
	@FindBy(xpath="//*[@id='markerInfobox']/div[2]")
	WebElement searchReselt_Locator;
	
	@FindBy(xpath="//span[@class='searchresult_name']")
	List<WebElement> searchSuggestiveDropdown_Locator;
	
	@FindBy(xpath="//div[@class='autocom-box']")
	WebElement searchresult_class_Locator;
	
	@FindBy(xpath="//*[@id='route-icon']")
	WebElement routeIcon_Locator;
	
	@FindBy(xpath="//*[@id='originInput']")
	WebElement startLocation_Locator;
	
	@FindBy(xpath="//*[@id='destinationInput']")
	WebElement destinationLocation_Locator;
	
	@FindBy(xpath="//*[@id='itineraryItem']")
	WebElement routeItems_Locator;
	
	@FindBy(xpath="//*[@id='routeOptionItem_Bus']")
	WebElement BusMode_Locator;
	
	@FindBy(xpath="//*[@id='routeOptionItem_Car']")
	WebElement CurMode_Locator;
	
	@FindBy(xpath="//*[@id='routeOptionItem_Car']")
	WebElement CarMode_Locator;
	
	@FindBy(xpath="//*[@id='routeOptionItem_Cycle']")
	WebElement CycleMode_Locator;
	
	@FindBy(xpath="//*[@id='routeOptionItem_Walk']")
	WebElement WalkMode_Locator;
	
	public Search(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	}



	public void enterPlaceNameInSearchField(String string) {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys(string);
		
	}
	
	public void keyboardEnter() {
		wait.until(ExpectedConditions.visibilityOf(searchresult_class_Locator));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchField.sendKeys(Keys.ENTER);
		
	}

	public String validateSearchResult() {
		wait.until(ExpectedConditions.visibilityOf(searchReselt_Locator));
		return	searchReselt_Locator.getText();
		
	}



	public void selectSuggestiveField(String string) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchresult_class_Locator));
		Thread.sleep(2000);
		for(WebElement sample : searchSuggestiveDropdown_Locator)

		{
			Thread.sleep(500);
		if(sample.getText().contains(string))

		{

		sample.click();
		Thread.sleep(1500);
		break;

		}
		
		}
	}



	public void clickOnRoutePlaningBtn() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(routeIcon_Locator));
		Thread.sleep(4000);
		routeIcon_Locator.click();
		
	}



	public void routeStartLocation(String string) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(startLocation_Locator));
		startLocation_Locator.clear();
		Thread.sleep(2000);
		startLocation_Locator.sendKeys(string);
		wait.until(ExpectedConditions.visibilityOf(searchresult_class_Locator));
		Thread.sleep(2000);
		startLocation_Locator.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}



	public void routeEndLocation(String string) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(destinationLocation_Locator));
		Thread.sleep(1000);
		destinationLocation_Locator.clear();
		destinationLocation_Locator.sendKeys(string);
		Thread.sleep(2000);
		destinationLocation_Locator.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}



	public void verifyRouteOptions() {
/*		wait.until(ExpectedConditions.elementToBeClickable(routeItems_Locator));
		if(routeItems_Locator.isDisplayed()==true)
		{
			System.out.println("Transit items present in Real Time");
		}  
*/
		wait.until(ExpectedConditions.elementToBeClickable(BusMode_Locator));
		BusMode_Locator.click();
//		if(routeItems_Locator.isDisplayed()==true)
//		{
//			System.out.println("bus items present in Real Time");
//		}
		CarMode_Locator.click();
		wait.until(ExpectedConditions.elementToBeClickable(routeItems_Locator));
		if(routeItems_Locator.isDisplayed()==true)
		{
			System.out.println("car items present in Real Time");
		}
		CycleMode_Locator.click();
		wait.until(ExpectedConditions.elementToBeClickable(routeItems_Locator));
		if(routeItems_Locator.isDisplayed()==true)
		{
			System.out.println("cycle items present in Real Time");
		}
		WalkMode_Locator.click();
		wait.until(ExpectedConditions.elementToBeClickable(routeItems_Locator));
		if(routeItems_Locator.isDisplayed()==true)
		{
			System.out.println("walk items present in Real Time");
		}
		
	}
	
	
}
