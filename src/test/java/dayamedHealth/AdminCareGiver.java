package dayamedHealth;

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

public class AdminCareGiver {
@Test
	public static void careGiver() throws InterruptedException {
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
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(10000);
		String ActualProviders = driver.findElement(By.xpath("//span[text()='Providers']")).getText();
		Assert.assertEquals("Providers", ActualProviders );
		driver.manage().window().maximize();
		
		/* Navigated to Home page & Click 'Menu'* ICON */
		driver.findElement(By.cssSelector("button[class='topNavButton-Menu mat-icon-button'] mat-icon[role='img']")).click();
		
		Thread.sleep(10000);
		
		/* Click on careGiver & Add CareGiver Angle Brackets*/
		driver.findElement(By.xpath("//body/app-root[1]/app-admin[1]/app-layout[1]/div[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/app-side-nav[1]/mat-nav-list[1]/mat-list-item[2]/div[1]/mat-icon[1]")).click();
		
		driver.findElement(By.xpath("//div[text()='Add Caregiver']")).click();
		
/*fill the Mandatory fields in CareGiver Provider form */
		
		Thread.sleep(10000);
		boolean addcaregiver = driver.findElement(By.xpath("//mat-card-title[text()='Add Caregiver']")).getText().equalsIgnoreCase("Add Caregiver");
		Assert.assertTrue(addcaregiver);
		System.out.println(addcaregiver);
		
		/* FirstName And LastName field */
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("SRK99");
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Pedapudi123");
		
		/* Date Picker*/
		driver.findElement(By.xpath("//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='mat-calendar-arrow']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Previous 20 years']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space()='1994']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space()='JUN']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space()='15']")).click();
		Thread.sleep(10000);
		
		/* DropDown */
		driver.findElement(By.xpath(" //mat-select[@aria-label='Country Code']")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text() = ' IND (+91) | 91 ' ]")));

		driver.findElement(By.xpath("//span[text() = ' IND (+91) | 91 ' ]")).click();
		
		/* Input Fields */
		driver.findElement(By.xpath("//input[@placeholder = 'Mobile Number']")).sendKeys("9492915149");

		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("sivaramakrishna061+x12346@gmail.com");

		driver.findElement(By.xpath("//input[@placeholder = 'Address']")).sendKeys("vijawada");
		driver.findElement(By.xpath("//input[@placeholder = 'Zip Code']")).sendKeys("1234");
		
		
		/*Vertical Scroll Down & Turn On Slide Toggle*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.xpath("//p[@class='footer']"));
		js.executeScript("arguments[0].scrollIntoView(true);",footer );
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//span[text()=' Email Notifications ']")).click();
		driver.findElement(By.xpath("//span[text()= ' Text Notifications ']")).click();
		
		/*Click On Submit Button */
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String email ="sivaramakrishna061+x1234@gmail.com";
		if (email!="sivaramakrishna061+x1234@gmail.com")
		{
			/* Appear Toast Message & Validate Assertions */
			Thread.sleep(10000); 
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(80)); 
			 WebElement ToastElement = driver.findElement(By.xpath("//div[text()='Provider data has been saved successfully']"));
			 wait.until(ExpectedConditions.textToBePresentInElement(ToastElement,"Provider data has been saved successfully"));
			   System.out.println(ToastElement.getText());
			 
		}
		
		else
		{
			/* Appear Toast Message & Validate Assertions */
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
			WebElement ToastElement = driver.findElement(By.xpath("//div[text()='Email already exist']"));
			wait.until(ExpectedConditions.textToBePresentInElement(ToastElement, "Email already exist"));
			String ToastMessage_actual = driver.findElement(By.xpath("//div[text()='Email already exist']")).getText();
			Assert.assertEquals("Email already exist", ToastMessage_actual);
			System.out.println(ToastMessage_actual);
			driver.findElement(By.xpath("//button[@class='mat-raised-button mat-warn']")).click();
			
		}
		driver.close();
		driver.quit();
	}

}
