package dayamedHealth;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PhramacistAdminLoginPage {
@Test
	public static void pharmacistAdminLoginPage() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");
		/*WebDriver can generally be said to have a blocking API. USed implicitlyWait*/

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		String Login = driver.findElement(By.xpath(" //mat-card-title[text()='Login']")).getText();
		Assert.assertEquals("Login",Login);
		System.out.println("/*Print the Current Page*/");
		System.out.println(Login);
		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("sivaramakrishna061+d@gmail.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Siva@2022");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(10000);
		
		/*Pharmacist Admin Page*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='PhramcistAdmin']"))));
		System.out.println(driver.findElement(By.xpath("//span[text()='PhramcistAdmin']")).getText());
		
		Thread.sleep(5000);
		/*scroll to footer*/
		WebElement footer = driver.findElement(By.xpath("//p[@class='footer']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",footer);
		Thread.sleep(10000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.visibilityOf(footer));
		
		driver.manage().window().maximize();
		driver.quit();

	}

}
