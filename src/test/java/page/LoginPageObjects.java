package page;

import java.io.IOException;
import java.util.Properties;

import utilities.Globals;
import utilities.ReadProperties;

public class LoginPageObjects {

    public  String TitleLbl = "";
    public String DescrptnLbl = "";
    public String CntryCdeDrpDwn = "";
    public String CntrySrchTxtFld = "";
    public String CntryDrpDwnVal = "";
    public String CntnueBttn = "";
    public String PhneNmbrTxtFld = "";
    public String InvldPhnErrLbl = "";
    public String OTPTitleLbl = "";
    public String OTPnvldTknErrLbl = "";
    public String OTPTknTxtBx1 = "";
    public String OTPTknTxtBx2 = "";
    public String OTPTknTxtBx3 = "";
    public String OTPTknTxtBx4 = "";
    public String OTPTknErrLdngTxt = "";
    public String OTPSuccessLbl = "";
    public static Properties Andrdprprts = new Properties();
    public static Properties iOSPrprts = new Properties();
    
    public LoginPageObjects  LoginPageObjectsInitialize() throws IOException {
	
	if (Globals.platformName.equals("Android")) {
	    try {
		Andrdprprts = new ReadProperties().getProps("AndroidLocator.properties");

	    } catch (Exception e) {

		e.printStackTrace();
	    }	 
	    
	    TitleLbl = Andrdprprts.getProperty("TitleLbl");
	    DescrptnLbl = Andrdprprts.getProperty("DescrptnLbl");
	    CntryCdeDrpDwn = Andrdprprts.getProperty("CntryCdeDrpDwn");
	    CntrySrchTxtFld = Andrdprprts.getProperty("CntrySrchTxtFld");
	    CntryDrpDwnVal = Andrdprprts.getProperty("CntryDrpDwnVal");
	    CntnueBttn = Andrdprprts.getProperty("CntnueBttn");
	    PhneNmbrTxtFld = Andrdprprts.getProperty("PhneNmbrTxtFld");
	    InvldPhnErrLbl = Andrdprprts.getProperty("InvldPhnErrLbl");
	    OTPTitleLbl = Andrdprprts.getProperty("OTPTitleLbl");
	    OTPnvldTknErrLbl = Andrdprprts.getProperty("OTPnvldTknErrLbl");
	    OTPTknTxtBx1 = Andrdprprts.getProperty("OTPTknTxtBx1");
	    OTPTknTxtBx2 = Andrdprprts.getProperty("OTPTknTxtBx2");
	    OTPTknTxtBx3 = Andrdprprts.getProperty("OTPTknTxtBx3");
	    OTPTknTxtBx4 = Andrdprprts.getProperty("OTPTknTxtBx4");
	    OTPTknErrLdngTxt = Andrdprprts.getProperty("OTPTknErrLdngTxt");
	    OTPSuccessLbl = Andrdprprts.getProperty("OTPSuccessLbl");

	}

	if (Globals.platformName.equals("iOS")) {
	    Properties iOSPrprts =new Properties();
	    try {
		iOSPrprts = new ReadProperties().getProps("iOSLocator.properties");

	    } catch (Exception e) {

		e.printStackTrace();
	    }
	    TitleLbl = iOSPrprts.getProperty("TitleLbl");
	    DescrptnLbl = iOSPrprts.getProperty("DescrptnLbl");
	    CntryCdeDrpDwn = iOSPrprts.getProperty("CntryCdeDrpDwn");
	    CntrySrchTxtFld = iOSPrprts.getProperty("CntrySrchTxtFld");
	    CntryDrpDwnVal = iOSPrprts.getProperty("CntryDrpDwnVal");
	    CntnueBttn = iOSPrprts.getProperty("CntnueBttn");
	    PhneNmbrTxtFld = iOSPrprts.getProperty("PhneNmbrTxtFld");
	    InvldPhnErrLbl = iOSPrprts.getProperty("InvldPhnErrLbl");
	    OTPTitleLbl = iOSPrprts.getProperty("OTPTitleLbl");
	    OTPnvldTknErrLbl = iOSPrprts.getProperty("OTPnvldTknErrLbl");
	    OTPTknTxtBx1 = iOSPrprts.getProperty("OTPTknTxtBx1");
	    OTPTknTxtBx2 = iOSPrprts.getProperty("OTPTknTxtBx2");
	    OTPTknTxtBx3 = iOSPrprts.getProperty("OTPTknTxtBx3");
	    OTPTknTxtBx4 = iOSPrprts.getProperty("OTPTknTxtBx4");
	    OTPTknErrLdngTxt = iOSPrprts.getProperty("OTPTknErrLdngTxt");
	    OTPSuccessLbl = iOSPrprts.getProperty("OTPSuccessLbl");
	}
	return this;
    }
    
}
