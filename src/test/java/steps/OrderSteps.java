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
    CartPage cartPage;

    public OrderSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        productPage = new ProductPage(driver);
        orderPage = new OrderPage(driver);
        cartPage = new CartPage(driver);
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

    @Step("Confirm summary")
    public OrderSteps confirmSummary() {
        cartPage.clickProceedToCheckoutSummaryButton();
        return this;
    }

    @Step("Confirm Address")
    public OrderSteps confirmAddress() {
        orderPage.clickProceedToCheckoutAddressButton();
        return this;
    }

    @Step("Agree to the terms of service and will adhere to them unconditionally.")
    public OrderSteps agreeToTheTermsOfService() {
        orderPage.setCgvCheckbox();
        orderPage.clickProceedToCheckoutShippingButton();
        return this;
    }

    @Step("Select payment by Bank Wire")
    public OrderSteps payByBankWire() {
        orderPage.clickPayByBankWireButton();
        return this;
    }

    @Step("Select payment by Check")
    public OrderSteps payByCheck() {
        orderPage.clickPayByCheckButton();
        return this;
    }

    @Step("Confirm Order")
    public OrderSteps confirmOrder() {
        orderPage.clickConfirmOrderButton();
        return this;
    }

    @Step("Check order successful")
    public void checkOrderSuccessfulPaymentByCheck() {
        assertEquals(orderPage.getOrderSuccessfulTextPaymentByCheck(), "Your order on My Store is complete.");
    }

    @Step("Check order successful")
    public void checkOrderSuccessfulPaymentByBankWire() {
        assertEquals(orderPage.getOrderSuccessfulTextPaymentByBankWire(), "Your order on My Store is complete.");
    }
}