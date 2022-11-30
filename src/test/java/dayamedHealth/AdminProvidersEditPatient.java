package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminProvidersEditPatient {
	@Test
	public static void providersEditPatient() throws InterruptedException {
		/* Setting up ChromeDriver to allow a browser to be automated. */
		System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");

		/* WebDriver can generally be said to have a blocking API. USed implicitlyWait */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		/*Finding Web Elements for Input Fields (UserName, Password & Buttons for Login Page) */
		/* Login Page */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(6000);
	
		
		/*Click on Search input field & Given valid Provider */
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("sivarama");
		Thread.sleep(6000);
		
		/* Click on Provider Edit Icon*/
		driver.findElement(By.xpath("//mat-card[@class='mat-card']//mat-card[1]//div[1]//div[3]//div[1]//mat-icon[1]")).click();
		driver.navigate().back();
		Thread.sleep(6000);
		/*Click on Search input field & Given valid Provider --2 */
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("sivarama");

		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//mat-card[@class='mat-card']//mat-card[1]//div[2]//button[1]")).click();
		
		
		Thread.sleep(10000);

	/*Click on Patient Search Table With Patient Name */
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("SRK");
		Thread.sleep(10000);
	
		/* Click On More Action & Edit Icon*/
		driver.findElement(By.xpath("//img[@alt='More Actions']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Edit Patient']")).click();
		Thread.sleep(10000);
		
		/*Patient Form - Edit*/
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("SRK99");
		
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Pedapudi123");
		
		driver.findElement(By.xpath("//input[@formcontrolname='emergencyContactName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='emergencyContactName']")).sendKeys("sivaramakrishna");
		
		driver.findElement(By.xpath("//input[@formcontrolname='emergencyContactNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='emergencyContactNumber']")).sendKeys("8912356671");
		
		driver.findElement(By.xpath("//input[@formcontrolname='medicareId']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='medicareId']")).sendKeys("949291");
		
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).sendKeys("5325");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		driver.close();
		driver.quit();
		
		
		
		
	}

}
