package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class menuMyAccount {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(partialLinkText = "Change password")
    WebElement menu_changePass;

    public menuMyAccount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public ChangePassword clickInChangePassword(){
        SeleniumUtils.clickElement(menu_changePass, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        return new ChangePassword(driver);
    }


}
