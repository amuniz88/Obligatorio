package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCart extends BasePage{

    @FindBy(id = "CountryId")
    WebElement c_Country;

    @FindBy(name = "checkout_attribute_1")
    WebElement c_Gift;

    @FindBy(id = "ZipPostalCode")
    WebElement postalCode;

    @FindBy(id = "termsofservice")
    WebElement chk_terminos;

    @FindBy(id = "checkout")
    WebElement btn_Checkout;

    public ShoppingCart(WebDriver driver){
        super(driver);
    }

    public Checkout checkoutProd(String gift, String country, String postal, boolean term){

        if(gift.equalsIgnoreCase("2")){
            order.setGift(true);
        }else{
            order.setGift(false);
        }

        selectByValue(c_Gift, gift);
        selectByValue(c_Country, country);
        setText(postalCode, postal);

        if(term) {
            clickElement(chk_terminos);
        }

        clickElement(btn_Checkout);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return new Checkout(driver);
    }
}
