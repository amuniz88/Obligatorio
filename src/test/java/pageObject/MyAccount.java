package pageObject;

import org.openqa.selenium.WebDriver;

public class MyAccount extends BasePO {

    protected ChangePassword changePassword;

    public MyAccount(WebDriver driver) {
        super(driver);
        changePassword = new ChangePassword(driver);
    }

    public ChangePassword clickInChangePassword() {
        return changePassword.goToClickInChangePass();
    }
}
