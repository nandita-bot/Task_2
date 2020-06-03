package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.ProductPage;
import utilities.ConfigLoader;

public class ProductSteps {
    ProductPage products;
    static Config config = ConfigLoader.load();

    @Given("^I hit on the URL of login$")
    public void iHitOnTheURLOfLogin() throws Throwable {
        products.openUrl(config.getString("dashboard_url"));
        products.getDriver().manage().window().maximize();
    }

    @Then("^Click on the Login icon$")
    public void clickOnTheLoginIcon(){
        products.Login();
    }
    @Then("^I fill the \"([^\"]*)\"and\"([^\"]*)\"$")
    public void iFillTheAnd(String arg0, String arg1) {
        products.usercreds(arg0,arg1);
    }
    @And("^I clicked on the Signin icon$")
    public void iClickedOnTheSigninIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



    @Then("^click on the configTools$")
    public void clickOnTheConfigTools() {
        products.ConfigurationTAb();
    }

    @And("^click on the Product$")
    public void clickOnTheProduct() {
        products.ProductTab();
    }

    @And("^Click on the Add button$")
    public void clickOnTheAddButton() {
        products.Add();
    }

    @Then("^Fill the required fields one by one$")
    public void fillTheRequiredFieldsOneByOne(DataTable dataTable) {
        products.Namefields(dataTable);
        products.Measure(dataTable);
        products.duration(dataTable);
    }

    @And("^Click on the save button$")
    public void clickOnTheSaveButton() {
        products.savebutton();
    }

    @Then("^click on the hide button$")
    public void clickOnTheHideButton() {
        products.Hideit();
    }



}
