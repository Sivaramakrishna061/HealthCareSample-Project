package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PharmacistAdminZoomCall {
@Test
	public static void pharmacistZoomCall() throws InterruptedException {
		// TODO Auto-generated method stub
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
			/*call*/
			driver.findElements(By.xpath("//img[@alt='Call Patient']")).get(0).click();
			Thread.sleep(30000);
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//i[text()='account_circle']")));
			action.doubleClick().build().perform();
			
			/*Zoom Call*/
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='User has been registered but did not activate the account.']")));
			
             System.out.println(driver.findElement(By.xpath("//div[text()='User has been registered but did not activate the account.']")).getText());
             
             driver.quit();
	}

}
