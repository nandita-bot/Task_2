package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.ConfigurationTools;
//import net.automation.pages.LoginPage;
import utilities.ConfigLoader;

public class Configsteps {
    ConfigurationTools configs;


    static Config config = ConfigLoader.load();


    @Given("^I hit the Urls$")
    public void iHitTheUrls() throws Throwable {
        configs.openUrl(config.getString("login_url1"));
        configs.getDriver().manage().window().maximize();
    }
    @Then("^I click on the login buttons$")
    public void iClickOnTheLoginButtons() {
        configs.Logincred();
    }
    @And("^It will navigate to the another windows$")
    public void itWillNavigateToTheAnotherWindows() {
        System.out.print("you are on the another window");
    }



    @When("^I fill the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iFillTheAnd(String arg0, String arg1) {
        configs.credens(arg0, arg1);
    }
    @And("^I click on the Sign in buttons$")
    public void iClickOnTheSignInButtons() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }




    @Then("^I click on the confiTab$")
    public void iClickOnTheConfiTab() {
        configs.ConfigurationTab();
    }

    @And("^Click on the ProductTab$")
    public void clickOnTheProductTab() {
        configs.Product();
    }


    @Then("^I click on the edit button$")
    public void iClickOnTheEditButton() {
       configs.Edits();

    }


}
