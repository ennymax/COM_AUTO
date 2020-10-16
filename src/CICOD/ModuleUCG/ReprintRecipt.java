package CICOD.ModuleUCG;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReprintRecipt extends TestBase {

    @Test
    public void REPRINT_RECEIPT() throws IOException, InterruptedException {
        test = extent.createTest("REPRINT RECEIPT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionBTN_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        //SEARCH WITH INVOICE NUMBER
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("DropDown_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("TRANSACTION ID");

        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("TransactionID_TEXT"));

        Thread.sleep(3000);
        WebElement elementPPO = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPPO = (JavascriptExecutor) driver;
        jsPPO.executeScript("arguments[0].click();", elementPPO);

        Thread.sleep(2000);
        WebElement Elementlb = driver.findElement(By.xpath(Utility.fetchLocator("SearchBTN_XPATH")));
        JavascriptExecutor jsklb = (JavascriptExecutor) driver;
        jsklb.executeScript("arguments[0].scrollIntoView();", Elementlb);

        Thread.sleep(3000);
        WebElement elementPPOw = driver.findElement(By.xpath(Utility.fetchLocator("ReprintBTN_XPATH")));
        JavascriptExecutor jsPPOw = (JavascriptExecutor) driver;
        jsPPOw.executeScript("arguments[0].click();", elementPPOw);

        Thread.sleep(3000);

        /*
        WebElement elementPPOwk = driver.findElement(By.xpath(Utility.fetchLocator("PrintBTN_XPATH")));
        JavascriptExecutor jsPPOwk = (JavascriptExecutor) driver;
        jsPPOwk.executeScript("arguments[0].click();", elementPPOwk);
        */

        driver.quit();
        System.out.println("********************REPRINT RECEIPT********************");
    }
}