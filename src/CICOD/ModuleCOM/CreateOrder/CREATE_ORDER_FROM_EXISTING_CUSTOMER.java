package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
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
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CREATE_ORDER_FROM_EXISTING_CUSTOMER extends TestBase {

    @Test
    public void CREATE_ORDER_FROM_EXISTING_CUSTOMERS() throws IOException, InterruptedException {
        test = extent.createTest("CREATE ORDER FROM EXISTING CUSTOMER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");
        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();


        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();


        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();

        ravePay.RavePay2();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Auth_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Enter your 4-digit card pin to authorize this payment")) {
            test.log(Status.PASS, "Flutterwave Payment Portal Fully Functional");
        } else {
            test.log(Status.FAIL, "Payment Portal down");
        }

        System.out.println("********************CREATE ORDER FROM EXISTING CUSTOMER TEST SUCCESSFULLY IS COMPLETED********************");
        driver.quit();
    }
}