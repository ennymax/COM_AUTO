package CROWN.CICOD.UCG;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchAllCollectionWithCorrectCredentila extends TestBase {

    @Test
    public void SEARCH_ALL_COLLECTION_WITH_CORRECT_CREDENTIALS() throws IOException, InterruptedException {
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(1200);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1200);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionBTN_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "All Collection Page Displayed");
        } else {
            test.log(Status.FAIL, "All Collection Page not Displayed");
        }

        Thread.sleep(1200);
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("TransactionID_TEXT"));

        Thread.sleep(1000);
        WebElement elementPP = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPP = (JavascriptExecutor) driver;
        jsPP.executeScript("arguments[0].click();", elementPP);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOluwaseun_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By Transaction ID Successful");
        } else {
            test.log(Status.FAIL, "Search By Transaction ID Failed");
        }

        Thread.sleep(1200);
        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        Thread.sleep(1000);
        screenShot.ScreenShot();
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("DropDown_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("INVOICE NO");

        Thread.sleep(1200);
        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("InvoicenUMBER_TEXT"));

        Thread.sleep(1000);
        screenShot.ScreenShot();
        WebElement elementPPO = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPPO = (JavascriptExecutor) driver;
        jsPPO.executeScript("arguments[0].click();", elementPPO);

        Thread.sleep(1000);
        screenShot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOluwaseun_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By Invoice Number Successful");
        } else {
            test.log(Status.FAIL, "Search By Invoice Number Failed");
        }

        Thread.sleep(1200);
        WebElement Elementlb = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsklb = (JavascriptExecutor) driver;
        jsklb.executeScript("arguments[0].scrollIntoView();", Elementlb);
    }
}
