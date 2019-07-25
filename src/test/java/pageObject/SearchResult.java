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

//        selectByValue(combo_Size, size);
//
//        switch (color){
//            case "azul":
//                clickElement(colorBlue);
//                break;
//            case "rojo":
//                clickElement(colorRed);
//                break;
//            case "plata":
//                clickElement(colorSilver);
//                break;
//        }
//
//        setText(cantidad, cant);
//
//        order.setCantidad(Integer.valueOf(cant));
//        order.setPrecio(Double.valueOf(precio.getText().replace("$", "")));
//
//        clickElement(btn_Add);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
//
//        clickElement(lnk_ShopCart);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
//
//        return new ShoppingCart(driver);
        return new ProductDetail(driver);
    }
}
