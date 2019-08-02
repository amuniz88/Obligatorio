package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Contact extends BasePage {

    @FindBy(id = "FullName")
    WebElement input_Name;

    @FindBy(id = "Email")
    WebElement input_Email;

    @FindBy(id = "Enquiry")
    WebElement input_Enquiry;

    @FindBy(className = "contact-us-button")
    WebElement btn_Submit;

    @FindBy(tagName = "h1")
    WebElement subTitle;

    @FindBy(id = "Enquiry-error")
    WebElement lbl_msgError;

    @FindBy(xpath = "//div[@class='result']")
    WebElement lbl_msgOK;

    public Contact(WebDriver driver) {
        super(driver);
    }

    public void contactUs(String mensaje) {
        setText(input_Enquiry, mensaje);
        clickElement(btn_Submit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isDisplayed();
    }

    public boolean subTitleContains(String contenido){
        return subTitle.getText().contains(contenido);
    }

    public boolean msgResultIsDisplayed(boolean correcto){
        if(correcto == true){
            if(lbl_msgOK.isDisplayed()){
                return true;
            }
        }else{
            if(lbl_msgError.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public boolean msgResultContains(String contenido, boolean correcto){
        if(correcto == true){
            if(lbl_msgOK.getText().contains(contenido)){
                return true;
            }
        }else{
            if(lbl_msgError.getText().contains(contenido)){
                return true;
            }
        }
        return false;
    }
}
