package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestRegistroUsuario extends BaseTest{

    @Test(dataProvider = "DP_Usuario", dataProviderClass = DPGeneral.class)
    public void registraUsuario(String email, String sexo, String name, String apellido, String day, String month, String year, String company,
                                String pass, String conPass, boolean check, Method method) throws InterruptedException {
        extentTest = extentReports.createTest(method.getName());

        registroU = homePage.clickToRegister();
        registroU.completarDatosUsuario(email, sexo, name, apellido, day, month, year, company, pass, conPass, check);

        Assert.assertTrue(registroU.messageIsDisplayed());
        Assert.assertTrue(registroU.messageContains("Your registration completed"));  //porque el usuario ya esta registrado
        Assert.assertTrue(registroU.subTitleIsDisplayed());
        Assert.assertTrue(registroU.subTitleContains("Register"));
        Assert.assertTrue(registroU.continueIsDisplayed());

        homePage.clickToLogout();
    }
}
