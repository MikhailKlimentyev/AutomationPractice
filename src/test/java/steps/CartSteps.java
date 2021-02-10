package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CartSteps {

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
