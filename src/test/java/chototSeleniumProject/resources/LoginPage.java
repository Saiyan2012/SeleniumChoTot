package chototSeleniumProject.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.TrueTypeFont;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginPage {
    WebDriver driver;

    //Constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    //Locator user's phone
    By phoneNbr = By.cssSelector(".cpt13la:nth-child(2) .i1pbvj0j");

    //Locator user's password
    By passwordUser = By.cssSelector(".cpt13la:nth-child(3) .i1pbvj0j");

    //Locator login buton
    By loginBtn = By.cssSelector(".w-normal");

    //locator login access
    By loginAccess = By.xpath("//b[contains(text(),'Đăng nhập')]");
    //Locate warning text when input wrong phonenumber
    By warning = By.cssSelector(".cpt13la:nth-child(2) > .prswihc");

    //Access to login page

    public void accessLoginPage (){
        driver.findElement(loginAccess).click();
    }

    //Input user's phone
    public void inputPhone (String phone) {
        //explicit, implicit wait
        driver.findElement(phoneNbr).click();
        driver.findElement(phoneNbr).sendKeys(phone);
    }
    public void getPhone (String phoneNbr) {
        driver.findElement(By.id(phoneNbr)).getText();
        WebElement getPhoneNbr = driver.findElement(By.id(phoneNbr));
    }
    //Input user's password
    public void inputPwd (String pass) {
        driver.findElement(passwordUser).sendKeys(pass);
    }
    //Click the button "Đăng nhập"
    public void clickBtnLogin (){
        driver.findElement(loginBtn).click();
    }
    //Verify warning wrong username input
    public void verifyInvalid () throws InterruptedException {
        //Verify warning text
        if (driver.findElement(warning).getText() != null) {
            Thread.sleep(3000);
            System.out.print(" -> Expected warning: "+driver.findElement(warning).getText() +"\n");
        } else {
            System.out.print("Test fail, have no warning when input wrong phonenumber");
        }

    }
}
