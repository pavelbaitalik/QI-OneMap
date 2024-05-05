package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HamburgerMenu {


	public  WebDriver driver;
	final WebDriverWait wait;
	
	
	
	@FindBy(xpath="//*[@id='icon-expand-menu']")
	WebElement menuIcon_Locator;
	
	@FindBy(xpath="//*[@id='icon-menu-wrapper']")
	WebElement menubanner_Locator;
	
	@FindBy(xpath="//div[@class='icon-details']")
	List<WebElement> menu_allIcons_Locator;
	
	@FindBy(xpath="//*[@id='droneInfo']")
	WebElement droneQueryOption_Locator;
	
	@FindBy(xpath="//*[@id='droneInfoWrapper']/div/div[1]/div")
	WebElement droneQueryOptionText_Locator;
	
	
	public HamburgerMenu(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	}


	

	public void clickOnMenuIcon() {
		wait.until(ExpectedConditions.visibilityOf(menuIcon_Locator));
		menuIcon_Locator.click();
		
	}




	public void menuBanner() {
		wait.until(ExpectedConditions.visibilityOf(menubanner_Locator));
		
	}




	public void allMenuIcons() {
		wait.until(ExpectedConditions.visibilityOfAllElements(menu_allIcons_Locator));
		
	}






	public void clickDroneQueryOption() {
		wait.until(ExpectedConditions.elementToBeClickable(droneQueryOption_Locator));
		droneQueryOption_Locator.click();
	}




	public String verifyOpening() {
		wait.until(ExpectedConditions.visibilityOf(droneQueryOptionText_Locator));
		return droneQueryOptionText_Locator.getText();
	}
	
	
}
