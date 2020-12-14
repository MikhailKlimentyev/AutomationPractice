package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class HomePage extends BasePage {

    public String endpoint = "index.php";
    private static final By SEARCH_INPUT = By.name("search_query");
    private static final By SEARCH_BUTTON = By.name("submit_search");
    private static final By SIGN_IN_BUTTON = By.className("login");
    private static final By SIGN_OUT_BUTTON = By.xpath("//li[@class='active']//a");
    private static final By CART_BUTTON = By.className("account");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
        return this;
    }

    @Override
    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SIGN_OUT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + SIGN_OUT_BUTTON);
        }
//        AllureUtils.takeScreenshot(driver);
        return this;
    }
    public AuthenticationPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();

        return new AuthenticationPage(driver);
    }

    public HomePage openProductByName(String productName) {
        driver.findElement(By.linkText(productName)).click();

        return this; //вернуть страницу продукта

}}
