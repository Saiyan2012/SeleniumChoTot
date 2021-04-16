package chototSeleniumProject.testLogin;

import chototSeleniumProject.resources.LoginPage;
import chototSeleniumProject.resources.homePageLogin;
import chototSeleniumProject.resources.logoutChotot;
import chototSeleniumProject.resources.privateDashboard;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginChotot {
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
        //Input user's phone & password
        login.inputPhone("0367599001");
        login.inputPwd("123456");

        //Click login

        login.clickBtnLogin();
        Thread.sleep(2000);

        // Access to private dashboard and verify page title
        priDsh.clickBtnToiBan();

        //Verify page title of private dashboard
        priDsh.verifyPageTitlePrivateDashboard();
        //Test result, get title of private dashboard
        System.out.println("TestCase 01 Login successfully: Passed - Current page is " + driver.getTitle());


        /* **************** */
        /* Log out */
        /* **************** */
        System.out.println("Logout account to move to next Testcase.");
        //logout action
        logout.logoutAction();
        //Verify logout success
        logout.verifyLogout();
        driver.close();
        }
    }

