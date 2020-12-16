package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import utils.TestData;

public class LoginTest extends BaseTest {
    public static String EMPTY_STRING = "";
    public static String INCORRECT_EMAIL = "ghjd%$:125'?ikil@gmail.com";
    public static String INCORRECT_PASSWORD = "698$2%$:fhj'354787";

    @Test
    public void loginWithCorrectData() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, AuthenticationPage.PASSWORD)
                .clickSignInButton()
                .checkLoginSuccessful(TestData.newUser());
    }

    @Test
    public void loginWithIncorrectEmail() {
        loginSteps.openPage()
                .attemptToLogin(INCORRECT_EMAIL, AuthenticationPage.PASSWORD)
                .clickSignInButton()
                .validateErrorMessageWithIncorrectEmail();
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, INCORRECT_PASSWORD)
                .clickSignInButton()
                .validateErrorMessageWithIncorrectPassword();
    }

    @Test
    public void emailShouldBeEmpty() {
        loginSteps.openPage()
                .attemptToLogin(EMPTY_STRING, AuthenticationPage.PASSWORD)
                .clickSignInButton()
                .validateErrorMessageWithEmptyEmail();
    }

    @Test
    public void passwordShouldBeEmpty() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, EMPTY_STRING)
                .clickSignInButton()
                .validateErrorMessageWithEmptyPassword();
    }

}
