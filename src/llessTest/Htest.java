package llessTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Htest {

        public static void main(String[] args) throws IOException, InterruptedException{
        	
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
               //System.setProperty("webdriver.chrome.driver",
                       // "C:\\Users\\vibin\\eclipse-workspace\\Hless_test\\ChromeDriverPath");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
                WebDriver driver = new ChromeDriver(options);
                //driver.get("https://contentstack.built.io");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver.get("http://192.168.1.103:8020/");
                System.out.println("title is: " + driver.getTitle());
                driver.findElement(By.id("username")).sendKeys("vibin");
                driver.findElement(By.id("userpassword")).sendKeys("vibin@123");
                driver.findElement(By.name("login")).click();
                
                Thread.sleep(4000);
                
                
                driver.findElement(By.linkText("Add My Points")).click();
                Thread.sleep(2000);
                
                Select parentRPT = new Select(driver.findElement(By.id("parentCategory")));
                parentRPT.selectByVisibleText("HR RPT");
                Select cat_RPT = new Select(driver.findElement(By.id("category")));
                cat_RPT.selectByVisibleText("HR");
                Select trig_RPT = new Select(driver.findElement(By.id("trigger")));
                trig_RPT.selectByVisibleText("HR0021");
                
                
                Thread.sleep(1000);
                
             // Create object of SimpleDateFormat class and decide the format
                DateFormat dateFormat = new SimpleDateFormat("DD/mm/yyyy ");
                
                //get current date time with Date()
                Date date = new Date();
                
                // Now format the date
                String date1= dateFormat.format(date);
                
                // Print the Date
                System.out.println(date1);
                
                driver.findElement(By.id("triggerdate")).sendKeys(date1);
                Thread.sleep(1000);
                File scrFile = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("C:\\Users\\vibin\\eclipse-workspace\\Hless_test\\Screenshot\\shot33.png"));
                System.out.println("RPTS submited");
                driver.quit();

                
	}

}
