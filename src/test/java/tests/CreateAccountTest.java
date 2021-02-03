package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import utils.TestData;

public class CreateAccountTest extends BaseTest {

    @Test(description = "New User creation with valid data")
    public void createNewUser() {
        createAccountSteps
            .openPage(TestData.newUser())
            .fillRequiredRegisterData(TestData.newUser())
            .clickRegisterButton()
            .checkLoginSuccessful(TestData.newUser());
    }

    @Test(description = "Try to register an existing user")
    public void createExistingUser() {
        createAccountSteps
            .fillInRegisteredUserData(AuthenticationPage.EMAIL)
            .checkRegisteredEmailError();
    }
}
