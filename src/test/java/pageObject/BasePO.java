package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePO {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitAlert;

    public BasePO(WebDriver driver){
        BasePO.driver = driver;
        wait = new WebDriverWait(driver, 30);
        waitAlert = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
