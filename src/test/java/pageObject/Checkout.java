package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkout extends BasePage{

    @FindBy(id = "ShipToSameAddress")
    WebElement check_SamAddress;

    @FindBy(xpath = "//input[contains(@onclick,'Billing.save()')]")
    WebElement btn_Continuar1;

    @FindBy(xpath = "//input[contains(@onclick,'Shipping.save()')]")
    WebElement btn_Continuar2;

    @FindBy(className = "shipping-method-next-step-button")
    WebElement btn_Continuar3;

    @FindBy(id = "shippingoption_0")
    WebElement radioShopp0;

    @FindBy(id = "shippingoption_1")
    WebElement radioShopp1;

    @FindBy(id = "shippingoption_2")
    WebElement radioShopp2;

    @FindBy(id = "paymentmethod_0")
    WebElement radioPayment0;

    @FindBy(id = "paymentmethod_1")
    WebElement radioPayment1;

    @FindBy(className = "payment-method-next-step-button")
    WebElement btn_Continuar4;

    @FindBy(className = "payment-info-next-step-button")
    WebElement btn_Continuar5;

    @FindBy(className = "confirm-order-next-step-button")
    WebElement btn_ContinuarFinal;

    @FindBy(how = How.ID, using = "CreditCardType")
    WebElement c_CredCardType;

    @FindBy(id = "CardholderName")
    WebElement txt_CardHolderName;

    @FindBy(id = "CardNumber")
    WebElement txt_CardNumber;

    @FindBy(id = "ExpireMonth")
    WebElement c_ExpireMonth;

    @FindBy(id = "ExpireYear")
    WebElement c_ExpireYear;

    @FindBy(id = "CardCode")
    WebElement txt_CardCode;

    @FindBy(partialLinkText = "Click here for order details.")
    WebElement linkOrderDetails;

//    MyOrder order;

    public Checkout(WebDriver driver){
        super(driver);
//        order = new MyOrder(driver);
    }

    //Paso 1
    public void billingAddress(boolean samAddress) {

        if(samAddress == false){
            clickElement(check_SamAddress);
        }

        clickElement(btn_Continuar1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping-address-select")));
    }

    //Paso 2
    public void shippingAddress(){
        clickElement(btn_Continuar2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-step-shipping-method")));
    }

    //Paso 3
    public void shippingMethod(String radioShopp){
        switch (radioShopp){
            case "1":
                clickElement(radioShopp1);
                break;
            case "2":
                clickElement(radioShopp2);
                break;
            case "3":
                clickElement(radioShopp0);
                break;
        }

        clickElement(btn_Continuar3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-method-block")));
    }

    //Paso 4 y 5
    public void paymentMethod(String radioPayment, String creditType, String cardNom, String cardNum, String expMonth, String expYear, String cardCode){
        if(radioPayment.equals("1")){
            clickElement(radioPayment1);

            clickElement(btn_Continuar4);

            //Parte 5 (Credit Card)
            selectByValue(c_CredCardType, creditType);
            setText(txt_CardHolderName, cardNom);
            setText(txt_CardNumber, cardNum);
            selectByValue(c_ExpireMonth, expMonth);
            selectByValue(c_ExpireYear, expYear);
            setText(txt_CardCode, cardCode);

            clickElement(btn_Continuar5);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-review-data")));
        }else{
            clickElement(radioPayment0);

            clickElement(btn_Continuar4);

            //Parte 5 (Check / Money Order)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info")));

            clickElement(btn_Continuar5);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-review-data")));
        }
        clickElement(btn_ContinuarFinal);
    }

    public MyOrder confirmOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-number")));

        order.setNumOrder(Integer.valueOf(findElement(By.className("order-number")).getText().replace("ORDER NUMBER: ", "")));

        clickElement(linkOrderDetails);

        return new MyOrder(driver);
    }
}
