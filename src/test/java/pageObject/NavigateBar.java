package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class NavigateBar {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(partialLinkText = "Register")
    WebElement linkRegister;

    @FindBy(partialLinkText = "Log in")
    WebElement linkLogin;

    @FindBy(partialLinkText = "Log out")
    WebElement linkLogout;

    @FindBy(partialLinkText = "Wishlist")
    WebElement linkWishList;

    @FindBy(partialLinkText = "My account")
    WebElement linkMyAccount;

    public NavigateBar(WebDriver driver) {
        NavigateBar.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public PORegistrarUsuario clickInRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(linkRegister));
        SeleniumUtils.clickElement(linkRegister, wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new PORegistrarUsuario(driver);
    }

    public LogIn clickInLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(linkLogin));
        SeleniumUtils.clickElement(linkLogin, wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new LogIn(driver);
    }

    public HomePage clickInLogout(){
        SeleniumUtils.clickElement(linkLogout, wait);
        return new HomePage(driver);
    }

    public WishList clickInWishList(){
        SeleniumUtils.clickElement(linkWishList , wait);
        return new WishList(driver);
    }

    public MyAccount clickInMyAccount(){
        SeleniumUtils.clickElement(linkMyAccount, wait);
        return new MyAccount(driver);
    }
}
