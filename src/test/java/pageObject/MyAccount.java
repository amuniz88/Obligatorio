package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

    protected ChangePassword changePassword;
    protected AddAddresses addAddresses;

    @FindBy(name = "DateOfBirthDay")
    WebElement combo_day;

    @FindBy(name = "DateOfBirthMonth")
    WebElement combo_month;

    @FindBy(name = "DateOfBirthYear")
    WebElement combo_year;

    @FindBy(id = "save-info-button")
    WebElement btn_Save;

    @FindBy(tagName = "h1")
    WebElement subTitle;

    public MyAccount(WebDriver driver) {
        super(driver);
        changePassword = new ChangePassword(driver);
        addAddresses = new AddAddresses(driver);
    }

    public ChangePassword clickInChangePassword() {
        return changePassword.goToClickInChangePass();
    }

    public AddAddresses clickInAddAddresses() {
        return addAddresses.goToClickInAddresses();
    }

    public void changeUserInfo(String day, String month, String year){
        selectByValue(combo_day, day);
        selectByValue(combo_month, month);
        selectByValue(combo_year, year);

        scrollIntoView(btn_Save);
        clickElement(btn_Save);
    }

    public boolean subTitleIsDisplayed(){
        return subTitle.isEnabled();
    }

    public boolean subTitleContains(String contenido){
        return subTitle.getText().contains(contenido);
    }

    public boolean dateOfBirthDay(String day){
        return combo_day.getAttribute("value").contains(day);
    }

    public boolean dateOfBirthMonth(String month){
        return combo_month.getAttribute("value").contains(month);
    }

    public boolean dateOfBirthYear(String year){
        return combo_year.getAttribute("value").contains(year);
    }
}
