package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import sun.awt.OSInfo;
import utils.GetProperties;
import utils.SeleniumUtils;

import java.io.IOException;
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

    //reportes
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

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

        SA = new SoftAssert();
        setupReports();
    }

    public void setupReports(){
        extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
        extentHtmlReporter.config().setDocumentTitle("Automation Reports");
        extentHtmlReporter.config().setReportName("Opencart - Reporte de Pruebas Automatizadas");
        extentHtmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Ambiente", "Testing");
        extentReports.setSystemInfo("Hostname", "opencart.testing.us");
        extentReports.setSystemInfo("Sistema Operativo", OSInfo.getOSType().name());
    }

    @BeforeMethod(alwaysRun = true)
    public void navegarInicio() {
        driver.get(properties.getString("URL"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardownTest(final ITestResult result) throws IOException {
        SA.assertAll();
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test Case " + result.getName() + " failed");
            extentTest.log(Status.FAIL, "Caused: " + result.getThrowable());
            String screenShoot = SeleniumUtils.takeScreenShot(driver);
            extentTest.log(Status.FAIL, "Image: ");
            extentTest.addScreenCaptureFromPath(screenShoot);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case " + result.getName() + " skipped");
            extentTest.log(Status.SKIP, "Caused: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test Case " + result.getName() + " passed");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void flush(){
        extentReports.flush();
        driver.quit();
    }
}
