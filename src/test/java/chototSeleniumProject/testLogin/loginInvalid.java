package chototSeleniumProject.testLogin;

import chototSeleniumProject.resources.LoginPage;
import chototSeleniumProject.resources.homePageLogin;
import chototSeleniumProject.resources.logoutChotot;
import chototSeleniumProject.resources.privateDashboard;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginInvalid {
    @Test
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("http://chotot.org");
        //Create objet of homePage
        homePageLogin home = new homePageLogin(driver);
        //Create object of loginPage
        LoginPage login = new LoginPage(driver);
        //Create object of privateDashboard
        privateDashboard priDsh = new privateDashboard(driver);
        //Create object of logoutChotot
        logoutChotot logout = new logoutChotot(driver);


        //Access to login page
        login.accessLoginPage();
        //Input wrong phone number
        login.inputPhone("036759998");
        System.out.println("TestCase new phone number without signup");
        login.verifyInvalid();
        //Refresh page
        driver.navigate().refresh();
        //Input character into username' field
        login.inputPhone("kjdakdaksdhaks");
        System.out.println("TestCase character");
        login.verifyInvalid();
        //Refresh page
        driver.navigate().refresh();
        //Input special character into username's field
        login.inputPhone("036759980@");
        System.out.println("TestCase phonenumber with special character");
        login.verifyInvalid();
        driver.quit();
    }
}