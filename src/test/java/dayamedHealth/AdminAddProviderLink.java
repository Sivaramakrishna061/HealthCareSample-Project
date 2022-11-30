package dayamedHealth;

import java.net.SocketException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminAddProviderLink {
@Test
	public static void addProviderLink() throws InterruptedException,SocketException {

		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\Software Testing (2022)\\1. Software Testing (PDF)\\2. Smoke Test Cases\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");
		
		/*WebDriver can generally be said to have a blocking API. USed implicitlyWait & Browser Commands*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		/*Assertion*/
		String Login = driver.findElement(By.xpath(" //mat-card-title[text()='Login']")).getText();
		Assert.assertEquals("Login",Login);
		System.out.println("/*Print the Current Page*/");
		System.out.println(Login);

		/*Finding Web Elements for Input Fields (UserName, Password & Buttons for Login Page) */
		/* Login Page */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String ActualProviders = driver.findElement(By.xpath("//span[text()='Providers']")).getText();
		Assert.assertEquals("Providers", ActualProviders );
		
		Thread.sleep(1000);
		/* Navigated to Home page & Click 'Menu'* ICON */
		driver.findElement(By.cssSelector("button[class='topNavButton-Menu mat-icon-button'] mat-icon[role='img']")).click();
		Thread.sleep(1000);
		
		/* Click on Angle Brackets in SideDrawer */
		driver.findElement(By.xpath("//body/app-root[1]/app-admin[1]/app-layout[1]/div[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/app-side-nav[1]/mat-nav-list[1]/mat-list-item[1]/div[1]/mat-icon[1]")).click();
		Thread.sleep(1000);

		/* Click on the 'AddProvider'*Element */
		driver.findElement(By.xpath("//body/app-root[1]/app-admin[1]/app-layout[1]/div[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/app-side-nav[1]/mat-nav-list[1]/div[1]/a[2]/div[1]")).click();

		          Thread.sleep(3000);
            /*Add Provider Page Assertions*/
		String ActualAddProvider = driver.findElement(By.xpath("//span[text()='Add Provider']")).getText();
		Assert.assertEquals("Add Provider", ActualAddProvider);
		
		/* Fill the form with Validate & Mandatory fields */
		/* Input Fields */
		driver.findElement(By.xpath("//input[@placeholder= 'First Name']")).sendKeys("SRK4");
		driver.findElement(By.xpath("//input[@placeholder= 'Last Name']")).sendKeys("Pharmacist");
		Thread.sleep(3000);
		
		/* DropDown */
		driver.findElement(By.xpath(" //mat-select[@aria-label='Country Code']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text() = ' IND (+91) | 91 ' ]")));

		driver.findElement(By.xpath("//span[text() = ' IND (+91) | 91 ' ]")).click();

		/* Input Fields */
		driver.findElement(By.xpath("//input[@placeholder = 'Mobile Number']")).sendKeys("9492915149");

		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("sivaramakrishna061+x7890@gmail.com");

		driver.findElement(By.xpath("//input[@placeholder = 'Address']")).sendKeys("vijawada");
		driver.findElement(By.xpath("//input[@placeholder = 'Zip Code']")).sendKeys("1234");

		driver.findElement(By.xpath("//input[@placeholder = 'Licence']")).sendKeys("123456");
		Thread.sleep(3000);
		/* ProviderType DropDown */
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("//span[text() ='Provider Type' ]")));
		driver.findElement(By.xpath("//span[text() ='Provider Type' ]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text() = ' Live ']")).click();

		/* Click the 'Submit' button & Appear toast message */
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/* Appear Toast Message & Validate Assertions */
		String email = "sivaramakrishna061+x789@gmail.com";
		if (email == "sivaramakrishna061+x789@gmail.com") {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
			WebElement ToastElement = driver.findElement(By.xpath("//div[text()='Email already exist']"));
			wait.until(ExpectedConditions.textToBePresentInElement(ToastElement, "Email already exist"));
			String ToastMessage_actual = driver.findElement(By.xpath("//div[text()='Email already exist']")).getText();
			Assert.assertEquals("Email already exist", ToastMessage_actual);
			System.out.println(ToastMessage_actual);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60));
			WebElement ToastElement = driver.findElement(By.xpath("//div[text()='Provider data has been saved successfully']"));
			wait.until(ExpectedConditions.textToBePresentInElement(ToastElement,"Provider data has been saved successfully"));
			System.out.println(ToastElement.getText());
			Thread.sleep(5000);
			WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
			Thread.sleep(10000);
			submitButton.click();
		}
		
		driver.close();
		driver.quit();
		
	

	}

}