package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.testng.Assert.assertEquals;

public class OrderSteps {
    HomePage homePage;
    AccountPage accountPage;
    ProductPage productPage;
    OrderPage orderPage;

    public OrderSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        productPage = new ProductPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Step("Open Home page and login")
    public OrderSteps login(String email, String password, User user) {
        homePage
                .openPage()
                .clickSignInButton()
                .filInTheEmailField(AuthenticationPage.EMAIL)
                .filInThePasswordField(AuthenticationPage.PASSWORD)
                .clickLoginButton();
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
        return this;
    }

    @Step("Add product to Cart with name: {productName} with quantity: {productQuantity}")
    public OrderSteps addProductToCart(String productName, int productQuantity, String productSize) {
        accountPage.clickOnLogo();
        homePage.openProductByName(productName);
        productPage
                .setProductQuantity(productQuantity)
                .setProductSize(productSize)
                .clickAddToCartButton();
        return this;
    }

    @Step("Go to checkout")
    public OrderSteps goToCheckout() {
        productPage.clickProceedToCheckoutButton();
        return this;
    }

    @Step("Check delivery address")
    public OrderSteps checkDeliveryAddressInfo(User user) {
        assertEquals(orderPage.getAddressName(), user.getFirstName() + " " + user.getLastName());
        assertEquals(orderPage.getAddress(), user.getAddress());
        assertEquals(orderPage.getAddressCity(), user.getCity() + ", " + user.getState() + " " + user.getPostalCode());
        assertEquals(orderPage.getAddressPhone(), user.getPhone());
        return this;
    }

    @Step("Submit summary")
    public OrderSteps submitSummary() {
        orderPage.clickProceedToCheckoutSummaryButton();
        return this;
    }
}