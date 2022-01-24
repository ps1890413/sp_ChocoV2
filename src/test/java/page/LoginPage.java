package page;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;

import io.appium.java_client.AppiumDriver;
import utilities.DriverManager;
import utilities.Logs;

public class LoginPage extends BasePage {

    // Not able to use PageFactory Method because of BUG -(https://github.com/appium/java-client/issues/1619)
    // @iOSXCUITFindBy(accessibility = "button_login")
    // @AndroidFindBy(id = "app.choco.dummyqa:id/title")
    // private MobileElement IdLgnPgTitleLbl;

    LoginPageObjects LoginPage;

    public LoginPage(AppiumDriver driver) {
	super(driver);
	try {
	    LoginPage = new LoginPageObjects().LoginPageObjectsInitialize();
	} catch (IOException e) {

	    e.printStackTrace();
	}
    }

    public LoginPage VerifyLoginScreen() {
	IsVisibleById(LoginPage.TitleLbl);
	IsVisibleById(LoginPage.DescrptnLbl);
	IsVisibleById(LoginPage.CntryCdeDrpDwn);
	IsVisibleById(LoginPage.PhneNmbrTxtFld);
	IsVisibleById(LoginPage.CntnueBttn);
	IsEnabledById(LoginPage.CntryCdeDrpDwn);
	IsEnabledById(LoginPage.CntnueBttn);
	return this;
    }

    public LoginPage entercountrycode(String country) {

	click(LoginPage.CntryCdeDrpDwn);
	sendKeysById(LoginPage.CntrySrchTxtFld, country);
	click(LoginPage.CntryDrpDwnVal);
	return this;
    }

    public LoginPage enterphonenumber(String phonenumber) {

	clear(LoginPage.PhneNmbrTxtFld);
	sendKeysById(LoginPage.PhneNmbrTxtFld, phonenumber);
	System.out.println("enterphonenumber - PASS");
	return this;
    }

    public LoginPage VerifyinvalidphonenumbererrorPresent(String errormessage) {
	if (errormessage == "That phone number isn’t valid, are you sure you entered it correctly?") {
	    int len = getText(LoginPage.InvldPhnErrLbl).length();
	    String actualerror = getText(LoginPage.InvldPhnErrLbl).substring(0, 21)
		    + getText(LoginPage.InvldPhnErrLbl).substring(22, len);
	    errormessage = errormessage.replace("�", "");
	    assertEquals(errormessage, actualerror);
	    RefreshAPP();

	}
	if (errormessage == "The code you entered was incorrect, are you sure you entered it correctly?") {
	    
	    assertEquals(getText(LoginPage.OTPnvldTknErrLbl), errormessage);
	}
	return this;
    }

    public LoginPage clickcontinue() {

	System.out.println("clickcontinue - Start");
	click(LoginPage.CntnueBttn);

	return this;
    }

    public LoginPage VerifyAuthScreen() {

	waitUntilVisibileByXpath(LoginPage.OTPTitleLbl);
	waitUntilVisibileByXpath(LoginPage.OTPTknTxtBx1);
	waitUntilVisibileByXpath(LoginPage.OTPTknTxtBx2);
	waitUntilVisibileByXpath(LoginPage.OTPTknTxtBx3);
	waitUntilVisibileByXpath(LoginPage.OTPTknTxtBx4);
	return this;
    }

    public LoginPage userclickBack() {

	clickBack();

	return this;
    }

    public LoginPage comparePhoneNumVal(String val) {

	assertEquals(getText(LoginPage.PhneNmbrTxtFld), val);
	return this;
    }

    public LoginPage compareCountryCdeVal(String val) {

	assertEquals(getText(LoginPage.CntryCdeDrpDwn), val);

	return this;
    }

    public LoginPage enterotp(String string) {
	
	String[] tempotp = string.split("");
	sendKeysByXpath(LoginPage.OTPTknTxtBx1,tempotp[0] );
	sendKeysByXpath(LoginPage.OTPTknTxtBx2, tempotp[1]);
	sendKeysByXpath(LoginPage.OTPTknTxtBx3,tempotp[2] );
	sendKeysByXpath(LoginPage.OTPTknTxtBx4,tempotp[3] );
	return this;
    }
   
    public LoginPage VerifyWelcomeScreen(String string) {
		
	assertEquals(waitUntilVisibileByXpath(LoginPage.OTPSuccessLbl).getText(), string);
	try {
	    Thread.sleep(3500);
	} catch (InterruptedException e) {
	    
	    e.printStackTrace();
	}
	return this;
    }
}
