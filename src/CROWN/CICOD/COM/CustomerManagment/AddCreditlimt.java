package CROWN.CICOD.COM.CustomerManagment;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddCreditlimt extends TestBase {
    @Test
    public void ADD_CREDIT_LIMIT() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        JavaScriptUtil actionsClass = new JavaScriptUtil(driver);
        Login login = new Login(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Customermanagmentbtn_XPATH", "Commana_TEXT",60);
        actionsClass.DoscrolltoViewClickWhenReady("CreditLimi_XPATH","creditlimit_TEXT",60);
        assertion.DoAssertContainsWhenReady("AssertViewCreditLimi_XPATH","assertcredit_TEXT","creditpass_TEXT","creditfail_TEXT",60);
        utility.DoclickWhenReady("AddCreditLimiBTN_XPATH", "ClickCredti_TEXT",60);
        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstname_TEXT","CustomerFirstname_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("AssertCreditSearchbyName_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter_XPATH", "CredtSel_TEXT",60);

        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);
        actionsClass.DoscrolltoViewClickWhenReady("RemoveCCC_XPATH","Remove_TEXT",60);

        utility.DoSendKeysWhenReady("SeaerchInputC_XPATH","CustomerFirstnam_TEXT","CustomerFirstnam_TEXT",60);
        utility.DoclickWhenReady("SearchBTNC_XPATH","Se_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Creditselecter33_XPATH","credpass_TEXT","crditfail_TEXT",60);
        utility.DoclickWhenReady("Creditselecter33_XPATH", "CredtSel_TEXT",60);


        utility.DoSendKeysWhenReady("CreditAmt_XPATH","AM_TEXT","AM_TEXT",60);
        utility.DoclickWhenReady("AddlimitBTN_XPATH","Addl_TEXT",60);
        utility.DowaitandAcceptAlerwhenReady(60);
        assertion.DoAssertContainsWhenReady("AssertCreditlimitCreation_XPATH","Contcc_TEXT","AssertCreditlimitCreationpass_TEXT","AssertCreditlimitCreationfail_TEXT",60);

    }
}