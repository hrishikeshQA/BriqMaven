package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import context.Context;

public class HomePage {
	
	WebDriver driver;
	
	/**
	 * The button to view Map
	 */
	@FindBy(xpath = "/html/body/main/div[3]/div/div/a[1]")
	WebElement viewMap;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Clicks on view map
	 */
	public void clickViewMap(){
		Context.global().getSeleniumUtils().clickOnElement(this.viewMap);
	}

}
