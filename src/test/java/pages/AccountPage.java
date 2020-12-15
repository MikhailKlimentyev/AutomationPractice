package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


@Log4j2
public class AccountPage extends BasePage {
    public String endpoint = "index.php?controller=my-account";

    private static final By LOGO = By.id("header_logo");
    private static final By LOG_OUT_BUTTON = By.cssSelector(".logout");

    public AccountPage(WebDriver driver) {
        super(driver);
    }


    public HomePage clickOnLogo() {
        driver.findElement(LOGO).click();

        return new HomePage(driver);
    }

    public String getUrl() {
        return URL + endpoint;
    }

    public String actualUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public BasePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOG_OUT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + LOG_OUT_BUTTON);
        }
//        AllureUtils.takeScreenshot(driver);
        return this;
    }


    @Override
    public BasePage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();

        return this;
    }
}
