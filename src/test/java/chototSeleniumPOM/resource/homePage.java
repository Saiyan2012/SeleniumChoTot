package chototSeleniumPOM.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openHomePage(){
        driver.get("https://www.chotot.org/");
    }
}