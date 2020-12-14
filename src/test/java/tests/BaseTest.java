package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import steps.CreateAccountSteps;
import steps.LoginSteps;
import utils.TestData;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    LoginSteps loginSteps;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    CreateAccountSteps createAccountSteps;
    TestData testData;



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
        authenticationPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);

        loginSteps = new LoginSteps(driver);
        createAccountSteps = new CreateAccountSteps(driver);

        testData = new TestData(driver);


        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
