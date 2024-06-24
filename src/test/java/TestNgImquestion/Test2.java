package TestNgImquestion;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {
 WebDriver driver;
	@BeforeClass
	public void BrowserLounch() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test()
	public  void  LangloageChange() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"nav-tools\"]/a[1]")).click();
	
		Thread.sleep(2000);
		//driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"international-customer-select-preferences-form\"]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]")).click();
		
	//	Thread.sleep(2000);
		//	driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div")).click();
		//	driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]")).click();
		
	//	Actions ac =  new Actions(driver);
// WebElement checkbox = driver.findElement(By.id("//*[@id=\"nav-flyout-icp\"]/div[2]/a[2]"));
// ac.moveToElement(checkbox).click().build().perform();
	}
	
}
