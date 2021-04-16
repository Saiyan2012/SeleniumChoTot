package cucumberSelenium.resources.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class LoginSteps {
    HashMap vars = new HashMap<String, Object>();
    WebDriver driver = new ChromeDriver();

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    /* ======================STEPS====================== */
    /* ***************************** Login successfully ***************************** */

    @Given("im on logging page")
    public void im_on_logging_page() {
        driver.get("http://chotot.org");
        driver.findElement(By.xpath("//b[contains(text(),'Đăng nhập')]")).click();
    }

    @When("i logging with valid phone and password")
    public void i_logging_with_valid_phone_and_password() {
        driver.findElement(By.cssSelector(".cpt13la:nth-child(2) .i1pbvj0j")).sendKeys("0367599014");
        driver.findElement(By.cssSelector(".cpt13la:nth-child(3) .i1pbvj0j")).sendKeys("123456");
        driver.findElement(By.cssSelector(".w-normal")).click();
    }

    @Then("i can click button Tôi bán to access to private dashboard")
    public void i_can_click_button_toi_ban_to_access_to_private_dashboard() {
        //Verify text "Quản lý tin đăng" trong phần "Tôi bán"
        driver.findElement(By.cssSelector(".appWrapper-Header-navItem:nth-child(4) .sc-htpNat")).click();
        assertThat(driver.findElement(By.id("pageTitle")).getText(), is("Quản lý tin đăng"));
        driver.quit();
    }

    /* ***************************** Login invalid ***************************** */


    @When("User input new phone")
    public void user_input_new_phone() {
        driver.findElement(By.cssSelector(".i1lb3co8 > .error")).click();
        driver.findElement(By.cssSelector(".i1lb3co8 > .error")).sendKeys("0987766646");
        assertThat(driver.findElement(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")).getText(), is("Không tìm thấy thông tin người dùng."));
    }

    @When("User input character")
    public void user_input_character() {
        driver.findElement(By.cssSelector(".i1lb3co8 > .error")).click();
        driver.findElement(By.cssSelector(".i1lb3co8 > .error")).sendKeys("012398776762323");
        //driver.findElement(By.cssSelector("main")).click();
        assertThat(driver.findElement(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")).getText(), is("Không tìm thấy thông tin người dùng."));
        /* *****************************  ***************************** */
        //Verify icon error
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("button > .error"));
            assert (elements.size() > 0);
        }
        //Verify button "Đăng nhập" unclickable
        {
            WebElement element = driver.findElement(By.cssSelector(".w-normal"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertFalse(isEditable);
        }
    }

    @When("User input special character")
    public void user_input_special_character() {
        driver.findElement(By.cssSelector(".i1lb3co8 > .error")).sendKeys("!@#$@#!@#");
        driver.findElement(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")).click();
        assertThat(driver.findElement(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")).getText(), is("Không tìm thấy thông tin người dùng."));
    }

    @Then("The message will show")
    public void the_message_will_show() {

    }


    /* ***************************** Login wrong user name and password ***************************** */

    @When("User input wrong username and password")
    public void user_input_wrong_username_and_password() {
        driver.findElement(By.cssSelector(".cpt13la:nth-child(2) .i1pbvj0j")).sendKeys("0367599043");
        driver.findElement(By.cssSelector(".cpt13la:nth-child(3) .i1pbvj0j")).sendKeys("123123");
        driver.findElement(By.cssSelector(".w-normal")).click();
    }

    @Then("After four times wrong user get banned")
    public void after_four_times_wrong_user_get_banned() {

        driver.findElement(By.cssSelector(".w-normal")).click();
        driver.findElement(By.cssSelector(".w-normal")).click();
        driver.findElement(By.cssSelector(".w-normal")).click();
        driver.findElement(By.cssSelector(".w-normal")).click();

        //List<WebElement> elements = driver.findElements(By.cssSelector(".e66t3pu"));
        //assert (elements.size() > 0);

        //driver.switchTo().window(vars.get("root").toString());
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".m1g60xjl"));
            assert (elements.size() > 0);
        }
        //driver.findElement(By.cssSelector(".large")).click();
        driver.quit();
    }

    /* ***************************** Login with third party account ***************************** */
    //@When("User want to login with 3th party account")
    //public void user_want_to_login_with_3th_account() {
    //}

    @Then("Popup appear to login with Facebook")
    public void popup_appear_to_login_with_Facebook() {
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".s1w0ft87:nth-child(1)")).click();
        vars.put("win3423", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win3423").toString());
        {
            List<WebElement> elements = driver.findElements(By.id("facebook"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.id("facebook")).click();
        driver.close();
    }

    @Then("Popup appear to login with Google")
    public void popup_appear_to_login_with_Google() {
        driver.switchTo().window(vars.get("root").toString());
        driver.findElement(By.className("l114i1vc")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".s1w0ft87:nth-child(2)")).click();
        vars.put("win5314", waitForWindow(2000));
        driver.switchTo().window(vars.get("win5314").toString());
        {
            List<WebElement> elements = driver.findElements(By.className("kHn9Lb"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.className("kHn9Lb")).click();
        driver.close();
    }

    @Then("Popup appear to login with AppleID")
    public void popup_appear_to_login_with_AppleID() {
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".s1w0ft87:nth-child(3)")).click();
        vars.put("win7623", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win7623").toString());
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".logo"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.cssSelector("oauth-signin")).click();
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        driver.quit();
    }

    /* ***************************** Login invalid input ***************************** */
    @When("User input invalid username {string} and password {string}")
    public void user_input_invalid_username_and_password(String string, String string2) {
        driver.findElement(By.cssSelector(".cpt13la:nth-child(2) .i1pbvj0j")).sendKeys(string);
        driver.findElement(By.cssSelector(".cpt13la:nth-child(3) .i1pbvj0j")).sendKeys(string2);
        driver.findElement(By.cssSelector(".w-normal")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")));
        }
        driver.close();
    }

    @Then("The message {string} will show")
    public void the_message_will_show(String string) {
        assertThat(driver.findElement(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")).getText(), is(string));
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("button > .error"));
            assert (elements.size() > 0);
        }
        System.out.println(driver.findElements(By.cssSelector(".cpt13la:nth-child(2) > .prswihc")));
        driver.close();
    }
}
