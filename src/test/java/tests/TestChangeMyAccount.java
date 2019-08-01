package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChangeMyAccount extends BaseTestWhitLogin{

    @Test(dataProvider = "DP_MyAccount", dataProviderClass = DPGeneral.class)
    public void changePassword(String oldPass, String newPass, String confirmPass, String mensaje, boolean correct){
        myAccount = homePage.goToMyAccount();
        changePass = myAccount.clickInChangePassword();

        changePass.changeUserPassword(oldPass, newPass, confirmPass, correct);

        //3 Assert en uno dependiendo de los valores que vengan desde el DataProvider
        Assert.assertTrue(changePass.changeMessage(mensaje, correct));

        Assert.assertTrue(changePass.subTitleIsDisplayed());
        Assert.assertTrue(changePass.subTitleContains("My account - Change password"));

        homePage.clickToLogout();
    }

    @Test(dataProvider = "DP_MyAccount", dataProviderClass = DPGeneral.class)
    public void modifyUserInfo(String day, String month, String year){
        myAccount = homePage.goToMyAccount();

        myAccount.changeUserInfo(day, month, year);

        Assert.assertTrue(myAccount.subTitleIsDisplayed());
        Assert.assertTrue(myAccount.subTitleContains("My account - Customer info"));
        Assert.assertTrue(myAccount.dateOfBirthDay(day));
        Assert.assertTrue(myAccount.dateOfBirthMonth(month));
        Assert.assertTrue(myAccount.dateOfBirthYear(year));

        homePage.clickToLogout();
    }
}
