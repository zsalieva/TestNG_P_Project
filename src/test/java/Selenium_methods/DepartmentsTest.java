package Selenium_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class DepartmentsTest {
    WebDriver driver;
    Select dropDown;  // Initializing the Select method on the top to reuse in different tests
    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");

    }
    @Test
    public void test1() {
      WebElement element=  driver.findElement(By.id("searchDropdownBox"));
        // To be able to work with DropDown list use Select class
        dropDown = new Select(element);
        // In order to get the first value we use getFirstSelected Opt and stored the value in a String.
        String selectedDep = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedDep, "All Departments");
    }
    //verify that options sorted Alphabetically
     @Test
     public void sortAlphabetical(){
      //dropDown.getOptions();  <-- this method gives us all the options of the DropDown List
//         for(WebElement allOptions : dropDown.getOptions()) {
//             System.out.println(allOptions.getText());
//             // Use CompareTo method to compare letters
//         }
             for(int i=0; i<dropDown.getOptions().size(); i++){
                 String curent =dropDown.getOptions().get(i).getText();
                 String next =dropDown.getOptions().get(i+1).getText();

                 System.out.println("Comparing"+ curent+ "With"+next);
                 Assert.assertTrue(curent.compareTo(next)<=0);
             }

         }

         @Test
         public void mainDepertments(){

         }

        @AfterClass
      public void TearDown(){
        driver.quit();
        }
    }

