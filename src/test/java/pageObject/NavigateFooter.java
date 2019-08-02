package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class NavigateFooter {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NavigateFooter navFoot;

    @FindBy(partialLinkText = "Compare products list")
    WebElement linkCompareProd;

    @FindBy(partialLinkText = "Contact us")
    WebElement linkContactUs;

    public NavigateFooter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public CompareList clickInCompareProducts(){
        SeleniumUtils.scrollIntoView(driver, linkCompareProd);
        SeleniumUtils.clickElement(linkCompareProd, wait);
        return new CompareList(driver);
    }

    public Contact clickInContactUs(){
        SeleniumUtils.scrollIntoView(driver, linkContactUs);
        SeleniumUtils.clickElement(linkContactUs, wait);
        return new Contact(driver);
    }
}
