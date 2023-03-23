package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.BusinessController;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    BusinessController businessController = new BusinessController();

    @Before
    public void setUp(Scenario scenario) {
    }

    @After
    public void tearDown() {

    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.println("I navigate to the login page");
        String url = "https://the-internet.herokuapp.com/";
        String feature = "" ;
        String scenario = "";
        businessController.starApp( url,  feature,  scenario);
    }

    @When("I enter the credentials correctly")
    public void iEnterTheCredentialsCorrectly() {
        System.out.println("I enter the credentials correctly");
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        businessController.inputCredentials(username, password);
    }
/*   @When("I enter the credentials {string} and {string} correctly")
    public void iEnterTheCredentialsUsernameAndPasswordCorrectly(String username, String password) {
        System.out.println("I enter the credentials (.*?) and (.*?) correctly");
        System.out.println(String.format("User: %d, Pasw: %d", username, password));
    }*/

    @Then("I can access to the home page")
    public void iCanAccessToTheHomePage() {
        System.out.println("I can access to the home page");
    }


    @And("I enter the credentials {string} and {string} correctly")
    public void iEnterTheCredentialsAndCorrectly(String username, String password) {
        System.out.println("I enter the credentials correctly");
        System.out.println(String.format("User: %s, Pasw: %s", username, password));
    }
}
