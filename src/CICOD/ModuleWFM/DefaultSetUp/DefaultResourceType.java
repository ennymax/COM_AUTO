package CICOD.ModuleWFM.DefaultSetUp;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefaultResourceType extends TestBase {

    @Test
    public void DEFAULT_RESOURCE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("DEFAULT RESOURCE TYPE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagemnet_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageReourceType_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDIspatchRider_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Dispatch Rider is present as Default");
        } else {
            test.log(Status.FAIL, "Dispatch Rider is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogisticManager_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Logistic Manager is present as Default");
        } else {
            test.log(Status.FAIL, "Logistic Manager is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDelveryManager_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Delivery Manager is present as Default");
        } else {
            test.log(Status.FAIL, "Delivery Manager is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWareHouseManager_XPATH"))).size() != 0) {
            test.log(Status.PASS, "WareHOuse Manager is present as Default");
        } else {
            test.log(Status.FAIL, "WareHOuse Manager is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertCustomerServicesRepresentative_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Customer Services Representative is present as Default");
        } else {
            test.log(Status.FAIL, "Customer Services Representative is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSaleRepresentative_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Sale Representative is present as Default");
        } else {
            test.log(Status.FAIL, "Sale Representative is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertAccountManager_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Manager  is present as Default");
        } else {
            test.log(Status.FAIL, "Account Manager is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSalesManager_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Sales Manager is present as Default");
        } else {
            test.log(Status.FAIL, "Sales Manager is not present as Default");
        }

        driver.quit();
        System.out.println("********************DEFAULT RESOURCE TYPE********************");
    }
}