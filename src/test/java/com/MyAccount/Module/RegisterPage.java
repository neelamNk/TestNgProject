package com.MyAccount.Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basesclass.Base;
@Test(priority = 1)
public class RegisterPage  extends Base {
	
	
	public static  void Register() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		
 Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul//li[1]//a")).click();
		//Your Personal Details
	 WebElement FirstName = driver.findElement(By.id("input-firstname"));
	 FirstName.sendKeys("Nick");
	 WebElement LastName = driver.findElement(By.name("lastname"));
	 LastName.sendKeys("kush");
	 WebElement EMail = driver.findElement(By.id("input-email"));
	 EMail.sendKeys("Nick@555gmail.com");
	 
	 WebElement Telephone = driver.findElement(By.name("telephone"));
	 
	 Telephone.sendKeys("7688965899");
	 //Your Password
	 WebElement Password = driver.findElement(By.name("password"));
	 
	 Password.sendKeys("Nick@123");
	 
	 WebElement PasswordConfirm = driver.findElement(By.name("confirm"));
	 PasswordConfirm.sendKeys("Nick@123");
	 
	 //Newsletter
	  WebElement radio = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]"));
	  radio.click();
	  
	  //Privacy Policy
	  WebElement Checkbox = driver.findElement(By.xpath("//input [@name=\"agree\"]"));
	  
	  Checkbox.click();
	  WebElement submit = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
	  submit.click();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")), "Your Account Has Been Created");
	  
	}
}
