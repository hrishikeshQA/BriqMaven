package suites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Suite {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","A:\\Study\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to
		("https://www.bizjournals.com/milwaukee/feature/crane-watch");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
