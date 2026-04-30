package seleniumjava;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Element29Test {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());

		// DropDown
		WebElement dropdown = driver.findElement(By.id("country"));
		Select selectDropDown = new Select(dropdown);
		List<WebElement> allOptions = selectDropDown.getOptions();
		selectDropDown.selectByVisibleText("China");
		System.out.println(selectDropDown.getFirstSelectedOption().getText());
		// driver.close();

		// DropDownMulti
		WebElement dropdownMulti = driver.findElement(By.id("colors"));
		Select selectDropDownMulti = new Select(dropdownMulti);
		selectDropDownMulti.selectByContainsVisibleText("Red");
		selectDropDownMulti.selectByContainsVisibleText("Blue");

		// DatePicker

		// FileUpload
		String file1 = "C:\\Users\\drsha\\eclipse-workspace\\seleniumjavae2e\\Files\\Test.txt";
		String file2 = "C:\\Users\\drsha\\eclipse-workspace\\seleniumjavae2e\\Files\\Test1.txt";
		driver.findElement(By.id("multipleFilesInput")).sendKeys(file1 + "\n" + file2);

		// Javascript Executor

		WebElement merryLinkText = driver.findElement(By.linkText("merrymoonmary"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", merryLinkText);
		js.executeScript("arguments[0].click()", merryLinkText);

		// WindowHandles

		Set<String> windowIds = driver.getWindowHandles();
		List<String> windowIdsList = new ArrayList(windowIds);

		String parentWindowId = windowIdsList.get(0);
		String childWindowId = windowIdsList.get(1);
		System.out.println(driver.switchTo().window(childWindowId).getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId).getTitle();

		// Dynamic search
		WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		js.executeScript("arguments[0].scrollIntoView()", searchBox);
		searchBox.sendKeys("Hello");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> searcLinks = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));

		for (WebElement searcLink : searcLinks) {
			if (searcLink.getText().equalsIgnoreCase("xxx")) {
				searcLink.click();
				break;
			} else {
				System.out.println("Didn't match");
			}

		}
		
		//
		
		//Dynamic Button
		driver.findElement(By.xpath("//button[contains(@name,'st')]")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'st')]")).click();
		
		//Alert
		driver.findElement(By.id("promptBtn")).click();
		driver.switchTo().alert().sendKeys("Herry Porter");
		driver.switchTo().alert().accept();
		
		WebElement confirmAlertWithWait = driver.findElement(By.xpath("//button[contains(text(),'Confirmation Alert')]"));
		confirmAlertWithWait.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert jsAert = wait.until(ExpectedConditions.alertIsPresent());
		jsAert.dismiss();
		
		//Mouse Hover 
		WebElement mouseHoverBtnt = driver.findElement(By.xpath("//button[text()='Point Me']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHoverBtnt).build().perform();
		
		WebElement doubleClickBtn= driver.findElement(By.xpath("//button[text()='Copy Text']"));
		act.doubleClick(doubleClickBtn).perform();
		WebElement field2 = driver.findElement(By.id("field2"));
		act.click(field2).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.UP).build().perform();
		Thread.sleep(3000);
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.UP).build().perform();
		
		WebElement dragAndDropSource= driver.findElement(By.id("draggable"));
		WebElement dragAndDropDesti= driver.findElement(By.id("droppable"));
		act.dragAndDrop(dragAndDropSource, dragAndDropDesti).build().perform();
		
		//getAttribute link
		
		List <WebElement> linksInPage = driver.findElements(By.tagName("a"));
		for(WebElement linkInPage:linksInPage) {
			linkInPage.getAttribute("href");		
		}
		//driver.findElement(By.linkText("Apple")).click();
		//driver.navigate().back();
	
		//WebTable
		//driver.findElement(By.xpath("//table[@id='productTable']//tr[2]//td[4]")).click();
		
		String matchedItemName = "Tablet";
		List <WebElement> tableElements = driver.findElements(By.xpath("//table[@id='productTable']//tr//td[2]"));
		for(int i=1; i <= tableElements.size(); i++) {
			
			String matchedItemName1 = driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]//td[2]")).getText();
			if(matchedItemName1.equalsIgnoreCase(matchedItemName)) {
				
				js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]//td[4]")));
				
				System.out.println(matchedItemName1 + " found");
			}
			
		}
		
		//Take Screenshot
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\drsha\\eclipse-workspace\\seleniumjavae2e\\Files\\screenshot.png");
		source.renameTo(destination);
		
	
		//New Tab open and open new link for iframe
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.automationtesting.in/Frames.html");
		/*
		 * driver.get("https://demo.automationtesting.in/Frames.html");
		 * 
		 * WebElement iframeToSwitch = driver.findElement(By.id("singleframe"));
		 * driver.switchTo().frame(iframeToSwitch); Thread.sleep(1000);
		 * driver.findElement(By.xpath("//input[@type='text']")).click();
		 * driver.findElement(By.xpath("//input[@type='text']")).clear();
		 * driver.findElement(By.xpath("//input[@type='text']")).sendKeys(
		 * "******************"); driver.switchTo().defaultContent();
		 * Thread.sleep(1000); driver.findElement(By.linkText("Home")).click();
		 * Thread.sleep(1000);
		 */		System.out.println("Test Completed");
		driver.quit();
		
	}

}
