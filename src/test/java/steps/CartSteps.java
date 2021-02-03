package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class CartSteps {

    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    public CartSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Step("Open Home page")
    public CartSteps openPage() {
        homePage.openPage();
        return this;
    }

    @Step("Open Product page by Product name: {productName}")
    public CartSteps openProductByName(String productName) {
        homePage.openProductByName(productName);
        return this;
    }

    @Step("Add product to Cart with count: {productQuantity}")
    public CartSteps addProductToCart(int productQuantity) {
        productPage
            .setProductQuantity(productQuantity)
            .clickAddToCartButton()
            .clickProceedToCheckoutButton();
        return this;
    }

    @Step("Remove product from Cart")
    public CartSteps removeProductFromCart() {
        cartPage.clickRemoveProductFromCartButton();
        return this;
    }

    @Step("Check number of Products added to Cart")
    public CartSteps checkNumberOfProductsInCart(int expectedCartQuantity) {
        assertEquals(cartPage.getCartQuantity(), expectedCartQuantity);
        return this;
    }

    @Step("Check that the shopping cart is empty.")
    public CartSteps validateNotificationMessageWithEmptyShoppingCart() {
        assertEquals(cartPage.getNotificationMessage(), "Your shopping cart is empty.");
        return this;
    }
}
