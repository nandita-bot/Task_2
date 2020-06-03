package net.automation.pages;


import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.scheduling.FluentWaitWithRefresh;
import org.fluentlenium.core.wait.FluentWait;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ConfigurationTools extends PageObject {
    Google google;
    @FindBy(xpath = "//button[@class='btn btn-block']")
    WebElementFacade loginsin;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/form[1]/label[1]/input[1]")
    WebElementFacade Username;
    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    WebElementFacade password;
    @FindBy(xpath = "//button[@id=\"signIn\"]")
    WebElementFacade login;
    @FindBy(xpath = "(//div[@class='toolsBox'])[7]")
    WebElementFacade configTab;
    @FindBy(xpath = "//a[@href='#tab3Product']")
    WebElementFacade product;
    @FindBy(xpath = "(//a[@class='EditRowReview edit-treatment']/i[@class='fa fa-edit'])[11]")
    WebElementFacade Edit;


    public void switchToLatestTab() {
        Set<String> windows = getDriver().getWindowHandles();
        for (String ws : windows) {
            getDriver().switchTo().window(ws);
        }
    }

    public void Logincred() {
       withAction().click(loginsin).perform();

    }


    public void credens(String arg0, String arg1)
    {
       //getDriver("https://www.arcgis.com/sharing/oauth2/authorize?client_id=Jb72bJ2WXRFmgBfz&response_type=token&state=%7B%22portalUrl%22%3A%22https%3A%2F%2Fwww.arcgis.com%22%7D&expiration=20160&redirect_uri=http%3A%2F%2Ffieldseekeroffice.aspcore.net%2Foauth-callback.html")

        switchToLatestTab();

        System.out.println("_________________________");
        waitABit(1000);

        Username.sendKeys(arg0);

        System.out.println("-------");
        password.sendKeys(arg1);
        login.withTimeoutOf(100, TimeUnit.SECONDS).click();


    }



    public void ConfigurationTab (){
        switchToLatestTab();
        configTab.withTimeoutOf(120,TimeUnit.SECONDS).click();
        waitABit(5000);
    }
    public void Product (){
        switchToLatestTab();
      //  product.withTimeoutOf(70,TimeUnit.SECONDS).click();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(product).waitUntilVisible();
        withAction().click(product).perform();
        waitABit(2000);
    }
    public void Edits () {
      // waitABit(3000);

       withTimeoutOf(20,TimeUnit.SECONDS).waitFor(Edit).waitUntilVisible();
        withAction().click(Edit).perform();
    }


    public void seturl() {
        google.goToHomePage();
    }
}