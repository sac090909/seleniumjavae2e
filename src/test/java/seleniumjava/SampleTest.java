package seleniumjava;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static void main(String[] args) {

		JSONObject obj = new JSONObject("{\"name\": \"Java\", \"aga\":30}");
		System.out.println(obj.getString("name"));

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String value = "submitBtn";
		driver.findElement(By.xpath("//tagName[@att='" + value + "']"));

	}
//=============================================
	public void click(By locator) {

		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("")).click();
	}
//================================================
	public class LoginPage {

		WebDriver driver;

		By name = By.id("name");
		By pw = By.id("password");

		public LoginPage(WebDriver driver) {

			this.driver = driver;
		}

		public void login(String n, String p) {

			driver.findElement(name).sendKeys(n);
			driver.findElement(pw).sendKeys(p);

		}
				
		}
//====================================		

	
	
}
		



