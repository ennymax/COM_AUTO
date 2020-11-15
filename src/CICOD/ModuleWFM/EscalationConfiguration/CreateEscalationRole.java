package CICOD.ModuleWFM.EscalationConfiguration;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.TabHandle;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateEscalationRole extends TestBase {

    @Test
    public void CREATE_ESCALATION_ROLE() throws IOException, InterruptedException {
        test = extent.createTest("CREATE ESCALATION ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        Randomstuff randomStuff = new Randomstuff();

        login.LoginPremium();

        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationMainMenue_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationTorole_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewEscalationTorole_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("EscalationRoleName_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.ListRandom());

        driver.findElement(By.xpath(Utility.fetchLocator("EscalationRoleDiscription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateEscalationBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AlertMessage_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Escalation was Created");
        } else {
            test.log(Status.FAIL, "Create Escalation failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
    }
}
