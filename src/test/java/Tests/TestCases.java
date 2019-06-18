package Tests;

import PageObject.HomePage;
import PageObject.PORegistrarUsuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {

    private WebDriver driver;
    private HomePage homePage;
    private PORegistrarUsuario registroU;

    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void registrarUsuario(){
        registroU = homePage.registroDeUsuario();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
