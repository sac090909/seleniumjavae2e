package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Element30Test {
	
	WebDriver driver;
	Element30PageFb elementPage;
	
	 @BeforeMethod()
	 
	 public void setup(){
		
	 driver= new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://testautomationpractice.blogspot.com/");
	 System.out.println(driver.getTitle());
	 
	 
	}
	 
	
	//@Test
	public void verifyElements() {
		
	elementPage = new Element30PageFb(driver);
	elementPage.enterElementValues("Mr. Selenium", "selenium@gmail.com","223-223-2223");
		
	}
	
	@Test()
	public void verifyButtonSelection() throws InterruptedException {
	
	elementPage = new Element30PageFb(driver);
	elementPage.selectRadioButtonCheckBox();
	
	Thread.sleep(5000);
	
	}
	
	@AfterMethod()
	public void tearDown() {
		
		if(driver !=null) {
			driver.quit();
		}
	}

}
