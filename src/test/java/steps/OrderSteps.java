package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class OrderSteps {

    BaseSteps baseSteps;

    public OrderSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @When("Click on Sign In button on home page")
    public void clickOnSignInButtonOnHomePage() {
        baseSteps.homePage.clickSignInButton();
    }

    @And("Click on logo")
    public void clickOnLogo() {
        baseSteps.accountPage.clickOnLogo();
    }

    @And("Set product size {string}")
    public void setProductSize(String size) {
        baseSteps.productPage.setProductSize(size);
    }

    @Then("Delivery address info equals info of user")
    public void deliveryAddressInfoEqualsToUser(List<User> users) {
        User user = users.get(0);
        assertEquals(baseSteps.orderPage.getAddressName(), user.getFirstName() + " " + user.getLastName());
        assertEquals(baseSteps.orderPage.getAddress(), user.getAddress());
        assertEquals(baseSteps.orderPage.getAddressCity(), user.getCity() + ", " + user.getState() +
            " " + user.getPostalCode());
        assertEquals(baseSteps.orderPage.getAddressPhone(), user.getPhone());
    }

    @And("Click on Proceed To Checkout Summary button")
    public void clickOnProceedToCheckoutSummaryButton() {
        baseSteps.cartPage.clickProceedToCheckoutSummaryButton();
    }

    @And("Click on Proceed To Checkout Address button")
    public void clickOnProceedToCheckoutAddressButton() {
        baseSteps.orderPage.clickProceedToCheckoutAddressButton();
    }

    @And("Set Cgv checkbox")
    public void setCgvCheckbox() {
        baseSteps.orderPage.setCgvCheckbox();
    }

    @And("Click on Proceed To Checkout Shipping button")
    public void clickOnProceedToCheckoutShippingButton() {
        baseSteps.orderPage.clickProceedToCheckoutShippingButton();
    }

    @And("Click on Pay by bank wire button")
    public void clickOnPayByBankWireButton() {
        baseSteps.orderPage.clickPayByBankWireButton();
    }

    @And("Click on Confirm Order button")
    public void clickOnConfirmOrderButton() {
        baseSteps.orderPage.clickConfirmOrderButton();
    }

    @Then("On Order confirmation page {string} message appears for pay by bank wire")
    public void onOrderConfirmationPageMessageAppears(String expectedMessage) {
        String message = baseSteps.orderPage.getOrderSuccessfulTextPaymentByBankWire();
        assertEquals(message, expectedMessage);
    }

    @And("Click on Pay By Check button")
    public void clickOnPayByCheckButton() {
        baseSteps.orderPage.clickPayByCheckButton();
    }

    @Then("On Order confirmation page {string} message appears for pay by check")
    public void onOrderConfirmationPageMessageAppearsForPayByCheck(String expectedMessage) {
        String actualMessage = baseSteps.orderPage.getOrderSuccessfulTextPaymentByCheck();
        assertEquals(actualMessage, expectedMessage);
    }
}
