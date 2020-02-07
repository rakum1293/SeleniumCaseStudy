package caseStudy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ravi_Assignment3 {
	
	
	WebDriver driver = null ;
	
	@BeforeTest	
	public void setUpTest() {
			
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
	
	
	
	@Test
	public void testMakeMyTrip() {
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		WebElement oneWay = driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']/li[1]"));
		if (oneWay.isSelected() == false) {
			
			oneWay.click();
		}

		else {
			System.out.println("OneWay Trip is already selected");
			}
		
		
		WebElement fromCity = driver.findElement(By.xpath("//label[@for='fromCity']"));
		fromCity.click();
		WebElement selectFromCity = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-1-item-0']"));
		selectFromCity.click();
		WebElement toCity = driver.findElement(By.xpath("//label[@for='toCity']"));
		toCity.click();
		WebElement selectToCity = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-1']"));
		selectToCity.click();
		WebElement departure = driver.findElement(By.xpath("//label[@for='departure']"));
		departure.click();
		WebElement departureDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Mon Feb 10 2020']"));
		departureDate.click();
		WebElement Search = driver.findElement(By.xpath("//a[contains(text() , 'Search')]"));
		Search.click();
		List<WebElement> flightResults = driver.findElements(By.xpath("//div[contains(@id , 'fli_list_item_')]"));
	    WebElement cheapestResult = flightResults.get(0);
	    WebElement bookNow = cheapestResult.findElement(By.xpath("//div[contains(@id , 'bookbutton-')]"));
	    bookNow.click();
	    
	}
		

	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		//System.out.println("Test completed successfully");
		
	}

}
