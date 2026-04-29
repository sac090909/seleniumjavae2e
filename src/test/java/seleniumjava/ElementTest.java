package seleniumjava;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

		// dynamic element click
		driver.findElement(By.xpath("//button[contains(text(),'ST')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'ST')]")).click();

		// alert accept
		driver.findElement(By.id("alertBtn")).click();
		driver.switchTo().alert().accept();

		// radio button and check box
		driver.findElement(By.cssSelector("input#male")).click();
		driver.findElement(By.xpath("//label[text()='Sunday']")).click();

		// Get Links
		List<WebElement> links = driver.findElements(By.tagName("a"));

		/*
		 * for(WebElement link :links) {
		 * 
		 * System.out.println(link.getText()); }
		 */
		// Select dropdown

		WebElement selWeb = driver.findElement(By.xpath("//select[@id='country']"));

		Select sel = new Select(selWeb);
		sel.selectByVisibleText("China");
		sel.getFirstSelectedOption().getText();

		System.out.println(sel.getFirstSelectedOption().getText());

		// Action class - drag & drop, double click 

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		
		WebElement doubleClick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//driver.navigate().refresh();
		action.doubleClick(doubleClick).build().perform();
		
		

		//Navigate back
		driver.findElement(By.linkText("Youtube")).click();
		driver.navigate().back();
		
		//Explicit wait
		WebElement footerlink = driver.findElement(By.linkText("merrymoonmary"));
		
		String parentW = driver.getWindowHandle();
		
		// js executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footerlink);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(footerlink));

		footerlink.click();
        
		//Window switch
		Set<String> windowHanldes = driver.getWindowHandles();
		for (String windowHanlde : windowHanldes) {

			if (!windowHanlde.equals(parentW)) {

				driver.switchTo().window(windowHanlde);
				System.out.println(driver.getTitle());
				break;		
			}
		}
		driver.switchTo().window(parentW);
		System.out.println(driver.getTitle());

		//dynamic web table
		
		/*
		 * List<WebElement> rows =
		 * driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr")); for (int
		 * i = 1; i <= rows.size(); i++) { List<WebElement> cols =
		 * driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr[" + i +
		 * "]/td"));
		 * 
		 * for (int j = 1; j <= cols.size(); j++) { String cellValue =
		 * driver.findElement( By.xpath("//table[@id='taskTable']/tbody/tr[" + i +
		 * "]/td[" + j + "]") ).getText();
		 * 
		 * System.out.println("Row " + i + " Col " + j + ": " + cellValue); }
		 * 
		 * }
		 */
		
		String value = driver.findElement(
			    By.xpath("//table[@id='taskTable']//tr[td[text()='Firefox']]/td[2]")
			).getText();

			System.out.println(value);
			
		//File upload 
			
			WebElement upload = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
			upload.sendKeys("C:\\Users\\drsha\\eclipse-workspace\\seleniumjavae2e\\Files\\Test.txt");
		
	}

}
