package dayamedHealth;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AdminReportsLink {
	@Test
	public static void reportsLink() throws InterruptedException, AWTException {

		/* Setting up ChromeDriver to allow a browser to be automated. */
		System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/*
		 * WebDriver can generally be said to have a blocking API. USed implicitlyWait
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		/* wait for elements to appear is enabled */
		Thread.sleep(3000);

		/* Click on Search input field & Given valid Provider */
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("sivarama");

		Thread.sleep(10000);

		/* Click on View Button */
		driver.findElement(By.xpath("//mat-card[@class='mat-card']//mat-card[1]//div[2]//button[1]")).click();

		Thread.sleep(10000);

		driver.manage().window().maximize();
		/* Click on Patient Search Table With Patient Name */
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("SRK99");
		Thread.sleep(10000);

		/* Click on the 'Reports' Link */
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/div[1]/div[2]/img[1]")).click();
		Thread.sleep(10000);

		/* Assertions */
		boolean Reportsactual = driver.findElement(By.xpath("//mat-card-title[text()='Reports']")).getText()
				.equalsIgnoreCase("Reports");
		Assert.assertTrue(Reportsactual);
		System.out.println(Reportsactual);

		Thread.sleep(10000);

		
		/* Notes & Treatment*/
		  driver.findElement(By.xpath("//div[@class='reports']//div[1]//mat-card[1]")).click(); 
		  
		  Thread.sleep(10000);
		  
		 /*Assertions */
		 String ActualPatientName =driver.findElement(By.xpath("//span[text()='Pedapudi123, SRK99']")).getText();
		 String ExpectedPatientName = "Pedapudi123, SRK99";
		 Assert.assertEquals(ExpectedPatientName, ActualPatientName);
		System.out.println(ExpectedPatientName);
		 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
		 
		Thread.sleep(3000);
		 
		/*Click on Location Card*/
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reports']//div[1]//mat-card[2]")));
		 driver.findElement(By.xpath("//div[@class='reports']//div[1]//mat-card[2] ")).click();
		 Thread.sleep(10000); 
		 /*Assertions */
		 boolean Actual_MedicineAdherence =driver.findElement(By.xpath("//div[text()='Medicine Adherence']")).getText().equalsIgnoreCase("Medicine Adherence");
		 Assert.assertTrue(Actual_MedicineAdherence);
		System.out.println(Actual_MedicineAdherence);
		Thread.sleep(10000);
		
		/*Scroll Up & Down*/
		Robot robot = new Robot();

     // Scroll Down using Robot class
     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
     Thread.sleep(3000);
  // Scroll Up using Robot class
     robot.keyPress(KeyEvent.VK_PAGE_UP);
     robot.keyRelease(KeyEvent.VK_PAGE_UP);
     
     driver.findElement(By.xpath("//mat-icon[text()='clear']")).click(); 
     
     /*Adherence Report*/
  
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Adherence Report']")));
     driver.findElement(By.xpath("//span[text()='Adherence Report']")).click();
     
     /*ToolTips*/
     /*Patient Profile Tooltip*/
     Actions action= new Actions(driver);
     action.moveToElement(driver.findElement(By.xpath("//i[@mattooltip='Patient Profile']"))).build().perform();
     
     System.out.println(driver.findElement(By.xpath("//i[@mattooltip='Patient Profile']")).getAttribute("mattooltip"));
     
     /*Exports in PDF*/
     action.moveToElement(driver.findElement(By.xpath("//img[@mattooltip='Export in PDF']"))).build().perform();
     System.out.println(driver.findElement(By.xpath("//img[@mattooltip='Export in PDF']")).getAttribute("mattooltip"));
     
     /*Dayamed logo*/
     
     action.moveToElement(driver.findElements(By.xpath("//img[@mattooltip='Dayamed logo']")).get(1)).build().perform();
     
     System.out.println(driver.findElements(By.xpath("//img[@mattooltip='Dayamed logo']")).get(1).getAttribute("mattooltip"));
     
     /*Adherence this month*/
     action.moveToElement(driver.findElement(By.xpath("//mat-progress-bar[@mattooltip='Adherence this month']"))).build().perform();
     
     System.out.println(driver.findElement(By.xpath("//mat-progress-bar[@mattooltip='Adherence this month']")).getAttribute("mattooltip"));
/*Scroll up & Down*/
     // Scroll Down using Robot class
     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
     Thread.sleep(3000);
  // Scroll Up using Robot class
     robot.keyPress(KeyEvent.VK_PAGE_UP);
     robot.keyRelease(KeyEvent.VK_PAGE_UP);
     Thread.sleep(5000);
     driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
     Thread.sleep(5000);
     /*wait for Medication Report */
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Medication Report']")));
     Thread.sleep(5000);
     driver.findElement(By.xpath("//span[text()='Medication Report']")).click();
     Thread.sleep(5000);
     /*Dropdowns*/
     
     driver.findElement(By.xpath("//mat-select[@formcontrolname='year']")).click();
     Thread.sleep(10000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' 2021 '] ")));
     driver.findElement(By.xpath("//span[text()=' 2021 '] ")).click();
     Thread.sleep(5000);
     driver.findElement(By.xpath("//mat-select[@formcontrolname='month']")).click();
     Thread.sleep(5000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' January ']")));
     WebElement element = driver.findElement(By.xpath("//span[text()=' May ']"));
     JavascriptExecutor je = (JavascriptExecutor) driver;
     je.executeScript("arguments[0].scrollIntoView(true);",element);
     driver.findElement(By.xpath("//span[text()=' May ']")).click();
     Thread.sleep(5000);
     driver.findElement(By.xpath("//img[@mattooltip='Export in PDF']")).click();
     System.out.println(driver.findElement(By.xpath("//img[@mattooltip='Export in PDF']")).getAttribute("mattooltip"));
     driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
     
     /*Gluco Meter*/
     Thread.sleep(5000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Gluco Meter']")));
     driver.findElement(By.xpath("//span[text()='Gluco Meter']")).click();
     Thread.sleep(3000);  
     System.out.println(driver.findElement(By.xpath("//p[text()=' No data available.']")).getText());
     Thread.sleep(5000);
     driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
     
     /*Weekly Adherence Report*/
     Thread.sleep(10000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Weekly Adherence Report']")));
     driver.findElement(By.xpath("//span[text()='Weekly Adherence Report']")).click();
     Thread.sleep(5000);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Last week Adherence report has been sent to the patient email successfully']")));
     /**Assertions*/
     System.out.println(driver.findElement(By.xpath("//div[text()='Last week Adherence report has been sent to the patient email successfully']")).getText());
     driver.close();
     driver.quit();
	}

}
