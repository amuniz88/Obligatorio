package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends BaseTestWhitLogin {

    @Test(dataProvider = "DP_ContactUs", dataProviderClass = DPGeneral.class)
    public void contactUs(String mensaje, String msgRetorno, boolean correcto){
        contact = homePage.goToContact();

        contact.contactUs(mensaje);

        Assert.assertTrue(contact.subTitleIsDisplayed());
        Assert.assertTrue(contact.subTitleContains("Contact Us"));
        //Assert doble dependiendo el test a realizar
        Assert.assertTrue(contact.msgResultIsDisplayed(correcto));
        Assert.assertTrue(contact.msgResultContains(msgRetorno, correcto));

        homePage.clickToLogout();
    }
}
