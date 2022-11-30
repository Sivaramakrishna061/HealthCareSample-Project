package dayamedHealth;



import java.awt.event.KeyEvent;
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

public class PharmacitAdmiAddPrescription {
@Test
	public static void pharmacistAddPrescription() throws InterruptedException {
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			/*Given Patient Name And Click on search field*/
			driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
			driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("srk2");
			
			Thread.sleep(10000);
			
			/*Assertions*/
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()=' P, SRK2 ']")).getText().equalsIgnoreCase("P, SRK2"));
			
			driver.findElement(By.xpath("//tbody/tr[1]/td[7]/div[1]/div[1]/img[1]")).click();
			Thread.sleep(10000);
			
			/*Get Patient Name*/	
			boolean ActualPatientName = driver.findElement(By.xpath("//span[text()='P,SRK2']")).getText().equalsIgnoreCase("P,SRK2");	
			Assert.assertTrue(ActualPatientName);
			System.out.println(driver.findElement(By.xpath("//span[text()='P,SRK2']")).getText());
			
			driver.findElement(By.xpath("//button[text()='Add Prescription']")).click();
			Thread.sleep(10000);
			
			/*Check Add Prescription Page or Not*/
			System.out.println(driver.findElement(By.xpath("//span[text()='Add Prescription']")).getText().equalsIgnoreCase("Add Prescription"));
			Thread.sleep(10000);
			
			/*Add Prescription*/
			driver.findElement(By.xpath("//div[@class='mat-select-arrow']")).click();
			Thread.sleep(10000);
			WebElement element = driver.findElement(By.xpath("//span[text()=' Dev Dayamed Prescription ']"));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			element.click();
			
			driver.findElement(By.xpath("//input[@placeholder='Select Diagnosis']")).sendKeys("fever");
			Thread.sleep(10000);
			
			/*diagnosis Search filter*/
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' Fever, unspecified ']")));
			WebElement element1= driver.findElement(By.xpath("//span[text()=' Fever, unspecified ']"));
			element1.click();
			
			System.out.println(driver.findElement(By.xpath("//mat-hint[text()=' Fever, unspecified ']")).isDisplayed());
			
			
			/*Dosage Information*/	
			WebElement dosageinformation = driver.findElement(By.xpath(" //mat-card-title[text()='Dosage Information']"));
			JavascriptExecutor js3 = (JavascriptExecutor)driver;
			js3.executeScript("arguments[0].scrollIntoView(true);", dosageinformation);
			driver.findElement(By.xpath("//input[@id='selectMedicine']")).click();
			driver.findElement(By.xpath("//input[@id='selectMedicine']")).sendKeys("paracet");
			Thread.sleep(10000);
			WebElement element2= driver.findElement(By.xpath("//span[text()=' PARACET 500 MG CAPLET - NDC: 55061001550 [R.WEINSTEIN]']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element2);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' PARACET 500 MG CAPLET - NDC: 55061001550 [R.WEINSTEIN]']")));
			driver.findElement(By.xpath("//span[text()=' PARACET 500 MG CAPLET - NDC: 55061001550 [R.WEINSTEIN]']")).click();
	        
			/*Wait for display timer, SIG code */
			Thread.sleep(10000);
			driver.findElement(By.xpath("//mat-icon[text()='timer']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[text()='SIG Code']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[text()=' CUSTOM ']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[text()='02:00 AM']")).click();
			Thread.sleep(10000);
			WebElement savebutton = driver.findElement(By.xpath("//span[text()='Save']"));
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].scrollIntoView(true);",savebutton);
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			Thread.sleep(10000);
			
			/*Calendar information*/
			driver.findElement(By.xpath("//mat-icon[text()='calendar_today']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[text()='Frequency Type']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[text()=' Daily ']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			driver.findElement(By.xpath("//div[text()='15']")).click();
			Thread.sleep(10000);
			// Scroll Down 
			WebElement element5 = driver.findElement(By.xpath("//span[text()='Save']"));  
			JavascriptExecutor js9 = (JavascriptExecutor) driver;
			js9.executeScript("arguments[0].scrollIntoView(true);",element5);
			element5.click();
			
			/*quantity dispansed*/
			driver.findElement(By.xpath("//input[@formcontrolname='quantityDispensed']")).sendKeys("1");
	       /*Scroll down*/
			WebElement element6 = driver.findElement(By.xpath("//span[text()='Submit ']"));  
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].scrollIntoView(true);",element6);
			element6.click();
			Thread.sleep(10000);
			driver.quit();
		
			
}

}
