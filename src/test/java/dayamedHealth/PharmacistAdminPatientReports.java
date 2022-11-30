package dayamedHealth;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PharmacistAdminPatientReports {
@Test
	public static void pharmacistPatientReports() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/*WebDriver can generally be said to have a blocking API. USed implicitlyWait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("sivaramakrishna061+d@gmail.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Siva@2022");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		/* wait for elements to appear is enabled */
		Thread.sleep(10000);
		
		/*Given Patient Name And Click on search field*/
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("srk2");
		
		Thread.sleep(10000);
		
		/*Assertions*/
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=' P, SRK2 ']")).getText().equalsIgnoreCase("P, SRK2"));

		
		/*Click on Reports Icon*/
		
		driver.findElement(By.xpath("//img[@alt='Reports']")).click();
		
		  Thread.sleep(10000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reports']//div[1]//mat-card[1]")));
		
		  
		  /* Notes & Treatment*/
		  driver.findElement(By.xpath("//div[@class='reports']//div[1]//mat-card[1]")).click(); 
		  
		  Thread.sleep(10000);
		  
		 /*Assertions */
		 String ActualPatientName =driver.findElement(By.xpath("//span[text()='P, SRK2']")).getText();
		 String ExpectedPatientName = "P, SRK2";
		 Assert.assertEquals(ActualPatientName,ExpectedPatientName);
		System.out.println(ExpectedPatientName);
		 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
		 
           Thread.sleep(3000);
		 
		 /*Click on Location Card*/
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
        Thread.sleep(5000);  
        System.out.println(driver.findElement(By.xpath("//p[text()=' No data available.']")).getText());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
        
        /*Weekly Adherence Report*/
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Weekly Adherence Report']")));
        driver.findElement(By.xpath("//span[text()='Weekly Adherence Report']")).click();
        Thread.sleep(10000);
        System.out.println("Adherence Data not available for last week for this patient");
        driver.quit();
        
     }
         


		
		
		
		
		
		
	}


