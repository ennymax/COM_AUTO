package com.Module.Administration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UPDATEUSER extends TestBase {

    @Test
    public void UPDATE_USER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserAction_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Update_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        screenShot.ScreenShot();
        WebElement ty = driver.findElement(By.xpath(Utility.fetchLocator("RFirsteName_XPATH")));
        ty.clear();
        ty.sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));

        Thread.sleep(1000);
        WebElement tom = driver.findElement(By.xpath(Utility.fetchLocator("RLastName_XPATH")));
        tom.clear();
        tom.sendKeys(Utility.fetchLocator("CustomerLastName_TEXT"));

        Thread.sleep(1200);
        WebElement top = driver.findElement(By.xpath(Utility.fetchLocator("RPhoneNumber_XPATH")));
        top.clear();
        top.sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateUserSaveBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("yyggg_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("User Updated")) {
            test.log(Status.PASS, "User was Updated Successfully");
        } else {
            test.log(Status.FAIL, "User Updated Successfully");
        }

        Thread.sleep(5000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************UPDATE USER TEST IS COMPLETED********************");
        driver.quit();
    }
}
