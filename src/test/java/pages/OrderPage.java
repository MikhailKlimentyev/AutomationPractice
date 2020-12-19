package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    private static final By CONFIRM_SUMMARY_BUTTON = By.xpath("//*[contains(@class,'standard-checkout')]");
    private static final By ADDRESS_NAME_TEXT = By.xpath("//*[contains(@class,'first_item')]//span[@class='address_name']");
    private static final By ADDRESS_TEXT = By.xpath("//*[contains(@class,'first_item')]//span[@class='address_address1']");
    private static final By ADDRESS_CITY_TEXT = By.xpath("//*[contains(@class,'first_item')]//span[@class='address_city']");
    private static final By ADDRESS_PHONE_TEXT = By.xpath("//*[contains(@class,'first_item')]//span[@class='address_phone_mobile']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutSummaryButton() {
        driver.findElement(CONFIRM_SUMMARY_BUTTON).click();
    }

    public String getAddressName() {
        return driver.findElement(ADDRESS_NAME_TEXT).getText().trim();
    }

    public String getAddress() {
        return driver.findElement(ADDRESS_TEXT).getText().trim();
    }

    public String getAddressCity() {
        return driver.findElement(ADDRESS_CITY_TEXT).getText().trim();
    }

    public String getAddressPhone() {
        return driver.findElement(ADDRESS_PHONE_TEXT).getText().trim();
    }

}
