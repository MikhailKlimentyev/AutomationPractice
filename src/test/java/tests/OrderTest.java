package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import utils.TestData;

public class OrderTest extends BaseTest {

    @Test(description = "Complete order processing from login to payment verification and choose payment by bank wire")
    public void orderingAndPaymentByBankWire() {
        orderSteps
                .login(AuthenticationPage.EMAIL, AuthenticationPage.PASSWORD, TestData.newUser())
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
                .login(AuthenticationPage.EMAIL, AuthenticationPage.PASSWORD, TestData.newUser())
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
