package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestWhitLogin extends BaseTest{

    @BeforeMethod
    @Parameters({"user","pass"})
    public void testLogin(String user, String pass){
        login = homePage.clickToLogin();
        login.loginUser(user, pass);
    }
}
