package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PharmacistEditPatient {

	@Test
	public static void editPatient() throws InterruptedException {

		/* Setting up ChromeDriver to allow a browser to be automated. */
		System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/* Assertions */
		String Login = driver.findElement(By.xpath(" //mat-card-title[text()='Login']")).getText();
		Assert.assertEquals("Login", Login);
		System.out.println(Login);
		
		/*WebDriver can generally be said to have a blocking API. USed implicitlyWait*/

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("sivaramakrishna061+c@gmail.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Siva@2022");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		boolean PatientText = driver.findElement(By.xpath("//span[@class='breadcrumb-list-item ng-star-inserted']")).getText().equalsIgnoreCase("Patients");
		Assert.assertTrue(PatientText);
		System.out.println(PatientText);
		
		// driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		
		/* Navigated to Home page & Click 'Menu'* ICON */
		driver.findElement(By.xpath("//mat-icon[text()='menu']")).click();
		Thread.sleep(10000);

		/* Expand Left Side Drawer & Click on Patients 'Down Arrow' */
		driver.findElement(By.xpath("//span[text()='Patient']")).click();
		Thread.sleep(10000);
		
		/* Click on Patient List */
		driver.findElement(By.xpath("//div[text()='Patient List']")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/div[1]/div[4]/img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mat-icon[text()='edit']")).click();

		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//span[text()='Edit Patient']")).getText().equalsIgnoreCase("Edit Patient")) {
			System.out.println("Edit Patient Form Starts Now..!!");
		}
		
		/* Edit Patient form*/
		Thread.sleep(10000);
		WebElement state = driver.findElement(By.xpath("//input[@placeholder='State']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",state);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='State']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='State']")).sendKeys("INDIA");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).sendKeys("521250");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@formcontrolname='location']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='location']")).sendKeys("vijawada");
		/*Scroll to down And Toast Message*/
		Thread.sleep(10000);
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView(true);",submit);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement toastmessage = driver.findElement(By.xpath(" //div[text()='Patient data has been saved successfully']"));
	wait.until(ExpectedConditions.visibilityOf(toastmessage));
	System.out.println(toastmessage.getText());
		
	Thread.sleep(10000);
	
	/*search field*/
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='searchString']"))));
	driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
	driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("Jayanth");
	Thread.sleep(10000);
	System.out.println(driver.findElement(By.xpath("//td[text()=' INDIA ']")).getText());
		Thread.sleep(10000);
		driver.close();
		driver.quit();
		
		
	
		
		
		
		
		
		
		
		
		
		

	}

}
