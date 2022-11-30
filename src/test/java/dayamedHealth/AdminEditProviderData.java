package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminEditProviderData {
	
@Test
	public static void editProviderData() throws InterruptedException {
		
		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		
		/*Waits & Thread*/
		Thread.sleep(6000);
		
		
		/*Browser Commands*/
		driver.manage().window().maximize();
		
		/*Click on Provider in Provider List Table*/
		driver.findElement(By.xpath("//mat-card[@class='mat-card']//mat-card[1]//div[1]//div[3]//div[1]//mat-icon[1]")).click();
		
		/*WebDriver Waits & Thread*/
		Thread.sleep(6000);
		
		
		/*Edit Provider Page*/
		/* Input Fields - Clear & Data given*/
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("SRK3");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Pedapudi2");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='location']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='location']")).sendKeys("Vijayawada2");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).sendKeys("5212502");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='licence']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='licence']")).sendKeys("123455");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		
		
		/*Print Successful Message*/ 
		 System.out.println("Provider data has been saved successfully");
		 driver.close();
		driver.quit();
		
		
		
		
	}
	

	
}
