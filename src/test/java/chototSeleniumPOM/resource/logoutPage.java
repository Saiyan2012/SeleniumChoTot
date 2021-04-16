package chototSeleniumPOM.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static chototSeleniumPOM.resource.resource.*;

public class logoutPage {
    WebDriver driver;

    public logoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtmThem () {
        driver.findElement(themBtn).click();
    }

    public void clickBtnLogout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        {
            //Move to menu page
            WebElement element = driver.findElement(moveToPopupThem);
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
            //Scroll down to button "Đăng xuất"
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        //Click button đăng xuất
        driver.findElement(logoutBtn).click();
    }

    //Verify logout success, button "Đăng nhập" appear
    public void verifyBtnLoginAfterLogout() {
        String value = driver.findElement(By.cssSelector("b")).getText();
        System.out.println("Logout success, back to homepage, button: " + value + " appear!");
    }

}
