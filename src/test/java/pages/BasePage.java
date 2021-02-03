package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

    public static final String URL = "http://automationpractice.com/";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public BasePage isPageOpened(By button) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(button));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + button);
        }
        return this;
    }

    public BasePage openPage(String URL, String endpoint) {
        driver.get(URL + endpoint);
        return this;
    }
}
