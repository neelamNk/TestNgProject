package Autorox;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAutomation {

	    private static WebDriver driver;

	    @BeforeClass
	    public static void launchApp() throws InterruptedException, Exception {
	        driver = new ChromeDriver();
	        driver.get("https://app.autorox.co:9443/axuat/login");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @Test(priority = 1)
	    public void excelsheet() throws IOException {

	        FileInputStream fileInputStream = null;
	        Workbook workbook = null;

	        try {
	            File file = new File("./data/Autorox.xlsx");
	            if (!file.exists()) {
	                throw new FileNotFoundException("Excel file not found at specified path: " + file.getAbsolutePath());
	            }

	            fileInputStream = new FileInputStream(file);
	            workbook = WorkbookFactory.create(fileInputStream);

	            int rowcount = workbook.getSheet("rox1").getLastRowNum();
	            for (int i = 1; i <= rowcount; i++) {
	                String un = workbook.getSheet("rox1").getRow(i).getCell(0).getStringCellValue();
	                String pw = workbook.getSheet("rox1").getRow(i).getCell(1).getStringCellValue();
	                System.out.println(un + "---->" + pw);

	                WebElement uid = driver.findElement(By.id("userName_login"));
	                uid.sendKeys(un);
	    	        WebElement pwd = driver.findElement(By.id("password_login"));
	    	        pwd.sendKeys(pw);
	    	        WebElement clickButton = driver.findElement(By.className("btn"));
	    	        clickButton.click();
	             
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
	            }}
	    }

	    @Test()
	    public void enterInvalidCredentials() {
	        String user = "invalidUser";
	        String password = "invalidPassword";
	        WebElement uid = driver.findElement(By.id("userName_login"));
	        WebElement pwd = driver.findElement(By.id("password_login"));
	        WebElement clickButton = driver.findElement(By.className("btn"));
	        uid.sendKeys(user);
	        pwd.sendKeys(password);
	        clickButton.click();

	        // Add verification step to check for login failure message
	     //   WebElement errorMessage = driver.findElement(By.id("error_message"));
	      //  assertEquals(true, errorMessage.isDisplayed());
	    }

	 //   @Test(priority = 3)
	    public void elementAvailable() {
	        String loc = "someElementId";
	        boolean exp = true;
	       // boolean a = driver.findElement(By.id(loc)).isDisplayed();
	       // assertEquals(exp, a);
	    }

	 //   @Test(priority = 4)
	    public void elementEnable() {
	        String loc = "someElementId";
	        boolean exp1 = true;
	        boolean isEnabled = driver.findElement(By.id(loc)).isEnabled();
	        assertEquals(exp1, isEnabled);
	    }

	   @AfterClass
	    public static void closeApp() {
	        if (driver != null) {
	            driver.close();
	            driver.quit();
	        }
	    }
	

}
