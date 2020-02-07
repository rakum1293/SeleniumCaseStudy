package caseStudy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ravi_Assignment1 {

	WebDriver driver = null ;
	
@BeforeTest	
public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test(priority=1)
	public void testSelectable() {
		
		driver.get("https://demoqa.com/selectable/");
		driver.manage().window().maximize();
		List<WebElement> selectableList = driver.findElements(By.id("selectable"));
		
		for(int i=0 ; i < selectableList.size(); i++) {
			
			System.out.println(selectableList.get(i).getText());
			selectableList.get(i).click();
		}
		
		}
	
	
	@Test(priority=2)
	public void testContactForm() throws InterruptedException {
		
		driver.get("https://demoqa.com/html-contact-form/");
		driver.manage().window().maximize();
		
		WebElement firstName = driver.findElement(By.cssSelector(".firstname"));
		WebElement lastName = driver.findElement(By.id("lname"));
		WebElement country = driver.findElement(By.xpath("//input[@type='text' and @name='country']"));
		WebElement subject = driver.findElement(By.id("subject"));
		WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
		List<WebElement> googleLinks = driver.findElements(By.partialLinkText("Google"));
		System.out.println(googleLinks.size());
		
		firstName.sendKeys("Ravi");
		lastName.sendKeys("Kumar");
		country.sendKeys("India");
		subject.sendKeys("This is a Demo Selenium Test");
		submitBtn.click();
		
		driver.navigate().back();
		driver.navigate().refresh();
		//Thread.sleep(5000);
		
		for(int i=0 ; i < googleLinks.size() ; i++) {
			
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			googleLinks.get(i).sendKeys(selectLinkOpeninNewTab);
			
			}
		
		}
	
	
	
	@Test(priority=3)
	public void testDragDrop() {
		
		driver.get("https://demoqa.com/droppable/");
		
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		
		Assert.assertTrue(to.getText().equals("Dropped!"));	
		
	}
	
	
	
	@Test(priority=4)
	public void testDatePicker() throws InterruptedException {
		
		driver.get("https://demoqa.com/datepicker/");
		driver.manage().window().maximize();
		
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();
		datePicker.sendKeys("12/01/1993");
		datePicker.sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);
		
	}
	
	
	
	@Test(priority=5)
	public void testSelectMenu() {
		
		driver.get("https://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		
		List<WebElement> listSpeed = driver.findElements(By.xpath("//*[@id='speed']/child::option"));
		System.out.println(listSpeed.size());
		
		for (int i=1 ; i <= listSpeed.size(); i++) {
			
		//	System.out.println(listSpeed.get(i).getText());
			driver.findElement(By.xpath("//*[@id='speed-button']/span[1]")).click();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='speed-button' and @aria-activedescendant='ui-id-"+i+"']"))));
			driver.findElement(By.xpath("//*[@id='speed-button' and @aria-activedescendant='ui-id-"+i+"']")).click();
		}
		
		
		List<WebElement> listFiles = driver.findElements(By.xpath("//*[@id='files']/child::optgroup/child::option"));
		System.out.println(listFiles.size());
		
		for (int i=1 ; i <= listFiles.size(); i++) {
			
		//	System.out.println(listSpeed.get(i).getText());
			driver.findElement(By.xpath("//*[@id='files-button']/span[1]")).click();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='files-button' and @aria-activedescendant='ui-id-"+i+"']"))));
			driver.findElement(By.xpath("//*[@id='files-button' and @aria-activedescendant='ui-id-"+i+"']")).click();
		}
		
		
		List<WebElement> listNumbers = driver.findElements(By.xpath("//*[@id='number']/child::option"));
		System.out.println(listNumbers.size());
		
		for (int i=1 ; i <= listNumbers.size(); i++) {
			
		//	System.out.println(listSpeed.get(i).getText());
			driver.findElement(By.xpath("//*[@id='number-button']/span[1]")).click();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='number-button' and @aria-activedescendant='ui-id-"+i+"']"))));
			driver.findElement(By.xpath("//*[@id='number-button' and @aria-activedescendant='ui-id-"+i+"']")).click();
		}
		
		
		
	}
	
	
	
	
	@Test(priority=6)
	public void  testRentalCarBlock() {
		
		driver.get("https://demoqa.com/controlgroup/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='car-type-button']/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='car-type-button' and @aria-activedescendant='ui-id-1']")).click();
		driver.findElement(By.xpath("//label[@for='transmission-standard']")).click();
		driver.findElement(By.xpath("//label[@for='transmission-automatic']")).click();
		driver.findElement(By.xpath("//label[@for='insurance']")).click();
		driver.findElement(By.id("horizontal-spinner")).click();
		driver.findElement(By.id("horizontal-spinner")).sendKeys("4");
		driver.findElement(By.xpath("//button[contains(text() , 'Book Now!')]")).click();
		
		
}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		//System.out.println("Test completed successfully");
		
	}
	
	

}
