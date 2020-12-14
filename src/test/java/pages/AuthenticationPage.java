package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.PropertyReader;

@Log4j2
public class AuthenticationPage extends BasePage{

    public String endpoint = "index.php?controller=authentication&back=my-account";

    private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    public static final String EMAIL = System.getenv().getOrDefault("email", PropertyReader.getProperty("email"));
    public static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    private static final By ERROR = By.cssSelector(".alert.alert-danger");


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage filInTheEmailField(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);

        return this;
    }
    public AuthenticationPage filInThePasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);

        log.info("Set password: " + password);

        return this;
    }
    public void clickLoginButton() {
        driver.findElement(SIGN_IN_BUTTON).click();

    }
    // TO DO переход на страниу мой аккаунт
    public String getErrorMessage() {
        return driver.findElement(ERROR).getText();
    }

    @Override
    public AuthenticationPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SIGN_IN_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + SIGN_IN_BUTTON);
        }
//        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Override
    public AuthenticationPage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
        return this;
    }



}
