package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;

public class ContinueSavedOrder extends TestBase {

    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Test(priority = 3)
    public void CreateOrder() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Createorderbtn_XPATH", 30);
    }

    @Test(priority = 4)
    public void ViewSavedOrder() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("ViewSavedOrer_XPATH", "ViewSa_TEXT",40);
        utility.DoclickWhenReady("SelectOre11_XPATH", "ViewSa_TEXT",40);
    }

    @Test(priority = 5)
    public void AssertViewSavedOrder() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertAlert_XPATH","alercon_TEXT","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","ASERTORE_XPATH","SOFail_TEXT",60);
    }

    @Test(priority = 6)
    public void SelectRegion() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Test(priority = 7)
    public void MakePayment() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();
    }

    @Test(priority = 8)
    public void RavPay() throws IOException, InterruptedException {
        RavePay ravePay = new RavePay(driver);
        ravePay.RavePay2();
    }

    @Test(priority = 9)
    public void AssertPayOnline() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Auth_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Enter your 4-digit card pin to authorize this payment")) {
            test.log(Status.PASS, "Flutterwave Payment Portal Fully Functional");
        } else {
            test.log(Status.FAIL, "Payment Portal down");
        }
    }

    @Test(priority = 10)
    public void NavigteURL() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.get("https://nexusnigeria.cicod.com/cuorma/web/index.php/site/order-product?inv_search_text=Tomatoes");
    }

    @Test(priority = 11)
    public void ViewSavedOrderPOS() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        javaScriptUtil.DoscrolltoViewClickWhenReady("ViewSavedOrer_XPATH", "ViewSa_TEXT",40);
        utility.DoclickWhenReady("SelectOre11_XPATH", "ViewSa_TEXT",40);
    }

    @Test(priority = 12)
    public void AssertViewSavedOrderPOS() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertContainsWhenReady("AssertAlert_XPATH","alercon_TEXT","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","SOpass_TEXT","SOFail_TEXT",60);
        assertion.DoAssertXpathPresentWhenReady("Ooo_XPATH","ASERTORE_XPATH","SOFail_TEXT",60);
    }

    @Test(priority = 13)
    public void SelectRegionPOS() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("jjregion_XPATH", 30);
        util.DoSelectValuesByIndex("SelectRegion_XPATH", 2, 20);
    }

    @Test(priority = 14)
    public void MakePaymentPOS() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();
    }

    @Test(priority = 15)
    public void POS() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();
    }

    @Test(priority = 16)
    public void AssertPOS() throws IOException, InterruptedException {
        Thread.sleep(200);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Payment yet to be received on Order")) {
            test.log(Status.PASS, "Pay with POS Functional");
        } else {
            test.log(Status.FAIL, "Pay with POS Failed");
        }
    }
}