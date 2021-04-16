package chototSeleniumPOM.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static chototSeleniumPOM.resource.resource.*;


public class loginPage {
    WebDriver driver;
    private Map<String, Object> vars;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    /* ======================= Action Class ======================= */

    //Click button login to access login page
    public void accessToLoginPage() {
        driver.findElement(loginBtn).click();
    }

    //Input username and password
    public void loginAction(String phoneNbr, String pwd) {
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(phoneNbr);
        driver.findElement(pass).click();
        driver.findElement(pass).sendKeys(pwd);
    }

    public void clickBtnLogin() {
        driver.findElement(loginBtnAction).click();
    }

    public void accessToUserDashboard() {
        driver.findElement(quanLyTinBtn).click();
        if (driver.getTitle().equals("Quản lý tin")) {
            System.out.println("Test case login Valid, Login success, im on page: " + driver.getTitle());
        } else
            System.out.println("You are not log in!");
    }

    public void verifyEmptyUsernamePassword() {
        WebElement inputPhone = driver.findElement(phone);
        WebElement inputPass = driver.findElement(pass);
        String checkInputPhone = inputPhone.getAttribute("value");
        String checkInputPass = inputPass.getAttribute("value");
        if (checkInputPhone.isEmpty()) {
            System.out.print("Phone is empty");
        } else if (checkInputPass.isEmpty()) {
            System.out.print("Password is empty");
        } else {
            System.out.print("Phone/password are not empty!");
        }
    }

    public void verifyLoginBtnActiveOrNot() {
        String color = driver.findElement(loginBtnAction).getCssValue("background-color");
        String hexColor = Color.fromString(color).asHex();
        if (hexColor.equals("#cacaca")) {
            System.out.println(", button 'Đăng nhập' is unactive");
        } else
            System.out.println(" Button 'Đăng nhập' is enable");
    }

    public void showWarningInvalidPhone() {
        String warningDisplay = driver.findElement(warning).getText();
        if (warningDisplay.equals("Không tìm thấy thông tin người dùng.")) {
            System.out.println(warningDisplay);
        } else
            System.out.println("There is no warning when input wrong username");
    }

    public void blockAccountWrongPassword(String phoneNbr, String pwd) {
        driver.findElement(loginBtn).click();
        driver.findElement(phone).sendKeys(phoneNbr);
        driver.findElement(pass).sendKeys(pwd);

        for (int i = 1; i < 5; i++) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(loginBtnAction).click();
            System.out.println(" -> " + driver.findElement(warningWrongInfo).getText());
        }
    }

    public void popupBlockAccount() {
        driver.findElement(loginBtnAction).click();
        System.out.println(driver.findElement(textBlock).getText());
        {
            //Move action to popup
            WebElement element = driver.findElement(popupBlock);
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        System.out.println("After 5 times wrong: " + driver.findElement(textBlock).getText());
    }
}