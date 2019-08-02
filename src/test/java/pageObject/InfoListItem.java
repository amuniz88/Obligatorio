package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InfoListItem {

    WebElement element;

    public InfoListItem(WebElement element){ this.element = element; }

    public String getAddres1(){
        return element.findElement(By.className("address1")).getText();
    }

    public String getCity_state_zip(){
        return element.findElement(By.className("city-state-zip")).getText();
    }
}
