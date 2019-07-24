package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import context.Context;

public class MapPage {
	WebDriver driver;
	@FindBy(xpath = "//iframe[@class='cw-map']")
	WebElement frameCities;
	
	@FindBy(css = "#milwaukee_7663_layer > image")
	List<WebElement> pins;
	
	@FindBy(xpath = "//*[@id='widgets_ZoomSlider_Widget_24']/div[2]")
	WebElement zoomOut;
	
	@FindBy(xpath = "//*[@id='map_root']/div[3]/div[1]/div[1]/div/div[5]")
	WebElement maximise;
	
	@FindBy(xpath = "//*[@id='map_root']/div[3]/div[1]/div[1]/div/div[6]")
	WebElement close;
	
	@FindBy(xpath = "(//*[contains(@id,'esri_dijit__PopupRenderer')]//*[@class='header'])[1]")
	WebElement pinHeader;
	
	@FindBy(xpath = "//*[contains(@id,'LOTCCFrame')]")
	WebElement advertisementIFrame;
	
	@FindBy(xpath = "(//*[@class='bx-close-xsvg'])[1]")
	WebElement closeAd;
	
	public MapPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * This method with switch to cities frame
	 */
	public void switchToCitiesFrame(){
		Context.global().getSeleniumUtils().scrollinElement(frameCities);
		driver.switchTo().frame(frameCities);
	}
	
	/**
	 * This method with switch to advertisement frame
	 */
	public void switchToAdvertisementFrame(){
		driver.switchTo().frame(advertisementIFrame);
	}
	
	
	public void verifyPinsPresent(){
	}
	
	/**
	 * Click maximise when info in pin is displayed
	 */
	public void clickMaximise(){
		
		Context.global().getSeleniumUtils().clickOnElement(maximise);
	}
	
	/**
	 * Click close when info is read
	 */
	public void clickClose(){
		Context.global().getSeleniumUtils().moveToELEandClick(close);
	}
	
	/**
	 * Click close when info is read
	 */
	public void clickCloseAd(){
		Context.global().getSeleniumUtils().clickOnElement(closeAd);
	}
	
	/**
	 * @param n
	 * No of zoom out clicks in map
	 */
	public void noOfZoomOuts(int n){
		while(n>0){
			Context.global().getSeleniumUtils().clickOnElement(zoomOut);
			n--;
		}
	}
	
	/**
	 * This method is used to handle alerts
	 */
	public void handleAlert(){
		try{
			Alert al = driver.switchTo().alert();
			al.dismiss();
		}
		catch(NoAlertPresentException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method is used to read pin header
	 * @return pin header
	 */
	public String fetchPinHeader(){
		return Context.global().getSeleniumUtils().fetchText(pinHeader);
	}
	
	/**
	 * This method is to find number of pins
	 * @return
	 */
	public int noOfPins(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
				  ("#milwaukee_7663_layer > image:nth-child(2)")));
		return pins.size();
	}

}
