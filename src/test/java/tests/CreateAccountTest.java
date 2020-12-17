package tests;

import org.testng.annotations.Test;
import utils.TestData;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createNewUser() {
        createAccountSteps
                .openPage(TestData.newUser().getEmail())
                .fillRequiredRegisterData(TestData.newUser())
                .clickRegisterButton();
//                .checkRegistrationSuccessful();
    }
}
