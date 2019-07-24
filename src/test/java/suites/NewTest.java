package suites;

import org.testng.annotations.Test;

import context.Context;
import pages.HomePage;
import pages.MapPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	static LinkedHashMap<String, LinkedList<String>> completeData = new LinkedHashMap<String, LinkedList<String>>();
	WebDriver driver;
  /**
 * @throws IOException
 * Test case - 
 * 1. Navigate to URL - https://www.bizjournals.com/milwaukee/feature/crane-watch
 * 2. Click view map
 * 3. Click Zoom out
 * 4. Click on particular pin, read all the info. Do it for all the pins
 * 5. Store gathered info in structured format in excel 
 */
@Test
  public void f() throws IOException {
	
	HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
	MapPage mapPage =  PageFactory.initElements(this.driver, MapPage.class);
	
	  Context.global().getSeleniumUtils().navigatetoURL
	  ("https://www.bizjournals.com/milwaukee/feature/crane-watch");
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,250)");
	  homePage.clickViewMap();
	  Context.global().getSeleniumUtils().waitForLoad(Context.global().getSeleniumUtils().getDriver());
	  mapPage.switchToCitiesFrame();
	  // mapPage.noOfZoomOuts(2);
	  storePinInfoinMap();
	  Context.global().getMapWorkflow().putDataInExcel(completeData);
	  
  }
  
  public void storePinInfoinMap(){
	  MapPage mapPage =  PageFactory.initElements(this.driver, MapPage.class);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)");
	  this.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  int pinNO = mapPage.noOfPins();
	  for(int i = 2;i<= pinNO+1;i++){
		 try{
		  WebElement ele = driver.findElement(By.cssSelector
				  ("#milwaukee_7663_layer > image:nth-child("+i+")"));
		  Context.global().getSeleniumUtils().moveToELEandClick(ele);
		  LinkedList<String> pinData = new LinkedList<String>();
		  String heading = mapPage.fetchPinHeader();
		  int dataLines = Context.global().getSeleniumUtils().getDriver().
				  findElements(By.xpath("//*[contains(@id,'esri_dijit__PopupRenderer')]//following::tr")).size();
		  for(int j = 1;j<=dataLines;j++){
			  String val = Context.global().getSeleniumUtils().getDriver().
					  findElement(By.xpath("(//*[contains(@id,'esri_dijit__PopupRenderer')]//following::tr)["+j+"]/td[2]")).getText();
			  pinData.add(val);
		  }
		  completeData.put(heading, pinData);
		  mapPage.clickClose();
	  }
		 catch(Exception e){
			  continue;
		  }
	  }
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Context.global().getSeleniumUtils().setDriver();
	  driver = Context.global().getSeleniumUtils().getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  //this.driver.quit();
	  this.driver.close();
  }

}
