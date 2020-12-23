package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.AuthenticationPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {

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

    @Step("Fill in the email {email} and password {password} fields")
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

    @Step("Click Log Out button")
    public LoginSteps clickSignOutButton() {
        authenticationPage.clickLogOutButton();
        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful(User user) {
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
    }

    @Step("Check Login unsuccessful with invalid email")
    public void validateErrorMessageWithInvalidEmail() {
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Invalid email address.");
    }

    @Step("Check Login unsuccessful with incorrect data ")
    public void validateErrorMessageWithIncorrectData() {
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Authentication failed.");
    }

    @Step("Check Login unsuccessful with empty password")
    public void validateErrorMessageWithEmptyPassword() {
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Password is required.");
    }

    @Step("Check Login unsuccessful with empty email")
    public void validateErrorMessageWithEmptyEmail() {
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "An email address required.");
    }

    @Step("Check Log Out successful")
    public void checkLogOutSuccessful() {
        authenticationPage.visibilityOfTheLoginButton();
    }
}
