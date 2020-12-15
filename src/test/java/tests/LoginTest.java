package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    public static String EMPTY_STRING = "";
    public static String INCORRECT_EMAIL = "ghjd%$:125'?ikil@gmail.com";
    public static String INCORRECT_PASSWORD = "698$2%$:fhj'354787";

    @Test
    public void loginWithCorrectData() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, AuthenticationPage.PASSWORD)
                .clickSignInButton()
                .checkLoginSuccessful();
    }

    @Test
    public void loginWithINCORRECT_EMAIL() {
        loginSteps.openPage()
                .attemptToLogin(INCORRECT_EMAIL, AuthenticationPage.PASSWORD)
                .clickSignInButton();
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Invalid email address.");
    }
    //завести ассерты в степы?

    @Test
    public void loginWithINCORRECT_PASSWORD() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, INCORRECT_PASSWORD)
                .clickSignInButton();
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Authentication failed.");
    }

    @Test
    public void emailShouldBeEmpty() {
        loginSteps.openPage()
                .attemptToLogin(EMPTY_STRING, AuthenticationPage.PASSWORD)
                .clickSignInButton();
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "An email address required.");
    }

    @Test
    public void passwordShouldBeEmpty() {
        loginSteps.openPage()
                .attemptToLogin(AuthenticationPage.EMAIL, EMPTY_STRING)
                .clickSignInButton();
        assertEquals(authenticationPage.getErrorMessage(), "There is 1 error\n" + "Password is required.");
    }


}
