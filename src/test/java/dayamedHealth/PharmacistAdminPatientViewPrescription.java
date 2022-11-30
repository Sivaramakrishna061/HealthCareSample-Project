package dayamedHealth;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PharmacistAdminPatientViewPrescription {
@Test
	public static void patientViewPrescription() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");
		/*Assertions*/
		String Login = driver.findElement(By.xpath(" //mat-card-title[text()='Login']")).getText();
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
		/*Given Patient Name And Click on search field*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='searchString']"))));
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("srk99");
		Thread.sleep(10000);
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()=' Pedapudi123, SRK99 ']"))));
		String srk=driver.findElement(By.xpath("//span[text()=' Pedapudi123, SRK99 ']")).getText();
		String[] split = srk.split(",");
		String formattedName = split[1].trim();
		System.out.println(formattedName);
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//img[@alt='View Prescriptions']")).click();
		driver.findElements(By.xpath("//span[text()=' View Prescription ']")).get(1).click();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//mat-card-title[text()='Diagnosis']"))));
		WebElement element = driver.findElement(By.xpath("//mat-icon[text()='timer']"));
		Thread.sleep(10000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
		Thread.sleep(10000);
		WebElement close = driver.findElement(By.xpath("//span[text()='Cancel']"));
		je.executeScript("arguments[0].scrollIntoView(true);",close);
		 close.click();
		 Thread.sleep(10000);
		driver.quit();
		
	}

}
