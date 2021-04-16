package chototSeleniumProject.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class privateDashboard {
    WebDriver driver;

    //Constructor
    public privateDashboard(WebDriver driver) {
        this.driver = driver;
    }

    //Locate page title of private dashboard
    By pageTitlePrivateDashboard = By.id("pageTitle");

    //Locate entry point to private dashboard - button "Tôi bán"
    By toiBanBtn = By.cssSelector(".appWrapper-Header-navItem:nth-child(4) .sc-htpNat");

    //Verify pate title of private dashboard

    public void verifyPageTitlePrivateDashboard (){
        driver.findElement(By.id("pageTitle")).click();
        assertThat(driver.findElement(By.id("pageTitle")).getText(), is("Quản lý tin đăng"));
    }

    //Click the button Tôi bán
    public void clickBtnToiBan (){
        driver.findElement(toiBanBtn).click();
    }

}

