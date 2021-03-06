package CROWN.CICOD.COM.ProductManagement;

import CROWN.Base.TestBase;
import CROWN.utility.FileUpload;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class ADD_PRODUCT extends TestBase {

    @Test
    public void ADD_PRODUCTs() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(9) + 1;
        int a = rn.nextInt(60000) + 1;
        FileUpload fileUpload = new FileUpload();

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11o = driver.findElement(By.xpath(Utility.fetchLocator("Productbtn_XPATH")));
        JavascriptExecutor jseo = (JavascriptExecutor) driver;
        jseo.executeScript("arguments[0].scrollIntoView();", ti11o);
        ti11o.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Add_Producttn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement menuOption1 = driver.findElement(By.xpath(Utility.fetchLocator("CreateProductpageassert_XPATH")));
        String aaa = menuOption1.getText();
        if (aaa.contains("Create Form")) {
            test.log(Status.PASS, "Page to add product has been opened");
        } else {
            test.log(Status.PASS, "Add product Page cant be opened");
        }

        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(By.xpath(Utility.fetchLocator("SelectProductCategory_XPATH")));
        Select sel = new Select(ele1);
        sel.selectByIndex(st);

        driver.findElement(By.xpath(Utility.fetchLocator("ProductNamei_XPATH"))).sendKeys(randomstuff.ListRandom());
        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscriptioni_XPATH"))).sendKeys(Utility.fetchLocator("ProductDiscription_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UploadProductIMG_XPATH"))).click();

        fileUpload.UploadFileImage3MB();
        Thread.sleep(6000);
        test.log(Status.PASS, "Upload was successful");

        driver.findElement(By.xpath(Utility.fetchLocator("ProductCode_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + a + a );
        driver.findElement(By.xpath(Utility.fetchLocator("ProductPrize_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + a );
        driver.findElement(By.xpath(Utility.fetchLocator("AddToworkshoptCheckBox_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ReservationDays_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + st );
        driver.findElement(By.xpath(Utility.fetchLocator("NoQuantityLimitCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Vat_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("isave_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertProductCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Product created successfully")) {
            test.log(Status.PASS, "Product was added successfully successful");
        } else {
            test.log(Status.FAIL, "Add Product Failed");
        }
    }
}