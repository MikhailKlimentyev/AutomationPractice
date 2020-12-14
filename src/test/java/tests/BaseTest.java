package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthenticationPage;
import pages.HomePage;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    LoginSteps loginSteps;
    public AuthenticationPage authenticationPage;



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

        loginSteps = new LoginSteps(driver);

        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
