package tests;

import org.testng.annotations.Test;
import utils.TestData;

import static pages.AuthenticationPage.EMAIL;
import static pages.AuthenticationPage.PASSWORD;

public class LoginTest extends BaseTest {

    public static String EMPTY_STRING = "";
    public static String INCORRECT_EMAIL = "ghjd@gmail.com";
    public static String INVALID_EMAIL = "ghjd%$:125'?ikil@gmail.com";
    public static String INCORRECT_PASSWORD = "698$2%$:fhj'354787";

    @Test(description = "Login with correct user data")
    public void loginWithCorrectData() {
        loginSteps.openPage()
            .attemptToLogin(EMAIL, PASSWORD)
            .clickSignInButton()
            .checkLoginSuccessful(TestData.newUser());
    }

    @Test(description = "Try to log in with an incorrect email")
    public void loginWithIncorrectEmail() {
        loginSteps.openPage()
            .attemptToLogin(INCORRECT_EMAIL, PASSWORD)
            .clickSignInButton()
            .validateErrorMessageWithIncorrectData();
    }

    @Test(description = "Try to log in with an incorrect password")
    public void loginWithIncorrectPassword() {
        loginSteps.openPage()
            .attemptToLogin(EMAIL, INCORRECT_PASSWORD)
            .clickSignInButton()
            .validateErrorMessageWithIncorrectData();
    }

    @Test(description = "Try to log in with an empty email")
    public void emailShouldBeEmpty() {
        loginSteps.openPage()
            .attemptToLogin(EMPTY_STRING, PASSWORD)
            .clickSignInButton()
            .validateErrorMessageWithEmptyEmail();
    }

    @Test(description = "Try to log in with an empty password")
    public void passwordShouldBeEmpty() {
        loginSteps.openPage()
            .attemptToLogin(EMAIL, EMPTY_STRING)
            .clickSignInButton()
            .validateErrorMessageWithEmptyPassword();
    }

    @Test(description = "Try to log in with incorrect password and email")
    public void loginWithIncorrectData() {
        loginSteps.openPage()
            .attemptToLogin(INCORRECT_EMAIL, INCORRECT_PASSWORD)
            .clickSignInButton()
            .validateErrorMessageWithIncorrectData();
    }

    @Test(description = "Try to log in with an incorrect email")
    public void loginWithInvalidEmail() {
        loginSteps.openPage()
            .attemptToLogin(INVALID_EMAIL, PASSWORD)
            .clickSignInButton()
            .validateErrorMessageWithInvalidEmail();
    }

    @Test(description = "Login with correct user data and Log Out")
    public void logOut() {
        loginSteps.openPage()
            .attemptToLogin(EMAIL, PASSWORD)
            .clickSignInButton()
            .clickSignOutButton()
            .checkLogOutSuccessful();
    }
}
