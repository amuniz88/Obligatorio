package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestContactUs extends BaseTestWhitLogin {

    @Test(dataProvider = "DP_ContactUs", dataProviderClass = DPGeneral.class)
    public void contactUs(String mensaje, String msgRetorno, boolean correcto, Method method) throws InterruptedException {
        extentTest = extentReports.createTest(method.getName());

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
