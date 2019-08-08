package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetail extends BasePage{

    @FindBy(xpath = "//select[contains(@id,'product_attribute')]")
    WebElement combo_Size;

    @FindBy(css = "[title='Red']")
    WebElement colorRed;

    @FindBy(css = "[title='Blue']")
    WebElement colorBlue;

    @FindBy(css = "[title='Silver']")
    WebElement colorSilver;

    @FindBy(className = "qty-input")
    WebElement cantidad;

    @FindBy(className = "product-price")
    WebElement precio;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    WebElement btn_Add;

    @FindBy(css = "a.ico-cart")
    WebElement lnk_ShopCart;

    public ProductDetail(WebDriver driver) {
        super(driver);
    }

    public ShoppingCart addToCart(String size, String color, String cant){
        if(!size.equals("")) {
            selectByValue(combo_Size, size);
        }
        if(!color.equals("")) {
            switch (color) {
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
        }

        if(!cant.equals("")) {
            setText(cantidad, cant);
            order.setCantidad(Integer.valueOf(cant));
        }

//        order.setPrecio(Double.valueOf(precio.getText().substring("$", "")));
        order.setPrecio(Double.valueOf(precio.getText().replace("$", "")));

        clickElement(btn_Add);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));

        clickElement(lnk_ShopCart);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new ShoppingCart(driver);
    }
}
