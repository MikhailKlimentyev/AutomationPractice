package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
public class AuthenticationPage extends BasePage {

    public static final String EMAIL = System.getenv().getOrDefault("email", PropertyReader.getProperty("email"));
    public static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    private static final By EMAIL_CREATE_INPUT = By.id("email_create");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By ERROR = By.cssSelector(".alert.alert-danger");
    private static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
    public String endpoint = "index.php?controller=authentication&back=my-account";

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage filInTheEmailField(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public AuthenticationPage filInThePasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    // TO DO переход на страниу мой аккаунт
    public String getErrorMessage() {
        return driver.findElement(ERROR).getText();
    }

    public AuthenticationPage setEmailCreate(String email) {
        driver.findElement(EMAIL_CREATE_INPUT).sendKeys(email);
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new CreateAccountPage(driver);
    }

    public AuthenticationPage openPage() {
        openPage(URL, endpoint);
        isPageOpened(SIGN_IN_BUTTON);
        return this;
    }
}
