package CROWN.CICOD.WFM.SheduleManagement;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class CreateResourseShedule extends TestBase {

    @Test
    public void CREATE_RESOURCE_SCHEDULE() throws IOException, InterruptedException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(150000) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ScheduelManagment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SheduleRecordBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewSheduleManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SheduleName_XPATH"))).sendKeys(Utility.fetchLocator("TeamName_TEXT") + tom );

        WebElement ele11l = driver.findElement(By.xpath(Utility.fetchLocator("Monday_XPATH")));
        Select sel1l = new Select(ele11l);
        sel1l.selectByIndex(3);

        WebElement ele11l2 = driver.findElement(By.xpath(Utility.fetchLocator("Tuesday_XPATH")));
        Select sel1l2 = new Select(ele11l2);
        sel1l2.selectByIndex(3);

        WebElement ele11l3 = driver.findElement(By.xpath(Utility.fetchLocator("Wednesday_XPATH")));
        Select sel1l3 = new Select(ele11l3);
        sel1l3.selectByIndex(3);

        WebElement ele11l4 = driver.findElement(By.xpath(Utility.fetchLocator("Thursday_XPATH")));
        Select sel1l4 = new Select(ele11l4);
        sel1l4.selectByIndex(3);

        WebElement ele11l5 = driver.findElement(By.xpath(Utility.fetchLocator("Friday_XPATH")));
        Select sel1l5 = new Select(ele11l5);
        sel1l5.selectByIndex(1);

        WebElement ele11l6 = driver.findElement(By.xpath(Utility.fetchLocator("Saturday_XPATH")));
        Select sel1l6 = new Select(ele11l6);
        sel1l6.selectByIndex(3);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ShiftCreateBtn"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertResourceCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Resource Schedule Created Successfully");
        } else {
            test.log(Status.FAIL, "Resource Schedule Can't be created");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN3_XPATH"))).click();
    }
}
