package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.CreateAccountSteps;
import steps.LoginSteps;
import steps.OrderSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    CreateAccountSteps createAccountSteps;
    LoginSteps loginSteps;
    OrderSteps orderSteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String variable = "driver";
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
