package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Address extends BasePage {

    @FindBy(id = "Address_FirstName")
    WebElement input_name;

    @FindBy(id = "Address_LastName")
    WebElement input_ape;

    @FindBy(id = "Address_Email")
    WebElement input_email;

    @FindBy(id = "Address_CountryId")
    WebElement combo_country;

    @FindBy(id = "Address_City")
    WebElement input_city;

    @FindBy(id = "Address_Address1")
    WebElement input_address;

    @FindBy(id = "Address_ZipPostalCode")
    WebElement input_postalcode;

    @FindBy(id = "Address_PhoneNumber")
    WebElement input_phonenumber;

    @FindBy(className = "save-address-button")
    WebElement btn_saveaddress;

    public Address(WebDriver driver) {
        super(driver);
    }

    public AddAddresses addNewAddress(String name, String ape, String email, String country, String city, String address, String postCode, String phone){
        setText(input_name, name);
        setText(input_ape, ape);
        setText(input_email, email);
        selectByValue(combo_country, country);
        setText(input_city, city);
        setText(input_address, address);
        setText(input_postalcode, postCode);
        setText(input_phonenumber, phone);

        clickElement(btn_saveaddress);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        return new AddAddresses(driver);
    }
}
