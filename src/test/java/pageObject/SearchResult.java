package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends BasePage{

    @FindBy(className = "product-box-add-to-cart-button")
    WebElement btn_AddToCart;

    @FindBy(className = "product-item")
    List<WebElement> listElementos;

    @FindBy(id = "bar-notification")
    WebElement notificationBar;

    List<ProductItem> product;

    public SearchResult(WebDriver driver){
        super(driver);
        product = new ArrayList<>();
        for(WebElement element : listElementos){
            product.add(new ProductItem(element));
        }
    }

    public ProductDetail selectProd(String elemento){
        for(ProductItem prod : product){
            if(prod.getName().contains(elemento)){
                clickElement(btn_AddToCart);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gallery")));
            }
        }
        return new ProductDetail(driver);
    }

    public void addToWishList(String prodItem){
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getName().contains(prodItem)){
                product.get(i).addToWish();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
                wait.until(ExpectedConditions.invisibilityOf(notificationBar));
                break;
            }
        }
    }

    public void addToCompareList(String prodItem){
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getName().contains(prodItem)){
                product.get(i).addToCompare();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
//                if(i != product.size()-1) {
                    wait.until(ExpectedConditions.invisibilityOf(notificationBar));
//                }
                break;
            }
        }
    }
}
