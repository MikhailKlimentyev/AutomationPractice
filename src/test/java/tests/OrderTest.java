package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import utils.TestData;

public class OrderTest extends BaseTest {

    @Test(description = "Complete order processing from login to payment verification")
    public void orderingAndPayment() {
        orderSteps
                .login(AuthenticationPage.EMAIL, AuthenticationPage.PASSWORD, TestData.newUser())
                .addProductToCart("Printed Dress", 3, "M")
                .goToCheckout()
                .checkDeliveryAddressInfo(TestData.newUser())
                .submitSummary();
//       TODO
//        shipment, payment

    }
}
