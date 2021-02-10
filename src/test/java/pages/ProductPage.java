package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    private static final By WANTED_QUANTITY = By.cssSelector("#quantity_wanted");
    private static final By WANTED_SIZE = By.cssSelector("#group_1");
    private static final By ADD_TO_CART_BUTTON = By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@class='btn btn-default button button-medium']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage setProductQuantity(int productQuantity) {
        driver.findElement(WANTED_QUANTITY).clear();
        driver.findElement(WANTED_QUANTITY).sendKeys(Integer.toString(productQuantity));
        return this;
    }

    public ProductPage setProductSize(String productSize) {
        Select select = new Select(driver.findElement(WANTED_SIZE));
        select.selectByVisibleText(productSize);
        return this;
    }

    public ProductPage clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public ProductPage clickProceedToCheckoutButton() {
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return this;
    }
}
