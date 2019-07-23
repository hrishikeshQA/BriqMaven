package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import context.Context;

public class SeleniumUtils {
	
	public WebDriver driver;
	
	/**
	 * 
	 */
	public void setDriver(){
		System.setProperty("webdriver.chrome.driver","A:\\Study\\LatestNew_WS\\briqautomationmaven\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	public void scrollinElement(WebElement e){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", e);
	}
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	/**
	 * @return 
	 * 
	 */
	public WebDriver getDriver(){
		return this.driver;
	}
	
	/**
	 * This method will click on Element
	 * @param e
	 */
	public void clickOnElement(WebElement e){
		if(e.isDisplayed()){
			scrollinElement(e);
			e.click();
		}
	}
	
	/**
	 * This method will fetch text from element
	 * @param e
	 * @return 
	 */
	public String fetchText(WebElement e){
		if(e.isDisplayed()){
			return e.getText();
		}
		return null;
	}
	
	/**
	 * This method will enter text in text box
	 * @param e
	 * @param txt
	 */
	public void enterText(WebElement e,String txt){
		if(e.isDisplayed()){
			e.sendKeys();
		}
	}
	
	/**
	 * This method navigates to URL
	 * @param url
	 */
	public void navigatetoURL(String url){
		Context.global().getSeleniumUtils().getDriver().navigate().to(url);
	}

}
