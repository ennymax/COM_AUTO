package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class Make_Payment_Without_Login_Prepaid_By_Card extends TestBase {

    @Test
    public void PAYMENT_WITHOUT_LOGIN_BANK_TRANSFER_PREPAID() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("BuyToken_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("prepaidPayByCard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("PostPaidEnterAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("PpAccountNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContinueAccountNumber_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("PemailEKE_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidMakePayment_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ConfirmPaymentPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Confirmation page was displayed");
        } else {
            test.log(Status.FAIL, "Comfirmation Page wasnt dispalyed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreePaymemtCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();
    }
}
