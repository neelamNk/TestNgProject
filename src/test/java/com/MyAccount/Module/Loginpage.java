package com.MyAccount.Module;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



import Basesclass.Base;

public class Loginpage  extends Base {
@Test(priority = 1)
	public   void  Login () throws InterruptedException, EncryptedDocumentException, IOException {
	
		//Assert.assertEquals(driver.findElements(By.xpath("/*[@id=\"content\"]/div/div[2]/div/h2")), "Returning Customer");
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 Thread.sleep(1000);
		driver.findElement(By.linkText("Login")).click();

        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            File file = new File("./src/test/resources/ConfigFiles/Qafox.com.xlsx");
            if (!file.exists()) {
                throw new FileNotFoundException("Excel file not found at specified path: " + file.getAbsolutePath());
            }

            fileInputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(fileInputStream);

            int rowcount = workbook.getSheet("Qafox.com").getLastRowNum();
            for (int i = 1; i <= rowcount; i++) {
                String un = workbook.getSheet("Qafox.com").getRow(i).getCell(0).getStringCellValue();
                String pw = workbook.getSheet("Qafox.com").getRow(i).getCell(1).getStringCellValue();
                System.out.println(un + "---->" + pw);

                driver.findElement(By.name("email")).sendKeys(un);
                driver.findElement(By.name("password")).sendKeys(pw);
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

                // Verifying if the login was successful
              //  String expectedText = "My Account";
                //String actualText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
                String expectedText = "My Account";
                String actualText      =   driver.findElement(By.xpath("//*[@id=\"content\"]//h2[1]")).getText();
                Assert.assertEquals(actualText, expectedText, "Login failed or unexpected page title");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
		/*
		FileInputStream Files  = new FileInputStream("./src/test/resources/ConfigFiles/Qafox.com.xlsx");
		Workbook wb =   WorkbookFactory.create(Files);
		//wb.getSheet("Qafox.com").getRow(1).getCell(0).getStringCellValue();
		// get last row number where the data is present
		int rowcount = wb.getSheet("Qafox.com").getLastRowNum();
		for(int i=1;i<= rowcount;i++) {
		String un =wb.getSheet("Qafox.com").getRow(i).getCell(0).getStringCellValue();
		String pw =wb.getSheet("Qafox.com").getRow(i).getCell(1).getStringCellValue();
		System.out.println(un+ "---->"+ pw);
		

		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")), "My Account");
		*/
		} 
	}