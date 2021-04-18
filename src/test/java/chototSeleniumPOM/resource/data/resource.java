package chototSeleniumPOM.resource.data;

import chototSeleniumPOM.resource.page.homePage;
import chototSeleniumPOM.resource.page.loginPage;
import chototSeleniumPOM.resource.page.logoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public @interface resource {

    WebDriver driver = new ChromeDriver();

    loginPage login = new loginPage(driver);
    homePage homePageAction = new homePage(driver);
    logoutPage logout = new logoutPage(driver);


    /* ======================= Location xPath ======================= */
    By phone = By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
    //Locate textbox password
    By pass = By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
    //Locate button 'Đăng nhập' to access login page
    By loginBtnAction = By.xpath("//button[contains(text(),'Đăng nhập')]");
    //Click button 'Đăng nhập' to login
    By loginBtn = By.xpath("//b[contains(text(),'Đăng nhập')]");
    //Locate warning 'Không tìm thấy thông tin người dùng.'
    By warning = By.xpath("//p[contains(text(),'Không tìm thấy thông tin người dùng.')]");
    //Locate warning icon when input wrong phone number
    By warningIcon = By.xpath("//body/div[@id='__next']/div[1]/div[1]/main[1]/div[1]/form[1]/div[2]/div[1]/button[1]/span[1]");
    //Locate icon (X) to delete phone was input to textbox
    By xIconPhone = By.xpath("//body/div[@id='__next']/div[1]/div[1]/main[1]/div[1]/form[1]/div[2]/div[1]/button[1]/span[1]");
    //Locate warning wrong phone number of password
    By warningWrongInfo = By.xpath("//div[contains(@class,'error')]");
    //Locate button 'Hiện' on password's textbox
    By hienBtn = By.xpath("//button[contains(text(),'Hiện')]");
    //Locate button 'Tôi bán'
    By quanLyTinBtn = By.xpath("//span[contains(text(),'Quản lý tin')]");
    //Button 'Thêm' after login success
    By themBtn = By.xpath("//span[contains(text(),'Thêm')]");
    //Move action to menu page (button "Thêm")
    By moveToPopupThem = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[1]");
    //Button 'Đăng xuất'
    By logoutBtn = By.xpath("//div[contains(text(),'Đăng xuất')]");
    //Popup inform account get blocked
    By blockedAcc = By.xpath("//body/div[@id='__next']/div[@id='modal-root']/div[1]/div[1]/div[2]");
    //Locate text 'Tài khoản của bạn đã bị khoá'
    By textBlock = By.xpath("//h3[contains(text(),'Tài khoản của bạn đã bị khoá')]");
    //Button 'Đã Hiểu" on popup block user
    By daHieuBtn = By.xpath("//button[contains(text(),'Đã hiểu')]");
    //Popup inform account get blocked
    By popupBlock = By.xpath("//body/div[@id='__next']/div[@id='modal-root']/div[1]/div[1]/div[2]");
    //Locate text "Tài khoản của bạn đã bị khóa"
    By getTextBlock = By.xpath("//h3[contains(text(),'Tài khoản của bạn đã bị khoá')]");
    //Locate Button 'Tôi bán' on Login page
    By toiBanBtn = By.xpath("//span[contains(text(),'Tôi bán')]");
}
