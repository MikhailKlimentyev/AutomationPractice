package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.CreateAccountSteps;
import steps.LoginSteps;
import steps.OrderSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    OrderPage orderPage;
    CreateAccountSteps createAccountSteps;
    LoginSteps loginSteps;
    OrderSteps orderSteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String variable = "driver";
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        orderPage = new OrderPage(driver);
        loginSteps = new LoginSteps(driver);
        orderSteps = new OrderSteps(driver);
        createAccountSteps = new CreateAccountSteps(driver);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
