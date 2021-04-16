package chototSeleniumProject.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class logoutChotot {
    WebDriver driver;

    //Constructor
    public logoutChotot(WebDriver driver) {
        this.driver = driver;
    }

    //Click button "Thêm" to show list menu and move action to list menu
    By buttonThem = By.id("btnmenuMoreundefined");
    //Click button "Đăng xuất"
    By logout = By.cssSelector(".appWrapper-Header-menuMore-listItemWrapper:nth-child(20) .appWrapper-Header-menuRightItem");

    //Logout
    public void logoutAction (){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(buttonThem).click();
        {
            //Move to menu page
            WebElement element = driver.findElement(By.cssSelector(".appWrapper-Header-menu"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
            //Scroll down to button "Đăng xuất"
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        //Click button đăng xuất
        driver.findElement(logout).click();
    }
    //Verify logout success, button "Đăng nhập" appear
    public void verifyLogout (){
        String value = driver.findElement(By.cssSelector("b")).getText();
        System.out.println("Back to homepage, button: " + value + " appear!");
    }
}

