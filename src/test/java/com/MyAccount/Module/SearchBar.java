package com.MyAccount.Module;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basesclass.Base;

public class SearchBar extends Base {

	// @Test(priority = 1)
	public static void SearchBarPage() throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.findElement(By.name("search")).sendKeys("iMac");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();

		TakesScreenshot tS = (TakesScreenshot) driver;
		File SrcFile = tS.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./Sceenshort/iMacSaerch.png");
		FileUtils.copyFile(SrcFile, DestFile);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]")).click();
		// Adding imac in card

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();

		// String expectedText = "Success: You have added iMac to your shopping cart!";
		// String actualText =
		// driver.findElement(By.xpath("//*[@id=\\\"product-product\\\"]/div[1]")).getText();
		// Assert.assertEquals(actualText, expectedText, "Searchpage failed or
		// unexpected product add ");

		// Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")),
		// "Success: You have added iMac to your shopping cart!");

		driver.findElement(By.xpath("//*[@id=\"cart\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")),
				"Products marked with *** are not available in the desired quantity or not in stock!");
	}

	@Test(priority = 2)
	public void dropdwonMenu() {
		// Handling dropdwon menu
		Actions actions = new Actions(driver);
		 WebElement Desktops =
		 driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]"));
		 actions.moveToElement(Desktops).build().perform();
		 driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]")).click();

	/*	Actions actions = new Actions(driver);
		WebElement LaptopsNotebooks = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]"));

		actions.moveToElement(LaptopsNotebooks).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]//div//div[1]")).click();

		driver.findElement(By.linkText("Continue")).click();
*/
	}
}
