package TestNgImquestion;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;

	@BeforeClass
	public void BrowserLounch() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 2)
	public void Signin() {
		driver.findElement(By.xpath("//div[@id=\"nav-tools\"]/a[2]")).click();
 WebElement Email = driver.findElement(By.id("ap_email"));
 Email.sendKeys("neelamkw24@gmail.com");
  WebElement Continue = driver.findElement(By.xpath("//*[@id=\"continue\"]//input"));
  Continue.click();

	}

	//@Test(priority = 1)
	public void CreateAccount() {
		WebElement CreateAccount = driver.findElement(By.xpath("//*[@id=\"auth-create-account-link\"]/span/a"));
		CreateAccount.click();
		 WebElement Yourname = driver.findElement(By.id("ap_customer_name"));
		 Yourname.sendKeys("neelam");
		WebElement Mobilenumber = driver.findElement(By.id("ap_phone_number"));
		Mobilenumber.sendKeys("8296574063");
		WebElement Password = driver.findElement(By.id("ap_password"));
		Password.sendKeys("nick@123");
   
 WebElement Verifymobilenumber = driver.findElement(By.xpath("//*[@id=\"auth-continue\"]/span"));
 
 Verifymobilenumber.click();
       	
	}

	public void logout() {

	}

	public void sreach() {

	}

	@AfterClass
	public void CloseBwoser() {
 driver.close();
	}
}
