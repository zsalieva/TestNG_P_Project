package Selenium_methods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods="login")      // will run only when Login test works
    public void zbuySth(){
        System.out.println("Lets buy smth");
    }


    @Test (priority = 5)    // will run as a fifth one
    public void homePage(){
        System.out.println("HOme page");
    }
}


