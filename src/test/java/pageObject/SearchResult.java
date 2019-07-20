package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult extends BasePage{

    @FindBy(css = "[data-productid=\"25\"]")
    WebElement productID;

    @FindBy(id = "product_attribute_9")
    WebElement combo_Size;

    @FindBy(id = "add-to-cart-button-25")
    WebElement btn_Add;

    @FindBy(css = "[title=\"Red\"]")
    WebElement colorRed;

    @FindBy(css = "[title=\"Blue\"]")
    WebElement colorBlue;

    @FindBy(css = "[title=\"Silver\"]")
    WebElement colorSilver;

    @FindBy(css = ".content [href=\"/cart\"]")
    WebElement lnk_ShopCart;

    @FindBy(className = "product-price")
    WebElement precio;

    @FindBy(className = "qty-input")
//    @FindBy(className = "qty-label")
//    @FindBy(className = "add-to-cart-panel")
    WebElement cantidad;

    public SearchResult(WebDriver driver){
        super(driver);
    }

    public ShoppingCart addToCart(String size, String color, String cant){
        clickElement(productID);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stock-availability-value-25")));

        selectByValue(combo_Size, size);

        switch (color){
            case "azul":
                clickElement(colorBlue);
                break;
            case "rojo":
                clickElement(colorRed);
                break;
            case "plata":
                clickElement(colorSilver);
                break;
        }
        setText(cantidad, cant);

        order.setCantidad(Integer.valueOf(cant));
        order.setPrecio(Double.valueOf(precio.getText().replace("$", "")));

        clickElement(btn_Add);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));

        clickElement(lnk_ShopCart);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new ShoppingCart(driver);
    }
}
