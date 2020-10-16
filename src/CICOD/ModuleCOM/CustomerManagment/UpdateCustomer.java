package CICOD.ModuleCOM.CustomerManagment;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
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

public class UpdateCustomer extends TestBase {

    @Test
    public void UPDATE_CUSTOMER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE CUSTOMER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        int tom = rn.nextInt(8) + 1;
        int tomm = rn.nextInt(30) + 1;
        int tommm = rn.nextInt(10) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();
        screenshot.ScreenShot();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("UpdateCustoo_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement ch = driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH")));
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].scrollIntoView();", ch);
        ch.clear();
        ch.sendKeys(randomstuff.ListRandom());

        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH")));
        tt.clear();
        tt.sendKeys(randomstuff.ListRandom());

        WebElement ttt = driver.findElement(By.xpath(Utility.fetchLocator("CLandMark_XPATH")));
        ttt.clear();
        ttt.sendKeys(randomstuff.ListRandom());

        WebElement tttt = driver.findElement(By.xpath(Utility.fetchLocator("ChouseN_XPATH")));
        tttt.clear();
        tttt.sendKeys(Utility.fetchLocator("h_TEXT")+ a );

        WebElement ttk = driver.findElement(By.xpath(Utility.fetchLocator("CHouseNo_XPATH")));
        ttk.clear();
        ttk.sendKeys(Utility.fetchLocator("h_TEXT")+ aa );

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("Country_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByVisibleText("Nigeria");

        Thread.sleep(1000);
        WebElement ele111jm = driver.findElement(By.xpath(Utility.fetchLocator("Cstate_XPATH")));
        Select sel11jm = new Select(ele111jm);
        sel11jm.selectByIndex(tomm);

        Thread.sleep(1000);
        WebElement ele111jn = driver.findElement(By.xpath(Utility.fetchLocator("MarchantState_XPATH")));
        Select sel11jn = new Select(ele111jn);
        sel11jn.selectByIndex(tommm);

        Thread.sleep(1000);
        WebElement ele111jj = driver.findElement(By.xpath(Utility.fetchLocator("Clga_XPATH")));
        Select sel11jj = new Select(ele111jj);
        sel11jj.selectByIndex(tommm);

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("Csave_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("cccg_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Customer updated")) {
            test.log(Status.PASS, "Customer Updated Successfully");
        } else {
            test.log(Status.FAIL, "Customer Update failed");
        }

        System.out.println("********************UPDATE CUSTOMER********************");
        driver.quit();
    }

}