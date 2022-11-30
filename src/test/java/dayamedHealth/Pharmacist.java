package dayamedHealth;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Pharmacist {
	@Test
	public static void pharmacist() throws InterruptedException {
		// TODO Auto-generated method stub
		/* Setting up ChromeDriver to allow a browser to be automated. */
		System.setProperty("webdriver.chrome.driver","D:\\Software Testing (2022)\\1. Software Testing RoadMap\\6. Smoke Test Cases\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/*WebDriver can generally be said to have a blocking API. USed implicitlyWait*/

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("sivaramakrishna061+c@gmail.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Siva@2022");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(10000);
		/* Get the Patient Page */
		boolean PatientText = driver.findElement(By.xpath("//span[@class='breadcrumb-list-item ng-star-inserted']")).getText().equalsIgnoreCase("Patients");
		Assert.assertTrue(PatientText);
		System.out.println(PatientText);
		// driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		Thread.sleep(10000);
		/* Navigated to Home page & Click 'Menu'* ICON */
		driver.findElement(By.xpath("//mat-icon[text()='menu']")).click();
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		/* Expand Left Side Drawer & Click on Patients 'Down Arrow' */
		driver.findElement(By.xpath("//span[text()='Patient']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text()='Add Patient']")).click();
		Thread.sleep(10000);

		/* Assertions */
		boolean ActualAddPatient = driver.findElement(By.xpath("//mat-card-title[text()='Add Patient']")).getText().equalsIgnoreCase("Add Patient");
		Assert.assertTrue(ActualAddPatient);
		System.out.println(ActualAddPatient);

		/* Add Patient 'form' */
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("SRK94");
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Pedapudi");

		/* Date Picker */
		driver.findElement(
				By.xpath("//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']")).click();
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
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("sivaramakrishna061+x12345@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname='medicareId']")).sendKeys("577678");
		driver.findElement(By.xpath("//input[@formcontrolname='insuranceAgency']")).sendKeys("678765");
		driver.findElement(By.xpath("//input[@placeholder = 'Address']")).sendKeys("vijawada");
		driver.findElement(By.xpath("//input[@placeholder = 'Zip Code']")).sendKeys("1234");
        Thread.sleep(10000);
        System.out.println(driver.findElement(By.xpath("//label[text()='Patient Type']")).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Submit']")).click();

		/* Appear Toast Message & Validate Assertions */
/*
		String email = "sivaramakrishna061+x12345@gmail.com";
		if (email != "sivaramakrishna061+x12345@gmail.com") {
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
			wait.until(ExpectedConditions.textToBePresentInElement(ToastElement,
					"Provider data has been saved successfully"));
			System.out.println(ToastElement.getText());
			WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
			submitButton.click();
			
			
		}

		
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click(); */
		Thread.sleep(10000);
		System.out.println("Already Used this medicareid, a toast Message appeared");
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String patientName = "SRK94";
		WebElement patientSearch = driver.findElement(By.xpath("//input[@formcontrolname='searchString']"));
		patientSearch.sendKeys(patientName);
		String patientdetail = driver.findElement(By.xpath("//span[normalize-space()='Pedapudi, SRK94']")).getText();
		String[] split = patientdetail.split(",");
		String ActualName = split[1].trim();
		System.out.println(patientName);
		Assert.assertEquals(patientName,  ActualName);
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		

	}

}
