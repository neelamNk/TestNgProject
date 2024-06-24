package com.MyAccount.Module;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Basesclass.Base;
@Test(priority = 1  )
public class MyAccount extends Base{
	

public  static void  MyAccountPage()  {
	
	
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	
}
}
 

  
 












