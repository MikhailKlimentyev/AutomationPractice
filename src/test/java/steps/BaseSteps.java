package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseSteps {

    WebDriver driver;
    AuthenticationPage authenticationPage;
    AccountPage accountPage;
    CreateAccountPage createAccountPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    OrderPage orderPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        orderPage = new OrderPage(driver);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("Open login page")
    public void openLoginPage() {
        authenticationPage.openPage();
    }

    @Then("User with {string} first name and {string} last name is logged in")
    public void userWithFirstNameAndLastNameIsLoggedIn(String firstName, String lastName) {
        assertEquals(accountPage.getHeadingUserName(), firstName + " " + lastName);
    }

    @When("Click on product with name {string}")
    public void clickOnProductWithName(String productName) {
        homePage.openProductByName(productName);
    }

    @And("Set product quantity {string}")
    public void setProductQuantity(String quantity) {
        productPage.setProductQuantity(Integer.parseInt(quantity));
    }

    @And("Click on Add To Cart button")
    public void clickOnAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @And("Click on Proceed To Checkout button")
    public void clickOnProceedToCheckoutButton() {
        productPage.clickProceedToCheckoutButton();
    }

    @DataTableType
    public User getUser(Map<String, String> entry) {
        User user = new User();
        user.setFirstName(entry.get("firstName"));
        user.setLastName(entry.get("lastName"));
        user.setEmail(entry.get("email"));
        user.setPassword(entry.get("password"));
        user.setAddress(entry.get("address"));
        user.setCity(entry.get("city"));
        user.setState(entry.get("state"));
        user.setPostalCode(entry.get("postalCode"));
        user.setCountry(entry.get("country"));
        user.setPhone(entry.get("phone"));
        return user;
    }

    String generateUniqueEmail() {
        String number = String.valueOf(System.nanoTime()).substring(0, 5);
        return String.format("TestEmail2%s@malinator.com", number);
    }
}
