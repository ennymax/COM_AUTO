package CROWN.CICOD.IMS.UpdateOfValue_I_and_QA;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class ApprovedSupply extends TestBase {

    @Test
    public void VIEW_RECEIVED_INVENTORY() throws IOException, InterruptedException {
        test = extent.createTest("VIEW RECEIVED INVENTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        SecureRandom rn = new SecureRandom();
        int role = rn.nextInt(11) + 1;
        int role1 = rn.nextInt(10) + 1;

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("IandQABTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("IandQABTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementg = driver.findElement(By.xpath(Utility.fetchLocator("InventryInspection_XPATH")));
        JavascriptExecutor jsg = (JavascriptExecutor) driver;
        jsg.executeScript("arguments[0].click();", elementg);

        Thread.sleep(2000);
        WebElement elementb = driver.findElement(By.xpath(Utility.fetchLocator("ViewInspectinventry_XPATH")));
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        jsb.executeScript("arguments[0].click();", elementb);

        Thread.sleep(2000);

        driver.quit();
        System.out.println("********************VIEW RECEIVED INVENTORY********************");
    }
}
