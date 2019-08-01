package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static utils.SeleniumUtils.clickElement;
import static utils.SeleniumUtils.findElements;

public class CompareList extends BasePO{

    @FindBy(tagName = "h1")
    WebElement subtitle;

    @FindBy(className = "clear-list")
    WebElement btn_ClearList;

    List<CompareListItem> prodName;

    public CompareList(WebDriver driver) {
        super(driver);
        prodName = new ArrayList<>();
        List<WebElement> filasName = findElements(driver, By.cssSelector("tbody tr:nth-child(3) td a"));
        for(WebElement filaName : filasName){
            prodName.add(new CompareListItem(filaName));
        }
    }

    public boolean verifyItemsNameInList(String itemName){
        for(CompareListItem item : prodName){
            if(item.getName().contains(itemName)){
                return true;
            }
        }
        return false;
    }

    public boolean cantItemsinList(){
        for(int i = 0; i < prodName.size(); i++){
            if(i == 1){
                return true;
            }
        }
        return false;
    }

    public boolean subTitleIsDisplayed(){
        return subtitle.isDisplayed();
    }

    public boolean subtitleContains(String contenido){
        return subtitle.getText().contains(contenido);
    }

    public void clearList(){
        clickElement(btn_ClearList, wait);
    }
}
