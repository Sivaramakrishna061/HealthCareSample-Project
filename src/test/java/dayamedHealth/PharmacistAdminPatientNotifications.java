package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PharmacistAdminPatientNotifications {
@Test
	public void pharmacistPatientNotifications() throws InterruptedException {
	/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	/* Launching a browser & Navigate to DayaMed Admin Web Portal */
	driver.get("https://dayamed-dev.dayamed.com/auth/login");
	
	/*Assertions*/
	String Login = driver.findElement(By.xpath("//mat-card-title[text()='Login']")).getText();
	Assert.assertEquals("Login",Login);
	 System.out.println(Login);
		
	 /* WebDriver can generally be said to have a blocking API. USed implicitlyWait */	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("sivaramakrishna061+d@gmail.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Siva@2022");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		/*Given Patient Name And Click on search field*/
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("srk2");

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//img[@alt='More Actions']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Notifications']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Patient Notifications']")).getText(), "Patient Notifications");

		Thread.sleep(10000);
		driver.quit();
		
		
	}
}
