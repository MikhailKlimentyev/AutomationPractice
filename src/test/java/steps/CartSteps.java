package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;

public class CartSteps {

    private static final Logger logger = LoggerFactory.getLogger(CartSteps.class);

    BaseSteps baseSteps;

    public CartSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @Given("Open home page")
    public void openHomePage() {
        baseSteps.homePage.openPage();
    }

    @Then("Number of products in cart is {string}")
    public void numberOfProductsInCartIs(String expectedCartQuantity) {
        String cartQuantity = baseSteps.cartPage.getCartQuantity();
        logger.debug("cart quantity {}", cartQuantity);
        assertEquals(cartQuantity, expectedCartQuantity);
    }

    @And("Remove product from cart")
    public void removeProductFromCart() {
        baseSteps.cartPage.clickRemoveProductFromCartButton();
    }

    @Then("The following message {string} presents on cart page")
    public void theFollowingMessagePresentsOnCartPage(String expectedMessage) {
        String notificationMessage = baseSteps.cartPage.getNotificationMessage();
        assertEquals(notificationMessage, expectedMessage);
    }
}
