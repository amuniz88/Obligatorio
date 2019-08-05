package pageObject;

import org.openqa.selenium.*;
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

    Alert alert;

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
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

    @FindBy(id = "BillingNewAddress_City")
    WebElement input_city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement input_address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement input_PostalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement input_Phone;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement input_Country;

    public Checkout(WebDriver driver){
        super(driver);
    }

    //Paso 1
    public void billingAddress(boolean samAddress, String country, String city, String address, String postalCode, String phone) {

        if(samAddress == false){
            clickElement(check_SamAddress);
        }

        System.out.println(input_city.isDisplayed());
        if(input_city.isDisplayed() == true){
            selectByValue(input_Country, country);
            setText(input_city, city);
            setText(input_address, address);
            setText(input_PostalCode, postalCode);
            setText(input_Phone, phone);
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
        scrollIntoView(btn_ContinuarFinal);

        wait.until(ExpectedConditions.elementToBeClickable(btn_ContinuarFinal));

        clickElement(btn_ContinuarFinal);

        while (isAlertPresent() == true){
            alert.accept();
            clickElement(btn_ContinuarFinal);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-number")));
    }

    public MyOrder confirmOrder(){
        order.setNumOrder(Integer.valueOf(findElement(By.className("order-number")).getText().replace("ORDER NUMBER: ", "")));

        clickElement(linkOrderDetails);
        return new MyOrder(driver);
    }

    public boolean isAlertPresent(){
        try {
            alert = waitAlert.until(ExpectedConditions.alertIsPresent());
            return true;
        }catch (TimeoutException te){
            return false;
        }
    }
}
