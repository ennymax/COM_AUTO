package CICOD.ModuleCOM.ValueChain;

import CICOD.base.TestBase;
import CICOD.utility.BrokenLink;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class Suspend_UnSuspendBuyer extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_BUYER() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND BUYER VALUE CHAIN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainByers_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductAvailableForBuy_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoo =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertProductCode_XPATH"))));
        String textoo = msgoo.getText();
        if (msgoo.isEnabled() && textoo.contains("T74623454")) {
            test.log(Status.PASS, "Products Of the Supplier Is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Product Of Buyers is not displayed and enabled");
        }

        driver.navigate().back();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendBuyer_XPATH"))).click();

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.LoginDefault();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("Suppliers_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoomm =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuspended_XPATH"))));
        String textoomm = msgoomm.getText();
        if (msgoomm.isEnabled() && textoomm.contains("Access Suspended")) {
            test.log(Status.PASS, "Access Suspended was Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainByers_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductAvailableForBuy_XPATH"))).click();

        driver.navigate().back();

        Thread.sleep(2000);
        WebElement ti11p = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jsep = (JavascriptExecutor) driver;
        jsep.executeScript("arguments[0].scrollIntoView();", ti11p);
        ti11p.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendBuyer_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoommm =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUnsuspension_XPATH"))));
        String textoommm = msgoommm.getText();
        if (msgoommm.isEnabled() && textoommm.contains("Unsuspended Merchant Successfully.")) {
            test.log(Status.PASS, "Unsuspension was Successful");
        } else {
            test.log(Status.FAIL, "UnSuspension Failed");
        }

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.LoginDefault();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("Suppliers_XPATH"))).click();

        /*
        Thread.sleep(100000000);
        WebElement msgoommmm =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuspended_XPATH"))));
        String textoommmm = msgoommmm.getText();
        if (msgoommmm.isEnabled() && textoommmm.contains("Access Suspended")) {
            test.log(Status.PASS, "Access Suspended was Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }
        */

        System.out.println("********************SUSPEND UNSUSPEND BUYER********************");
        driver.quit();
    }
}