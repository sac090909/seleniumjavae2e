package seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element30PageFb {

	WebDriver driver;

	//Locator
	//By nameInputBox = By.id("name");
	@FindBy(id="name") WebElement nameInputBox;
	@FindBy(css="#email") WebElement emailInputBox;
	@FindBy(css="input[id='phone']") WebElement phoneInputBox;
	@FindBy(xpath="//input[@id='female']") WebElement femaleRadioBtn;
	@FindBy(xpath="//input[@type='checkbox' and @class='form-check-input']") List<WebElement> checkBoxs;

	public Element30PageFb(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Action methods
	
	public void enterElementValues(String name, String email, String phone) {
		
		nameInputBox.sendKeys(name);
		emailInputBox.sendKeys(email);	
		phoneInputBox.sendKeys(phone);
	}
	
	public void selectRadioButtonCheckBox() {
		
		if(!femaleRadioBtn.isSelected()) {
			femaleRadioBtn.click();
		}
		
		for(WebElement checkBox:checkBoxs) {
			
			checkBox.click();
		}
	}
	
}
