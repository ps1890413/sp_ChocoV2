package page;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.DriverManager;
import utilities.Globals;


public class BasePage {
    private AppiumDriver<MobileElement> driver;
    
    
    public BasePage(AppiumDriver driver) {
	
	this.driver = new DriverManager().getDriver();
	//PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);	
    }
    public Boolean IsVisibleById(String IdLocator) {
	MobileElement e=waitUntilVisibileById(IdLocator);
	return e.isDisplayed();
    }
    public Boolean IsVisibleByXpath(String XpathLocator) {
	MobileElement e = waitUntilVisibileByXpath(XpathLocator);
	return e.isDisplayed();
    }
    public MobileElement waitUntilVisibileById(String IdLocator){
        WebDriverWait wait = new WebDriverWait(driver, Globals.WAIT);
        MobileElement e=driver.findElementById(IdLocator);
        wait.until(ExpectedConditions.visibilityOf(e));
	return e;
    }
    public MobileElement waitUntilVisibileByXpath(String XpathLocator){
        WebDriverWait wait = new WebDriverWait(driver, Globals.WAIT);
        MobileElement e=driver.findElementByXPath(XpathLocator);
        wait.until(ExpectedConditions.visibilityOf(e));
	return e;
    }
    public Boolean IsEnabledById(String IdLocator) {
	MobileElement e=waitUntilClickableById(IdLocator);
	return e.isEnabled();
    }
    public MobileElement waitUntilClickableById(String IdLocator){
        WebDriverWait wait = new WebDriverWait(driver, Globals.WAIT);
        MobileElement e=driver.findElementById(IdLocator);
        wait.until(ExpectedConditions.elementToBeClickable(e));
	return e;
    }
    public void sendKeysById(String IdLocator, String txt) {
	MobileElement e=waitUntilClickableById(IdLocator);
	e.clear();
	e.sendKeys(txt);
    }
    public void sendKeysByXpath(String XpathLocator, String txt) {
	MobileElement e=waitUntilVisibileByXpath(XpathLocator);
	e.clear();
	e.sendKeys(txt);
    }
    public void clear(String IdLocator) {
	MobileElement e=waitUntilClickableById(IdLocator);
        e.clear();
    }
    public String getText(String IdLocator) {
        String txt="";
        MobileElement e=waitUntilVisibileById(IdLocator);
	if(Globals.platformName.equals("Android"))
	{
	    txt = e.getAttribute("text");
	}
	
	if(Globals.platformName.equals("iOS"))
	{
	    txt = e.getAttribute("label");
	}
        
        return txt;
    }
    public void click(String IdLocator) {
	MobileElement e=waitUntilClickableById(IdLocator);
        e.click();
    }

    public void RefreshAPP() {
	driver.navigate().back();
	driver.launchApp();
	
    }
    public void clickBack() {
	driver.navigate().back();	
	
    }
    public void verifyAppState() {
   		
	System.out.println(((InteractsWithApps) driver).queryAppState(Globals.androidAppPackage));
       }
    public void closeApp() {
        ((InteractsWithApps) driver).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) driver).launchApp();
    }
}
