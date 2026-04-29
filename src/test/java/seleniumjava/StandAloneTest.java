package seleniumjava;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		String URL = "https://rahulshettyacademy.com/client";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);
		driver.findElement(By.id("userEmail")).sendKeys("bofa@test.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);

		List<WebElement> productListWebElement = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));

		for (WebElement prodWE : productListWebElement) {

			if (prodWE.findElement(By.xpath("//h5/b[contains(text(),'ZARA COAT 3')]")).getText()
					.equals("ZARA COAT 3")) {
				Thread.sleep(1000);
				prodWE.findElement(By.xpath("(//*[contains(text(),'Add To Cart')][2])")).click();
			} else {
				System.out.println("Differnet Prodcut");
			}
		}

		driver.quit();

	}

}
