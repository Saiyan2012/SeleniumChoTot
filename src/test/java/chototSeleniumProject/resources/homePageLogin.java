package chototSeleniumProject.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePageLogin {
    WebDriver driver;

    //constructor
    public homePageLogin (WebDriver driver){
        this.driver = driver;
    }
    //locator "Đăng nhập" button
    By loginBtn = By.cssSelector(".w-normal");

    //Click the button "Đăng nhập"
    public void clickBtnLogin (){
        driver.findElement(loginBtn).click();
    }


}
