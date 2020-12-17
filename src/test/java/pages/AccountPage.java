package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class AccountPage extends BasePage {
    private static final By LOGO = By.id("header_logo");
    private static final By LOG_OUT_BUTTON = By.cssSelector(".logout");
    private static final By HEADING_USER_NAME = By.xpath("//div[@class='header_user_info']//a//span");
    public String endpoint = "index.php?controller=my-account";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnLogo() {
        driver.findElement(LOGO).click();
        return new HomePage(driver);
    }

    public AccountPage openPage() {
        openPage(URL, endpoint);
        isPageOpened(LOG_OUT_BUTTON);
        return this;
    }

    public String getHeadingUserName() {
        return driver.findElement(HEADING_USER_NAME).getText();
    }
}
