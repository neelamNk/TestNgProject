package com.MyAccount.Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basesclass.Base;


public class  LogoutPage   extends Base{

	
	@Test(priority = 1 )
	public static void  Logoutpage() throws InterruptedException {
		
		//Logout
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		  Assert.assertEquals(driver.findElements(By.xpath("//*[@id=\"content\"]/h1")), "Account Logout");
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Continue")).click();

	}
}
