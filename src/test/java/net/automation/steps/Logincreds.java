package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.LoginPage;
import org.jruby.RubyProcess;
import utilities.ConfigLoader;

public class Logincreds {
    LoginPage loginPage;


    static Config config = ConfigLoader.load();

    @Given("^I hit the Url$")
    public void iHitTheUrl() throws Throwable {
        loginPage.openUrl(config.getString("login_url1"));
        loginPage.getDriver().manage().window().maximize();
    }

    @Then("^I click on the login button$")
    public void iClickOnTheLoginButton()  {
        loginPage.Login();
        System.out.print("navigate to the another window");
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String arg0, String arg1)
    {
        loginPage.creden(arg0,arg1);

    }

    @And("^I click on the Sign in button$")
    public void iClickOnTheSignInButton() {
        System.out.print("Login successfully");

    }



    @And("^It will navigate to the another window$")
    public void itWillNavigateToTheAnotherWindow() {

        }


    @Then("^Click on the Gateway Tab$")
    public void clickOnTheGatewayTab() {
        loginPage.Gateway();
        System.out.print("you are on gateway");

    }

    @And("^Click on the Trap Data$")
    public void clickOnTheTrapData() {
        loginPage.trapData();
        System.out.print("Trap is clickable");

    }

    @And("^Verify all the details$")
    public void verifyAllTheDetails() {
        loginPage.selectAll();
        loginPage.locationname();
    }

    @Then("^Click on the Excel Import Tab$")
    public void clickOnTheExcelImportTab() {
        loginPage.excelImport();
    }


}

