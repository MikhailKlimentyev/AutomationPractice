package tests;

import org.testng.annotations.Test;
import utils.TestData;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createNewUser() {
        createAccountSteps
                .openPage(testData.newUser().getEmail())
                .fillRequiredRegisterData(testData.newUser())
                .ClickRegisterButton();
//                .checkRegistrationSuccessful();
    }
}
