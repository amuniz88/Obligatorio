package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends BasePage{

    @FindBy(id = "Email")
    WebElement txt_email;

    @FindBy(id = "Password")
    WebElement txt_pass;

    @FindBy(className = "login-button")
    WebElement btn_Login;

    public LogIn(WebDriver driver){
        super(driver);
    }

    public void loginUser(String email, String password){
        setText(txt_email, email);
        setText(txt_pass, password);
        clickElement(btn_Login);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-search-box-form")));
    }
}
