package com.Module.ValueChain;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
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

public class RequestValueChainUser extends TestBase {

    @Test
    public void REQUEST_VALUE_CHAIN_USER() throws IOException, InterruptedException {
        test = extent.createTest("REQUEST VALUE CHAIN USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

        login.LoginDefault();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RequestBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("InputSearchMarchant_XPATH"))).sendKeys(Utility.fetchLocator("ShopSearch_TEXT"));

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchBTNMACHANT_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgl =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("MerchantName_XPATH"))));
        String textl = msgl.getText();
        if (msgl.isEnabled() && textl.contains("lupinwilliams")) {
            test.log(Status.PASS, "Merchant name was displayed");
        } else {
            test.log(Status.FAIL, "Failed to display Merchant Name");
        }

        Thread.sleep(1000);
        WebElement msgk =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("MerchantID_XPATH"))));
        String textk = msgk.getText();
        if (msgk.isEnabled() && textk.contains("lupinwilliams")) {
            test.log(Status.PASS, "Merchant ID was displayed");
        } else {
            test.log(Status.FAIL, "Failed to display Merchant ID");
        }

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("BizzSext_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Others")) {
            test.log(Status.PASS, "Merchant Business Sector was displayed");
        } else {
            test.log(Status.FAIL, "Failed to display Merchant Business Sector");
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SendRequestBTN_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgm =(new WebDriverWait(driver, 25)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertRequestSent_XPATH"))));
        String textm = msgm.getText();
        if (msgm.isEnabled() && textm.contains("Request Sent")) {
            test.log(Status.PASS, "Request was sent Successfully");
        } else {
            test.log(Status.FAIL, "Failed to send Request");
        }


        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        Thread.sleep(2000);
        login.Loginlupin();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RequestBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ReActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RejectActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ReasonForReject_XPATH"))).sendKeys(Utility.fetchLocator("Re_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DeclineBTN_XPATH"))).click();

        Thread.sleep(1000);
        screenshot.ScreenShotFullPage();
        WebElement msgo =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertDecline_XPATH"))));
        String texto = msgo.getText();
        if (msgo.isEnabled() && texto.contains("Declined Successfully")) {
            test.log(Status.PASS, "Decline was successful");
        } else {
            test.log(Status.FAIL, "Decline Failed");
        }

        System.out.println("********************REQUEST VALUE CHAIN USER********************");
        driver.quit();
    }

}
