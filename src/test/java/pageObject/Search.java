package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class Search {

    @FindBy(id = "small-searchterms")
    WebElement txt_Search;

    @FindBy(css = "[class = \"button-1 search-box-button\"]")
    WebElement btn_Search;

    WebDriver driver;
    WebDriverWait wait;

    public Search(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchResult buscarProducto(String producto){
        SeleniumUtils.setText(txt_Search, wait, producto);
        SeleniumUtils.clickElement(btn_Search, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new SearchResult(driver);
    }
}
