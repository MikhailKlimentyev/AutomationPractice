package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add product to cart from product page")
    public void addProductToCartFromProductPage() {
        cartSteps
                .openPage()
                .openProductByName("Blouse")
                .addProductToCart(2)
                .checkNumberOfProductsInCart(2);
    }

    @Test(description = "Remove previously added product from cart")
    public void removeProductFromCart() {
        cartSteps
                .openPage()
                .openProductByName("Blouse")
                .addProductToCart(2)
                .checkNumberOfProductsInCart(2)
                .removeProductFromCart()
                .validateNotificationMessageWithEmptyShoppingCart();
    }
}
