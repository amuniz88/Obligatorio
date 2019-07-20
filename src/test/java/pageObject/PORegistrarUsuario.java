package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PORegistrarUsuario extends BasePage{

    @FindBy(id = "gender-male")
    WebElement radio_Male;

    @FindBy(id = "gender-female")
    WebElement radio_Female;

    @FindBy(id = "FirstName")
    WebElement txt_FirstName;

    @FindBy(id = "LastName")
    WebElement txt_lastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement combo_DateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement combo_DateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement combo_DateOfBirthYear;

    @FindBy(id = "Email")
    WebElement txt_Email;

    @FindBy(id = "Company")
    WebElement txt_Company;

    @FindBy(id = "Newsletter")
    WebElement chk_Newsletter;

    @FindBy(id = "Password")
    WebElement txt_Password;

    @FindBy(id = "ConfirmPassword")
    WebElement txt_ConfirmPassword;

    @FindBy(id = "register-button")
    WebElement btn_Register;

    @FindBy(css = "[class = \"result\"]")
    WebElement mensajeRegister;

    @FindBy(className = "page-body")
    WebElement mensaje;

    @FindBy(className = "page-title")
    WebElement subTitle;

    @FindBy(className = "register-continue-button")
    WebElement btn_Continue;

    public PORegistrarUsuario(WebDriver driver){
        super(driver);
    }

    public void completarDatosUsuario(String email, String sexo, String name, String apellido, String day, String month, String year, String company, String pass, String conPass, boolean check){

        if(sexo.equals("M")){
            clickElement(radio_Male);
        }else{
            clickElement(radio_Female);
        }

        setText(txt_FirstName, name);
        setText(txt_lastName, apellido);

        selectByValue(combo_DateOfBirthDay, day);
        selectByValue(combo_DateOfBirthMonth, month);
        selectByValue(combo_DateOfBirthYear, year);

        setText(txt_Email, email);
        setText(txt_Company, company);

        if(check == true) {
            clickElement(chk_Newsletter);
        }

        setText(txt_Password, pass);
        setText(txt_ConfirmPassword, conPass);
        clickElement(btn_Register);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
    }

    public boolean messageIsDisplayed(){
        return mensaje.isDisplayed();
    }

    public boolean messageContains(String value){
        return mensaje.getText().contains(value);
    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isDisplayed();
    }

    public boolean subTitleContains(String value){
        return subTitle.getText().contains(value);
    }

    public boolean continueIsDisplayed(){
        return btn_Continue.isDisplayed();
    }
}
