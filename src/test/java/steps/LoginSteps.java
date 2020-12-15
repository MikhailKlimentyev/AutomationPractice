package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.AuthenticationPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseTest {

    AuthenticationPage authenticationPage;
    AccountPage accountPage;


    public LoginSteps(WebDriver driver) {
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Step("Open Authentication page")
    public LoginSteps openPage() {
        authenticationPage.openPage();

        return this;
    }
    @Step("Fill in the email and password fields")
    public LoginSteps attemptToLogin(String email, String password) {
        authenticationPage.filInTheEmailField(email);
        authenticationPage.filInThePasswordField(password);

        return this;
    }

    @Step("Click Login button")
    public LoginSteps clickSignInButton() {
        authenticationPage.clickLoginButton();

        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful() {
        assertEquals(accountPage.actualUrl(), accountPage.getUrl());
    }

}
