package Basesclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base  {

public static WebDriver driver =null ;
@BeforeTest
public  static void  OpenBrowser() throws IOException {
	
FileInputStream filePro = new FileInputStream("./src/test/resources/ConfigFiles/common.properties");
 Properties props = new Properties();
 props.load(filePro);
 driver = new ChromeDriver();
    driver.get(props.getProperty("Url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
}

@AfterTest
public void CloseBrowser() {
    if (driver != null) {
   //     driver.quit();
    }
}
}

