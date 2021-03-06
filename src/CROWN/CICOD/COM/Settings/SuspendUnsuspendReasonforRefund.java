package CROWN.CICOD.COM.Settings;

import CROWN.Base.TestBase;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class SuspendUnsuspendReasonforRefund extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_REASON_FOR_REFUND() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Settings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SystemSettings_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ReasonforRedund_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("rActionBTN_XPATH","Act_TEXT",60);

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("rsusend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();
        test.log(Status.PASS, "Reason for Refund was suspended successfully");

        javaScriptUtil.DoscrolltoViewClickWhenReady("rActionBTN_XPATH","Act_TEXT",60);

        Thread.sleep(2000);
        WebElement elementz = driver.findElement(By.xpath(Utility.fetchLocator("rUnsuspend_XPATH")));
        JavascriptExecutor jsz = (JavascriptExecutor) driver;
        jsz.executeScript("arguments[0].click();", elementz);

        driver.switchTo().alert().accept();
        test.log(Status.PASS, "Reason for Refund was Unsuspended successfully");
    }
}
