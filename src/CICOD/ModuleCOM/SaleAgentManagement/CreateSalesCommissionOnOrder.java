package CICOD.ModuleCOM.SaleAgentManagement;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateSalesCommissionOnOrder extends TestBase {
    @Test
    public void CREATE_SALE_COMMISSION_ON_ORDER() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE SALE COMMISSION ON ORDER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;
        Randomstuff randomstuff = new Randomstuff();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("com_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleManagementBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleCommissionBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateSaleCommissiontBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ComissionName_XPATH")))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("ccc_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(3000);
        WebElement ele11a = driver.findElement(By.xpath(Utility.fetchLocator("vb_XPATH")));
        Select sel1a = new Select(ele11a);
        sel1a.selectByIndex(st);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ActualValue_XPATH")))).sendKeys("45");

        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        Thread.sleep(6000);

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("mct_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Sales commission could not be created\n" + "Commission / Target Type exists")) {
            test.log(Status.PASS, "Create Sales Commission On Order Fully Functional");
        } else {
            test.log(Status.FAIL, "Create Sales Commission On Order Failed");
        }

        System.out.println("********************CREATE SALE COMMISSION ON ORDER********************");
        driver.quit();
    }
}