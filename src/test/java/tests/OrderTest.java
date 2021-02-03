package tests;

import org.testng.annotations.Test;
import utils.TestData;

import static pages.AuthenticationPage.EMAIL;
import static pages.AuthenticationPage.PASSWORD;

public class OrderTest extends BaseTest {

    @Test(description = "Complete order processing from login to payment verification and choose payment by bank wire")
    public void orderingAndPaymentByBankWire() {
        orderSteps
            .login(EMAIL, PASSWORD, TestData.newUser())
            .addProductToCart("Printed Dress", 3, "M")
            .goToCheckout()
            .checkDeliveryAddressInfo(TestData.newUser())
            .confirmSummary()
            .confirmAddress()
            .agreeToTheTermsOfService()
            .payByBankWire()
            .confirmOrder()
            .checkOrderSuccessfulPaymentByBankWire();
    }

    @Test(description = "Complete order processing from login to payment verification and choose payment by check")
    public void orderingAndPaymentByCheck() {
        orderSteps
            .login(EMAIL, PASSWORD, TestData.newUser())
            .addProductToCart("Faded Short Sleeve T-shirts", 2, "L")
            .goToCheckout()
            .checkDeliveryAddressInfo(TestData.newUser())
            .confirmSummary()
            .confirmAddress()
            .agreeToTheTermsOfService()
            .payByCheck()
            .confirmOrder()
            .checkOrderSuccessfulPaymentByCheck();
    }
}
