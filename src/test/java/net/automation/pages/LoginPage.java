package net.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;
import java.util.Set;



public class LoginPage extends PageObject {
    Google google;
    @FindBy(xpath = "//button[@id=\"sign-in\"]")
    WebElementFacade logins;
    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    WebElementFacade Username;
    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    WebElementFacade password;
    @FindBy(xpath = "//button[@id=\"signIn\"]")
    WebElementFacade login;
    @FindBy (xpath ="(//div[@class='toolsBox'])[10]")
     WebElementFacade gateway;
    @FindBy (xpath =" //a[@href='#tab2TrapData']")
    WebElementFacade TrapData;
    @FindBy (xpath ="(//th[@class='sorting_disabled'])[5]")
    WebElementFacade SelectAll;
    @FindBy(xpath="//th[@aria-label='Location Name: activate to sort column descending'][1]")
    WebElementFacade LocationName;
    @FindBy (xpath = "//a[@href='#tab3ExcelImport']")
    WebElementFacade ExcelImport;

    public void switchToLatestTab() {
        Set<String> windows = getDriver().getWindowHandles();
        for (String ws : windows) {
            getDriver().switchTo().window(ws);
        }
    }

    public void Login (){ logins.withTimeoutOf(10, TimeUnit.SECONDS).click();}


    public void creden(String arg0, String arg1) {

        switchToLatestTab();
        Username.sendKeys(arg0);
        password.sendKeys(arg1);
        login.withTimeoutOf(10, TimeUnit.SECONDS).click();



    }
    public void Gateway (){
        switchToLatestTab();
        gateway.withTimeoutOf(120,TimeUnit.SECONDS).click();
        waitABit(10000);

    }

        public void trapData (){
        switchToLatestTab();
        TrapData.withTimeoutOf(30,TimeUnit.SECONDS).click();
        waitABit(10000);
    }

    public void selectAll(){
        withAction().click(SelectAll).perform();
        SelectAll.waitUntilVisible();
    }
    public void locationname(){
        withAction().click(LocationName).perform();
        LocationName.waitUntilVisible();
    }

    public void excelImport(){
        switchToLatestTab();
        ExcelImport.withTimeoutOf(100,TimeUnit.SECONDS).click();
    }
    public void seturl() {
        google.goToHomePage();
    }
}


