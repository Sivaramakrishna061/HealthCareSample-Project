package dayamedHealth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminProviderViewPatients {
@Test
	public static void providerViewPatients() throws InterruptedException {
		/* Setting up ChromeDriver to allow a browser to be automated. */
	System.setProperty("webdriver.chrome.driver","D:\\SRK\\Backup\\DayamedHealth_Domain\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/* Launching a browser & Navigate to DayaMed Admin Web Portal */
		driver.get("https://dayamed-dev.dayamed.com/auth/login");
		
		/* Browser Maximization & Browser Commands */
		driver.manage().window().maximize();

		/* WebDriver can generally be said to have a blocking API. USed implicitlyWait */	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/* Finding Web Elements for Input Fields (UserName & Password for Login Page) */
		driver.findElement(By.cssSelector("input[formcontrolname= 'username']")).sendKeys("admin@dayamed.com");
		driver.findElement(By.cssSelector("input[formcontrolname= 'password']")).sendKeys("Admin123E");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		/*Click on Search input field & Given valid Provider */
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("sivarama");
		
		Thread.sleep(10000);
		
		/* Click on View Button*/
		driver.findElement(By.xpath("//mat-card[@class='mat-card']//mat-card[1]//div[2]//button[1]")).click();
		
		Thread.sleep(10000);

		/*Click on Patient Search Table With Patient Name */
			driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).click();
			driver.findElement(By.xpath("//input[@formcontrolname='searchString']")).sendKeys("SRK99");
			Thread.sleep(10000);
			String SearchString= driver.findElement(By.xpath("//span[text()=' Pedapudi123, SRK99 ']")).getText();
			
			String[] split=SearchString.split("Pedapudi123,");
			String formatName = split[1].trim();
			/*matching search term with actual term*/
			System.out.println("formatName");
			System.out.println(formatName);
			
				Thread.sleep(10000);
			driver.findElement(By.xpath("//tbody/tr[1]/td[7]/div[1]/div[1]/img[1]")).click();
			
			Thread.sleep(10000);
			
				driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/div[2]/button[1]")).click();
				Thread.sleep(10000);
			/* Scroll Down to visible of Dosage Information*/
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement dosageinfo= driver.findElement(By.xpath("//mat-card-title[text()=' Dosage Information ']"));
			js.executeScript("arguments[0].scrollIntoView(true);", dosageinfo);
			Thread.sleep(10000);
			driver.close();
			driver.quit();
			
		
			
				
			
	}

}
