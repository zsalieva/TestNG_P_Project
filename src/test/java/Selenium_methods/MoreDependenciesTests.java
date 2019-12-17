package Selenium_methods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MoreDependenciesTests {
    @Test
    public void openBrowser(){

    }
    @Test(dependsOnMethods = "openBrowser")
    public void login(){

    }
    @Test (dependsOnMethods = "openBrowser")
    public void logOut(){

    }
    @AfterMethod
    public void CleanUp(){
        System.out.println("Close the browser" );
    }
}
