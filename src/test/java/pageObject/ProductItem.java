package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItem {
    WebElement element;

    public ProductItem(WebElement main){
        this.element = main;
    }

    public String getName(){
        return element.findElement(By.className("product-title")).getText();
    }

    public void addToWish(){
        element.findElement(By.className("add-to-wishlist-button")).click();
    }

    public void addToCompare() {
        element.findElement(By.className("add-to-compare-list-button")).click();
    }
}
