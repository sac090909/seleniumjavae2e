package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element30Page {

	WebDriver driver;

	//Locator
	By nameInputBox = By.id("name");

	public Element30Page(WebDriver driver) {
		this.driver = driver;
	}
	
	//Action methods
	
	public void enterElementValues(String name) {
		
		driver.findElement(nameInputBox).sendKeys(name);
			
	}
	
}
