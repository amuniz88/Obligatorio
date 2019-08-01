package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePassword extends BasePage {

    @FindBy(id = "OldPassword")
    WebElement input_OldPass;

    @FindBy(id = "NewPassword")
    WebElement input_NewPass;

    @FindBy(id = "ConfirmNewPassword")
    WebElement input_ConfirmNewPass;

    @FindBy(className = "change-password-button")
    WebElement btn_Change;

    @FindBy(xpath = "//div[@class='result']")
    WebElement lbl_MessageOK;

    @FindBy(className = "validation-summary-errors")
    WebElement lbl_ErrorMessage;

    @FindBy(tagName = "h1")
    WebElement subTitle;

    public ChangePassword(WebDriver driver) {
        super(driver);
    }

    public void changeUserPassword(String oldPass, String newPass, String confirmPass, boolean correct){
        setText(input_OldPass, oldPass);
        setText(input_NewPass, newPass);
        setText(input_ConfirmNewPass, confirmPass);

        clickElement(btn_Change);

        if(correct == true) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
        }else{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("validation-summary-errors")));
        }

    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isDisplayed();
    }

    public boolean subTitleContains(String contenido){
        return subTitle.getText().contains(contenido);
    }

    public boolean changeMessage(String mensaje, boolean correct){
        if(correct == true) {
            if (lbl_MessageOK.getText().contains(mensaje)) {
                return true;
            }
        }else{
            if(lbl_ErrorMessage.getText().contains(mensaje)){
                return true;
            }
        }
        return false;
    }
}
