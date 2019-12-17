package Selenium_methods;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
         driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Comiksin");;
     //  driver.findElement(By.xpath("//*[@id='fakebox-input']"));

        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("*[class='gNO89b']")));
        driver.findElement(By.cssSelector("*[class='gNO89b']")).click();
      // driver.findElement(By.cssSelector("*[class='gNO89b']")).click();
        String title= driver.getTitle();
        System.out.println(title);

        Assert.assertTrue(driver.getTitle().contains("Comiksin - Google Search"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("End");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}