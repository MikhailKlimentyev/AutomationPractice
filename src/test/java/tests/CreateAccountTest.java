package tests;

import org.testng.annotations.Test;
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
}
