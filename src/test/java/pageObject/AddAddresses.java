package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AddAddresses extends BasePage {

    @FindBy(className = "add-address-button")
    WebElement btn_addNew;

    @FindBy(tagName = "h1")
    WebElement subTitle;

    List<InfoListItem> infoAddress;

    public AddAddresses(WebDriver driver) {
        super(driver);
        infoAddress = new ArrayList<>();
        List<WebElement> informacion = findElements(By.className("info"));
        for(WebElement info : informacion){
            infoAddress.add(new InfoListItem(info));
        }
    }

    public Address clickInAddNew(){
        clickElement(btn_addNew);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        return new Address(driver);
    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isDisplayed();
    }

    public boolean subTitleContains(String contenido){
        return subTitle.getText().contains(contenido);
    }

    public boolean newAddress(String dir){
        for(InfoListItem info : infoAddress) {
            if(info.getAddres1().contains(dir)){
                return true;
            }
        }
        return false;
    }

    public boolean newCityStateZip(String city){
        for(InfoListItem info : infoAddress) {
            if(info.getCity_state_zip().contains(city)){
                return true;
            }
        }
        return false;
    }
}
