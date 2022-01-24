package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;
import utilities.DriverManager;
import utilities.Globals;

public class LoginStepDef {
    LoginPage LoginPage = new LoginPage(new DriverManager().getDriver());

    @Given("the user has the app installed")
    public void the_user_has_the_app_installed() {

    }

    @When("the user launches the app")
    public void the_user_launches_the_app() {

    }

    @Then("user sees loginpage")
    public void user_sees_LoginPage() throws IOException {

	LoginPage.VerifyLoginScreen();

    }

    @When("enters countrycode as {string}")
    public void enters_countrycode_as(String string) throws IOException {

	LoginPage.entercountrycode(string);

    }

    @When("enters phonenumber as {string}")
    public void enters_phonenumber_as(String string) throws IOException {

	LoginPage.enterphonenumber(string);

    }

    @When("clicks continue")
    public void clicks_Continue() throws IOException {

	LoginPage.clickcontinue();

    }

    @Then("login should fail with error {string}")
    public void login_should_fail_with_error(String string) throws IOException {

	LoginPage.VerifyinvalidphonenumbererrorPresent(string);

    }

    @Then("user sees otppage")
    public void user_sees_otp_page() throws IOException {

	LoginPage.VerifyAuthScreen();

    }

    @When("user clicks back")
    public void user_clicks_back() throws IOException {

	LoginPage.userclickBack();

    }

    @Then("countrycode is {string}")
    public void countrycode_is(String string) throws IOException {

	LoginPage.compareCountryCdeVal(string);
    }

    @Then("phonenumber is {string}")
    public void phonenumber_is(String string) throws IOException {

	LoginPage.comparePhoneNumVal(string);
    }

    @When("user enters otp as {string}")
    public void user_enters_otp_as(String string) throws IOException {
	LoginPage.enterotp(string);

    }

    @Then("user sees welcomemessage {string}")
    public void user_sees_welcomemessage(String string) throws IOException {
	LoginPage.VerifyWelcomeScreen(string);
    }

    @Then("app is closed")
    public void app_is_closed() throws IOException {
	LoginPage.verifyAppState();

    }

}
