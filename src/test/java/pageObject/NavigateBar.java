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

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NavigateBar bar;
    protected static String productName;

    @FindBy(partialLinkText = "Register")
    WebElement linkRegister;

    @FindBy(partialLinkText = "Log in")
    WebElement linkLogin;

    public NavigateBar(WebDriver driver) {
        this.driver = driver;
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
}
