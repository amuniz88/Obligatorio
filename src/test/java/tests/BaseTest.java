package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import utils.GetProperties;

import java.net.MalformedURLException;

public class BaseTest {

    protected static SoftAssert SA;
    protected ChromeOptions options;
    protected static WebDriver driver;
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

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void setupSuite(final String browser) throws MalformedURLException {
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

//        driver.get(properties.getString("URL"));

        SA = new SoftAssert();

//        homePage = new HomePage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navegarInicio() {
        driver.get(properties.getString("URL"));
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
//    public void teardownTest(final ITestResult result) throws IOException {
    public void teardownTest(){
        SA.assertAll();
//        if (result.getStatus() == ITestResult.FAILURE) {
//            extentTest.log(Status.FAIL, "Test Case " + result.getName() + " failed");
//            extentTest.log(Status.FAIL, "Caused: " + result.getThrowable());
//            String screenShoot = SeleniumUtils.takeScreenShot(driver);
//            extentTest.log(Status.FAIL, "Image: ");
//            extentTest.addScreenCaptureFromPath(screenShoot);
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            extentTest.log(Status.SKIP, "Test Case " + result.getName() + " skipped");
//            extentTest.log(Status.SKIP, "Caused: " + result.getThrowable());
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            extentTest.log(Status.PASS, "Test Case " + result.getName() + " passed");
//        }
    }

    @AfterSuite(alwaysRun = true)
    public void flush(){
        driver.quit();
    }
}
