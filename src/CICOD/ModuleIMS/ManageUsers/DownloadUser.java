package CICOD.ModuleIMS.ManageUsers;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.TabHandle;
import CICOD.utility.Utility;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DownloadUser extends TestBase {

    @Test
    public void DOWNLOAD_USERS() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD USERS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        Randomstuff ramdomwords = new Randomstuff();
        Randomstuff ramdomword = new Randomstuff();

        //new Generex(regex1).random();

        ramdomwords.ListRandom();
        ramdomword.ListRandom();

        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(7) + 1;
        int resourcelevel = rn.nextInt(6) + 1;

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageUserBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageUserBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertViewUser_XPATH"))).size() != 0) {
            test.log(Status.PASS, "User Could be Viewed");
        } else {
            test.log(Status.FAIL, "User could not be Viewed");
        }

        Thread.sleep(2000);
        WebElement element7 = driver.findElement(By.xpath(Utility.fetchLocator("DownloadUserBTN_XPATH")));
        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("arguments[0].click();", element7);

        Thread.sleep(7000);

        driver.quit();
        System.out.println("********************DOWNLOAD USERS********************");
    }
}