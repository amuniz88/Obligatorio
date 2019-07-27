package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListItem {

    WebElement element;

    public WishListItem(WebElement element){
        this.element = element;
    }

    public String getName(){
        return element.findElement(By.cssSelector("td:nth-child(5)")).getText();
    }

    public double getPrice(){
        String price = element.findElement(By.cssSelector("td:nth-child(6) span")).getText().replace("$", "");
        return Double.valueOf(price.replace(",", ""));
    }

    public int getCantidad(){
        return Integer.valueOf(element.findElement(By.cssSelector("td:nth-child(7) input")).getAttribute("value"));
    }

    public double getTotalPrice(){
        String totalPrice = element.findElement(By.cssSelector("td:nth-child(8) span")).getText().replace("$", "");
        return Double.valueOf(totalPrice.replace(",", ""));
    }
//    public void addToCart(){
//        element.findElement(By.cssSelector("button[data-original-title='Add to Cart']")).click();
//    }
//
//    public void delete(){
//        element.findElement(By.cssSelector("button[data-original-title='Remove']")).click();
//    }
}
