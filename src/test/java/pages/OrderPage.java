package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    private static final By ADDRESS_NAME_TEXT = By.xpath("//*[contains(@class,'first_item')]//*[@class='address_name']");
    private static final By ADDRESS_TEXT = By.xpath("//*[contains(@class,'first_item')]//*[@class='address_address1']");
    private static final By ADDRESS_CITY_TEXT = By.xpath("//*[contains(@class,'first_item')]//*[@class='address_city']");
    private static final By ADDRESS_PHONE_TEXT = By.xpath("//*[contains(@class,'first_item')]//*[@class='address_phone_mobile']");
    private static final By CONFIRM_ADDRESS_BUTTON = By.name("processAddress");
    private static final By CGV_CHECKBOX = By.cssSelector("#cgv");
    private static final By CONFIRM_SHIPPING_BUTTON = By.name("processCarrier");
    private static final By PAY_BY_BANK_WIRE_BUTTON = By.cssSelector(".bankwire");
    private static final By PAY_BY_CHECK_BUTTON = By.cssSelector(".cheque");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//button[contains(@class,'button-medium')]");
    private static final By ORDER_SUCCESSFUL_TEXT_CHECK = By.cssSelector(".alert-success");
    private static final By ORDER_SUCCESSFUL_TEXT_BANK_WIRE = By.xpath("//div[@class='box']//*[@class='dark']");

    public OrderPage(WebDriver driver) {
        super(driver);
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

    public void clickProceedToCheckoutAddressButton() {
        driver.findElement(CONFIRM_ADDRESS_BUTTON).click();
    }

    public void setCgvCheckbox() {
        driver.findElement(CGV_CHECKBOX).click();
    }

    public void clickProceedToCheckoutShippingButton() {
        driver.findElement(CONFIRM_SHIPPING_BUTTON).click();
    }

    public void clickPayByBankWireButton() {
        driver.findElement(PAY_BY_BANK_WIRE_BUTTON).click();
    }

    public void clickPayByCheckButton() {
        driver.findElement(PAY_BY_CHECK_BUTTON).click();
    }

    public void clickConfirmOrderButton() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }

    public String getOrderSuccessfulTextPaymentByCheck() {
        return driver.findElement(ORDER_SUCCESSFUL_TEXT_CHECK).getText().trim();
    }

    public String getOrderSuccessfulTextPaymentByBankWire() {
        return driver.findElement(ORDER_SUCCESSFUL_TEXT_BANK_WIRE).getText().trim();
    }

}
