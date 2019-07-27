package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.SeleniumUtils.findElements;

public class WishList extends BasePO{

    List<WishListItem> productos;

    public WishList(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = findElements(driver, By.cssSelector("tbody tr"));
        for (WebElement fila : filas){
            productos.add(new WishListItem(fila));
        }
    }

    public boolean elementsInToList(){
        return productos.size() > 0;
    }

    public boolean verifyItemsInList(String prodItem){
        for(WishListItem item : productos){
            if(item.getName().contains(prodItem)){
                return true;
            }
        }
        return false;
    }

    public boolean verifyPriceTotalProduct(String prodItem){
        for(WishListItem item : productos){
            if(item.getName().contains(prodItem)) {
                if (item.getPrice() * item.getCantidad() == item.getTotalPrice()) {
                    return true;
                }
            }
        }
        return false;
    }
}
