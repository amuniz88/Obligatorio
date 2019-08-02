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

        /*
        3 Assert en uno dependiendo de los valores que vengan desde el DataProvider.
         - Test con error, se manda un caso con OldPass que no es el correcto
         - Test con error, se intenta cambiar la contraseña ingresando la misma en los tres campos
         - Test correcto, se cambia la contraseña correctamente

         */
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

    @Test(dataProvider = "DP_MyAccount", dataProviderClass = DPGeneral.class)
    public void addUserAddress(String name, String ape, String email, String country, String city, String dir, String postalCode, String phone){
        myAccount = homePage.goToMyAccount();
        addAddress = myAccount.clickInAddAddresses();

        address = addAddress.clickInAddNew();
        addAddress = address.addNewAddress(name, ape, email, country, city, dir, postalCode, phone);

        Assert.assertTrue(addAddress.subTitleIsDisplayed());
        Assert.assertTrue(addAddress.subTitleContains("My account - Addresses"));
        Assert.assertTrue(addAddress.newAddress(dir));
        Assert.assertTrue(addAddress.newCityStateZip(city));
        Assert.assertTrue(addAddress.newCityStateZip(postalCode));
    }
}
