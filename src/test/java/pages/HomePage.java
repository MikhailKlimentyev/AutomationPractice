package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    private static final By SIGN_IN_BUTTON = By.className("login");
    private static final By POPULAR_BUTTON = By.xpath("//li[@class='active']//a");

    public String endpoint = "index.php";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        openPage(URL, endpoint);
        isPageOpened(POPULAR_BUTTON);
        return this;
    }

    public AuthenticationPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AuthenticationPage(driver);
    }

    public ProductPage openProductByName(String productName) {
        driver.findElement(By.linkText(productName)).click();
        return new ProductPage(driver);
    }
}
