package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private static final By CONFIRM_SUMMARY_BUTTON = By.cssSelector(".standard-checkout");
    private static final By CART_QUANTITY_TEXT = By.cssSelector(".cart_quantity_input");
    private static final By REMOVE_FROM_CART_BUTTON = By.cssSelector(".icon-trash");
    private static final By NOTIFICATION = By.cssSelector(".alert.alert-warning");

    public String endpoint = "index.php?controller=order";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutSummaryButton() {
        driver.findElement(CONFIRM_SUMMARY_BUTTON).click();
    }

    public CartPage clickRemoveProductFromCartButton() {
        driver.findElement(REMOVE_FROM_CART_BUTTON).click();
        return this;
    }

    public CartPage openPage() {
        openPage(URL, endpoint);
        isPageOpened(CONFIRM_SUMMARY_BUTTON);
        return this;
    }

    public int getCartQuantity() {
        String quantity;
        if (driver.findElement(CART_QUANTITY_TEXT).isDisplayed()) {
            quantity = driver.findElement(CART_QUANTITY_TEXT).getAttribute("value");
        } else {
            quantity = "0";
        }
        return Integer.parseInt(quantity);
    }

    public String getNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION));
        return driver.findElement(NOTIFICATION).getText();
    }
}
