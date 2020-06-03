package net.automation.pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;
import org.yecht.JechtIO;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class ProductPage extends PageObject {

    @FindBy(xpath="//button[@class='btn btn-block']")
    WebElementFacade Logincreds;
    @FindBy(xpath = "//input[@name='username']")
    WebElementFacade Users;
    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade Pswrd;
    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade Signup;
    @FindBy(xpath = "(//div[@class='toolsBox'])[7]")
    WebElementFacade configTabs;
    @FindBy(xpath = "//a[@href='#tab3Product']")
    WebElementFacade products;
    @FindBy(xpath="(//i[@class='fa fa-plus-circle'])[2]")
    WebElementFacade Addbtn;
    @FindBy(xpath="(//input[@placeholder='Name'])[2]")
    WebElementFacade Names;
    @FindBy(xpath="//input[@placeholder='Value']")
    WebElementFacade VAlues;
    @FindBy(xpath="(//select[@class='form-control'])[3]")
    WebElementFacade Units;
    @FindBy(xpath = "(//input[@placeholder='Duration'])[1]")
     WebElementFacade durations;
    @FindBy(xpath = "//input[@placeholder='L range']")
     WebElementFacade Ranges;
    @FindBy(xpath = "//select[@id='selProductStormdrain']")
    WebElementFacade SD;
    @FindBy(xpath = "//select[@id='selProduct_Active']")
    WebElementFacade Actives;
    @FindBy(xpath = "(//button[@class='btn btn-xs btn-default'])[3]")
    WebElementFacade Saveit;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElementFacade Hide;

 void switchToLatestTab() {
        Set<String> windows = getDriver().getWindowHandles();
        for (String ws : windows) {
            getDriver().switchTo().window(ws);
        }

    }

    public void Login(){
        withAction().click(Logincreds).perform();
    }
     public void usercreds(String arg0, String arg1){
      switchToLatestTab();

         waitABit(1000);

         Users.sendKeys(arg0);

         System.out.println("-------");
         Pswrd.sendKeys(arg1);
         Signup.withTimeoutOf(100, TimeUnit.SECONDS).click();
     }

    public void ConfigurationTAb(){
        switchToLatestTab();
        configTabs.withTimeoutOf(120, TimeUnit.SECONDS).click();
        waitABit(1000);
    }

    public void ProductTab(){
     waitABit(8000);
     switchToLatestTab();
        products.withTimeoutOf(20,TimeUnit.SECONDS).click();
        waitABit(2000);
    }

    public void  Add (){

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(Addbtn).waitUntilVisible();
        withAction().click(Addbtn).perform();


    }
    public void Namefields(DataTable dataTable){
        List<Map<String,String>> data=dataTable.asMaps(String.class,String.class);
        System.out.print(data);
        String str= data.get(0).get("Name");
        waitABit(5000);
        Names.waitUntilVisible();
        Names.sendKeys(str);
        String str1 = data.get(0).get("Value");
        waitABit(5000);
        VAlues.waitUntilVisible();
        VAlues.sendKeys(str1);
    }
    public void Measure(DataTable dataTable){
        List<Map<String,String>>data=dataTable.asMaps(String.class,String.class);
        String str3=data.get(0).get("Measure Unit");
        Select s1=new Select(Units);
        s1.selectByVisibleText(str3);
        waitABit(5000);
        Units.waitUntilVisible();
    }
    public void duration (DataTable dataTable){
        List<Map<String,String>>data=dataTable.asMaps(String.class,String.class);
        System.out.print(data);
        String str4=data.get(0).get("Duration");
        waitABit(5000);
        durations.waitUntilVisible();
        durations.sendKeys(str4);
        String str5=data.get(0).get("L range");
        waitABit(5000);
        Ranges.waitUntilVisible();
        Ranges.sendKeys(str5);
        String str6=data.get(0).get("Storm drain");
        waitABit(4000);
        SD.waitUntilVisible();
        SD.sendKeys(str6);
        String str7=data.get(0).get("Active");
        waitABit(4000);
        Actives.waitUntilVisible();
        Actives.sendKeys(str7);


    }
    public void savebutton()
    {  waitABit(3000);
        if (Saveit.isEnabled()) {
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(Saveit).waitUntilVisible();
            Saveit.withTimeoutOf(30, TimeUnit.SECONDS).click();
            waitABit(10000);
        } else {
            System.out.println("saveit is diabled");
        }
    }

    public void Hideit()
    {
     Hide.withTimeoutOf(30,TimeUnit.SECONDS).click();
     waitABit(2000);
    }
    }
