package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import utils.GetProperties;

public class BaseTest {

    protected SoftAssert SA;
    protected ChromeOptions options;
    protected WebDriver driver;
    protected HomePage homePage;
    protected MyOrder order;
    protected PORegistrarUsuario registroU;
    protected SearchResult searchR;
    protected Search search;
    protected ShoppingCart shopCart;
    protected Checkout check;
    protected FinalCheckout finCheck;
    protected LogIn login;
    protected ProductDetail prodDet;
    protected WishList wishList;
    protected CompareList compareList;
    protected MyAccount myAccount;
    protected ChangePassword changePass;
    protected AddAddresses addAddress;
    protected Address address;
    protected EmailToFriend emailToFriend;
    protected Contact contact;

    protected GetProperties properties = new GetProperties();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void start(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", properties.getString("CHROMEDRIVER_PATH_32_WIN"));

            options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", properties.getString("FIREFOXDRIVER_PATH_64_WIN"));

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(properties.getString("URL"));

        SA = new SoftAssert();

        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
