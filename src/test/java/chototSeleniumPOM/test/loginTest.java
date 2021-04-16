package chototSeleniumPOM.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import static chototSeleniumPOM.resource.resource.*;


public class loginTest {
    private static JavascriptExecutor js;
    private static HashMap<String, Object> vars;

    @BeforeTest
    public static void setUp() {
        homePageAction.openHomePage();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testCaseLoginValid() {
        login.accessToLoginPage();
        login.loginAction("0367599015", "123456");
        login.clickBtnLogin();
        login.accessToUserDashboard(); //Login success can access to user dashboard
    }

    @Test(priority = 2)
    public void logout() {
        logout.clickBtmThem(); //To show menu with logout button
        logout.clickBtnLogout(); //Click button logout
        logout.verifyBtnLoginAfterLogout();//Logout susscess if the button 'Đăng nhập' appear on homepage
    }

    @Test(priority = 3)
    public void testCaseLoginInvalid() {
        login.accessToLoginPage();
        //Input invalid phone
        login.loginAction("123123123", "123123");
        login.clickBtnLogin();
        System.out.print("Test case invalid phone: ");
        login.showWarningInvalidPhone();
        //Clear textbox more code than refresh
        driver.navigate().refresh();
        //Input phone include special charater
        login.loginAction("123@423@", "123123");
        login.clickBtnLogin();
        System.out.print("Test case phone with special character: ");
        login.showWarningInvalidPhone();
        //Refresh for next test case
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void leaveBlankPhoneOrPassword() {
        int i = 1;
        switch (i++) {
            case 1:
                login.loginAction("", "123123");
                System.out.print("Test case leave blank phone: ");
                login.verifyEmptyUsernamePassword();
                login.verifyLoginBtnActiveOrNot();
            case 2:
                login.loginAction("123123", "");
                System.out.print("Test case leave blank password: ");
                login.verifyEmptyUsernamePassword();
                login.verifyLoginBtnActiveOrNot();
            case 3:
                login.loginAction("", "");
                System.out.print("Test case leave blank phone and password: ");
                login.verifyEmptyUsernamePassword();
                login.verifyLoginBtnActiveOrNot();

            default:
                login.loginAction("12312312", "12312312");
                System.out.print("Test case full fill phone and password: ");
                login.verifyEmptyUsernamePassword();
                login.verifyLoginBtnActiveOrNot();
        }
    }

    @Test(priority = 5)
    public void blockAccountWrongPass() {
        System.out.println("Test case account get block when wrong password more than 5 times.");
        login.blockAccountWrongPassword("0367599020", "123123");
        login.popupBlockAccount();
    }
}

