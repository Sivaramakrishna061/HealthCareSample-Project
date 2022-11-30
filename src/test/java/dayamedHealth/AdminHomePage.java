
package dayamedHealth;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class AdminHomePage {
@Test
	public static void homePage() throws InterruptedException {

		/* Setting up ChromeDriver to allow a browser to be automated. */
		System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/* WebDriver can generally be said to have a blocking API. USed implicitlyWait */
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Browser Maximization & Browser Commands */
		driver.manage().window().maximize();
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		String Login = driver.findElement(By.xpath(" //mat-card-title[text()='Login']")).getText();
		Assert.assertEquals("Login",Login);
		System.out.println("/*Print the Current Page*/");
		System.out.println(Login);

		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String ActualProviders = driver.findElement(By.xpath("//span[text()='Providers']")).getText();
		Assert.assertEquals("Providers", ActualProviders );
		System.out.println("/*Print the Current Page*/");
		System.out.println(ActualProviders);

		/* wait for elements to appear is enabled */
	
		Thread.sleep(10000);
		
		/* Click on 'Menu' ICON */
		driver.findElement(By.xpath("//mat-icon[text()='menu']")).click();

		/* Click on Angle Bracket */
		driver.findElement(By.xpath("//body/app-root[1]/app-admin[1]/app-layout[1]/div[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/app-side-nav[1]/mat-nav-list[1]/mat-list-item[1]/div[1]/mat-icon[1]")).click();

		Thread.sleep(10000);
		
		/* Click on the 'Providers List' */
		driver.findElement(By.xpath("//div[text()='Provider List']")).click();

		/* Click on the Search Table Filter and Pass the Existing Provider Name */
		driver.findElement(By.xpath(" //input[@aria-invalid='false']")).click();
		driver.findElement(By.xpath(" //input[@aria-invalid='false']")).sendKeys("SRK3");
		String ExpectedProvider = "SRK3";

		/*  Wait for Results Appear */
		String ActualProvider = driver.findElement(By.xpath("//p[text()=' Pedapudi2, SRK3 ']")).getText();
		String[] splitProvider = ActualProvider.split(",");
		String formattedName = splitProvider[1].trim();
		Assert.assertEquals(ExpectedProvider, formattedName);
		System.out.println("/*Wait for Results Appear*/");
		System.out.println(formattedName);
		System.out.println("/*Count No of Providers list*/");
		System.out.println(driver.findElement(By.xpath("//span[@class='pagination']")).getText());
		Thread.sleep(10000);
		driver.close();
		driver.quit();
		
}	
		
	}

