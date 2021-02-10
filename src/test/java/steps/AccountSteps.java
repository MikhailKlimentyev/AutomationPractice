package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static utils.PropertyReader.getProperty;

public class AccountSteps {

    BaseSteps baseSteps;

    public AccountSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @When("Fill out email field with still no registered email in order to create an account")
    public void fillInEmailFieldWithValueInOrderToCreateAnAccount() {
        String email = baseSteps.generateUniqueEmail();
        baseSteps.authenticationPage.setEmailCreate(email);
    }

    @And("Click on Create an account button")
    public void clickOnCreateAnAccountButton() {
        baseSteps.authenticationPage.clickCreateAccountButton();
    }

    @And("Fill out Create an account form for the following user")
    public void fillOutCreateAnAccountFormForTheFollowingUser(List<User> users) {
        User user = users.get(0);
        baseSteps.createAccountPage
            .setFirstName(user.getFirstName())
            .setLastName(user.getLastName())
            .setPassword(user.getPassword())
            .setAddress(user.getAddress())
            .setCity(user.getCity())
            .setState(user.getState())
            .setPostalCode(user.getPostalCode())
            .setCountry(user.getCountry())
            .setPhone(user.getPhone());
    }

    @And("Click on Register button")
    public void clickOnRegisterButton() {
        baseSteps.createAccountPage.clickRegisterButton();
    }

    @When("Fill in email address field with {string} on create new account form")
    public void fillInEmailAddressFieldWithOnCreateNewAccountForm(String email) {
        email = getProperty(email, email);
        baseSteps.authenticationPage.setEmailCreate(email);
    }

    @Then("The error with following error message appears")
    public void theErrorWithFollowingErrorMessageAppears(String email) {
        assertEquals(baseSteps.createAccountPage.getErrorMessage(), email);
    }
}
