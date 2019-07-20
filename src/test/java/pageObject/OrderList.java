package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderList {

    WebElement element;

    public OrderList(WebElement element){
        this.element = element;
    }

    public String getName() {
        return element.findElement(By.cssSelector("td:nth-child(2)")).getText();
    }

    public double getPriceList(){
        return Double.valueOf(element.findElement(By.cssSelector("td:nth-child(3)")).getText().replace("$",""));
    }

    public double getPrecioTotal(){
        return Double.valueOf(element.findElement(By.cssSelector("td:nth-child(5)")).getText().replace("$",""));
    }

    public double getPreciosOrder(){
        return Double.valueOf(element.findElement(By.className("cart-total-right")).getText().replace("$",""));
    }
}
