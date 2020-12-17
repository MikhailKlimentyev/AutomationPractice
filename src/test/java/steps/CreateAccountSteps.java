package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class CreateAccountSteps extends BaseTest {
    CreateAccountPage createAccountPage;
    AuthenticationPage authenticationPage;
    AccountPage accountPage;

    public CreateAccountSteps(WebDriver driver) {
        createAccountPage = new CreateAccountPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Step("Fill in new {user.email} and open Create Account page")
    public CreateAccountSteps openPage(String email) {
        authenticationPage
                .openPage()
                .setEmailCreate(email)
                .clickCreateAccountButton();
        createAccountPage
                .isPageOpened();
        return this;
    }

    @Step("Fill Required Registration data for {user.firstName}")
    public CreateAccountSteps fillRequiredRegisterData(User user) {
        createAccountPage
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setAddress(user.getAddress())
                .setCity(user.getCity())
                .setState(user.getState())
                .setPostalCode(user.getPostalCode())
                .setCountry(user.getCountry())
                .setPhone(user.getPhone());
        return this;
    }

    @Step("Click Register button")
    public CreateAccountSteps clickRegisterButton() {
        createAccountPage.clickRegisterButton();
        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful(User user) {
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
    }
}
