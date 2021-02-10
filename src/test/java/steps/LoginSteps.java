package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static utils.PropertyReader.getProperty;

public class LoginSteps {

    BaseSteps baseSteps;

    public LoginSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @When("Fill out email field with valid value")
    public void fillOutEmailFieldWithValidValue() {
        String email = getProperty("email", "email");
        baseSteps.authenticationPage.fillInTheEmailField(email);
    }

    @Then("Error message with text {string} is appeared")
    public void errorMessageWithTextIsAppeared(String errorMessage) {
        assertEquals(baseSteps.authenticationPage.getErrorMessage(), String.format("There is 1 error\n%s", errorMessage));
    }

    @And("Click on Sign Out button")
    public void clickOnSignOutButton() {
        baseSteps.authenticationPage.clickLogOutButton();
    }

    @Then("LogOut is successful")
    public void logOutIsSuccessful() {
        baseSteps.authenticationPage.visibilityOfTheLoginButton();
    }

    @When("Fill in email field with {string} value")
    public void fillOutEmailFieldWithValue(String email) {
        if (email.equals("email")) {
            email = getProperty("email", "email");
        }
        baseSteps.authenticationPage.fillInTheEmailField(email);
    }

    @And("Fill in password field with {string} value")
    public void fillInPasswordFieldWithValue(String password) {
        if (password.equals("password")) {
            password = getProperty("password", "password");
        }
        baseSteps.authenticationPage.fillInThePasswordField(password);
    }

    @And("Click on Sign In button")
    public void clickOnSignInButton() {
        baseSteps.authenticationPage.clickLoginButton();
    }

}
