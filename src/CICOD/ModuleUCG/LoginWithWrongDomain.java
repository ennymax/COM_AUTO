package CICOD.ModuleUCG;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithWrongDomain extends TestBase {

    @Test
    public void LOGIN_WITH_WRONG_DOMAIN() throws IOException, InterruptedException {
        test = extent.createTest("LOGIN WITH WRONG DOMAIN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginWrongDomainName();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInvalidEmailOrPassword_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful FAILED");
        } else {
            test.log(Status.FAIL, "Login Successful");
        }

        driver.quit();
        System.out.println("********************LOGIN WITH WRONG DOMAIN********************");
    }
}