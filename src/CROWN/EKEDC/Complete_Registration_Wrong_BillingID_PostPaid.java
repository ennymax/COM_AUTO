package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Complete_Registration_Wrong_BillingID_PostPaid extends TestBase {

    @Test
    public void COMPLETE_REG_WRONG_BILLING_POSTPAID() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login_PostPaidLandlordEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountNumberEKE_XPATH"))).sendKeys(Utility.fetchLocator("WrongAccountNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitAccountNumber_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UnableError_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Unable to validate customer was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Unable to validate was not displayed Successfully");
        }
    }
}
