package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import tests.BaseTest;

public class CreateAccountSteps extends BaseTest {
    CreateAccountPage createAccountPage;
    AuthenticationPage authenticationPage;

    public CreateAccountSteps(WebDriver driver) {
        createAccountPage = new CreateAccountPage(driver);
        authenticationPage = new AuthenticationPage(driver);

    }

    @Step("Fill in new email and open Create Account page")
    public CreateAccountSteps openPage(String email) {
        authenticationPage
                .openPage()
                .setEmailCreate(email)
                .clickCreateAccountButton();

        return this;
    }
    @Step("Fill Required Registration data")
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
    public CreateAccountSteps ClickRegisterButton() {
        createAccountPage.clickRegisterButton();

        return this;
    }
}
