package CROWN.CICOD.WFM.Pages;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssertQueueType extends TestBase {

    @Test
    public void ASSERT_QUEUE_TYPE() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWalkThrough_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Walk through is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Walk through is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalrecords_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total records is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total records is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalActive_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total active is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total active is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSuspended_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Suspended is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Suspended is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("PageBar_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Page bar is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Page bar is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProductToggler_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product toggle is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Product toggle is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUsename_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Username is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Username is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertHeader_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Header is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Header is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpWiz_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp Wizard is displayed and enabled");
        } else {
            test.log(Status.FAIL, "SetUp Wizard is not displayed and enabled");
        }
    }
}
