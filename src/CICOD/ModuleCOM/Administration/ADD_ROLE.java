package CICOD.ModuleCOM.Administration;

import CICOD.base.TestBase;
import CICOD.utility.*;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ADD_ROLE extends TestBase {

    @Test
    public void Add_Role() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ADD ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        ScreenShot screenShot = new ScreenShot(driver);
        ClickAll clickAll = new ClickAll(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddRolebtn_XPATH"))).click();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleName_XPATH"))).sendKeys(randomstuff.ListRandom());

        clickAll.ClickAll("aa_CLASS");

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("Roleaa_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AlertRoleSSS_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Role Saved")) {
            test.log(Status.PASS, "ROle has been Added Successfully");
        } else {
            test.log(Status.FAIL, "Fail to Add Role");
        }

        driver.quit();
    }
}
