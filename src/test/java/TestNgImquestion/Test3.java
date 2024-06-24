package TestNgImquestion;

import java.time.Duration;

import org.apache.commons.math3.geometry.partitioning.Side;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {

WebDriver driver;

	@BeforeMethod
	public void SadeBar() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//ignore  test method
	// is hard depency 
	@Test( priority = 1)
	public void SeachBar() {
		//Trending
WebElement Sidebar = driver.findElement(By.xpath	("//*[@id=\"nav-hamburger-menu\"]"));
Sidebar.click();
 
 driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[3]")).click();
 driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]")).click();
 driver.findElement(By.xpath("//*[@id=\"a-autoid-0\"]")).click();
 //Digital Content and Devices

 //driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]")).click();
// driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]")).click();
		
	}
	
	@Test(dependsOnMethods = {"SeachBar"})
	public void  submanu() {
		System.out.println("SeachBar depend the");
	}
	
	@AfterMethod
	public void  Closedriver() {
		
	}
}
