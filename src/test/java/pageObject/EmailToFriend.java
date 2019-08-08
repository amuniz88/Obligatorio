package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailToFriend extends BasePage{

    @FindBy(id = "FriendEmail")
    WebElement input_FriendEmail;

    @FindBy(id = "PersonalMessage")
    WebElement input_Message;

    @FindBy(name = "send-email")
    WebElement btn_SendEmail;

    @FindBy(tagName = "h1")
    WebElement subTitle;

    @FindBy(xpath = "//div[@class='result']")
    WebElement lbl_mensajeOK;

    @FindBy(className = "field-validation-error")
    WebElement lbl_mensajeError;

    public EmailToFriend(WebDriver driver) {
        super(driver);
    }

    public void sendEmailToFriend(String email, String message){
        setText(input_FriendEmail, email);
        setText(input_Message, message);

        clickElement(btn_SendEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isDisplayed();
    }

    public boolean subTitleContains(String contenido){
        return subTitle.getText().contains(contenido);
    }

    public boolean messageReturnIsDisplayed(boolean correcto){
        if(correcto == true){
            if (lbl_mensajeOK.isDisplayed())
                return true;
        }else{
            if(lbl_mensajeError.isDisplayed())
                return true;
        }
        return false;
    }

    public boolean messageReturnContains(String contenido, boolean correcto){

        if(correcto){
            if(lbl_mensajeOK.getText().contains(contenido))
                return true;
        }else{
            if(lbl_mensajeError.getText().contains(contenido))
                return true;
        }
        return false;
    }
}
