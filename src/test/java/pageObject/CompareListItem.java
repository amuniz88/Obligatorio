package pageObject;

import org.openqa.selenium.WebElement;

public class CompareListItem {

    WebElement element;

    public CompareListItem(WebElement element){
        this.element = element;
    }

    public String getName(){
        return element.getText();
    }
}
