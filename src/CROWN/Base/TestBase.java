package CROWN.Base;

import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.XmlSuite;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.ITestResult.SUCCESS;

public class TestBase {

    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    private static final String OUTPUT_FOLDER = "./Report/";
    private static final String FILE_NAME = "Report" + System.currentTimeMillis() + ".html";
    public int Passed;
    public int Failed;
    public int Skipped;


    @BeforeSuite
    public void setup() throws IOException {

        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);

        htmlReporter.config().setDocumentTitle(Utility.fetchProperty("ProjectName").toString());
        htmlReporter.config().setReportName(Utility.fetchProperty("Tname").toString());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("TesterName", Utility.fetchProperty("Tname").toString());
        extent.setSystemInfo("OS", "Window10");
        extent.setSystemInfo("Browser", Utility.fetchProperty("browserName").toString());
    }

    @BeforeClass
    public void setUp() throws IOException {
        if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new ChromeDriver();
            } else {
                ChromeOptions options = new ChromeOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new FirefoxDriver();
            } else {
                FirefoxOptions options = new FirefoxOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new FirefoxDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteFirefox")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);

            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteChrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);


            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please pass the correct browser name....");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);


        if (Utility.fetchProperty("Project").toString().equalsIgnoreCase("CICOD")) {

            if (Boolean.parseBoolean(Utility.fetchProperty("CICODPROD").toString())) {
                driver.get(Utility.fetchProperty("applicationUrlCICODPROD").toString());
            } else {
                driver.get(Utility.fetchProperty("applicationUrlCICODSTAGGING").toString());
            }
        }
        else if(Utility.fetchProperty("Project").toString().equalsIgnoreCase("EKEDC")){

            if (Boolean.parseBoolean(Utility.fetchProperty("EKEDCPROD").toString())) {
                driver.get(Utility.fetchProperty("applicationUrlEKEDCPROD").toString());
            } else {
                driver.get(Utility.fetchProperty("applicationUrlEKEDCSTAGGING").toString());
            }
        }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws InterruptedException{
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);

        if (result.getStatus() == ITestResult.STARTED) {
            System.out.println("***************************" + methodName + " started!************************************");
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
            extentTest.assignCategory(result.getTestContext().getSuite().getName());
            extentTest.assignCategory(className);
            test = extent.createTest(result.getMethod().getMethodName().toLowerCase());
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + " The Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
            System.out.println("***************************Failed********************* " + (result.getMethod().getMethodName() + " ********************Failed******************"));
            System.out.println("***************************Failed********************* " + getTime(result.getEndMillis()) + " ********************Failed******************");

        } else if (result.getStatus() == SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + " The Test Case Passed", ExtentColor.GREEN));
            System.out.println("***************************Passed********************* " + (result.getMethod().getMethodName() + " ********************Passed******************"));
            System.out.println("***************************Passed********************* " + getTime(result.getEndMillis()) + " ********************Passed******************");
            test.getModel().setEndTime(getTime(result.getEndMillis()));
            Passed++;

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(MarkupHelper.createLabel(result.getName() + " The Test Case Skipped", ExtentColor.YELLOW));
            System.out.println("***************************Skipped********************* " + (result.getMethod().getMethodName() + " ********************Skipped******************"));
            System.out.println("***************************Skipped********************* " + getTime(result.getEndMillis()) + " ********************Skipped******************");

        }

        extent.flush();
    }

    public void SendReport(String RecipientEmail) throws IOException {
        String to = Utility.fetchProperty("HostEmail").toString();
        String from = Utility.fetchProperty(RecipientEmail).toString();

        final String username = Utility.fetchProperty("HostEmail").toString();
        final String password = Utility.fetchProperty("HostPassword").toString();

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject("Testing Subject");
            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent("<h1>"+ Utility.fetchProperty("EmailTopic").toString() +"</h1>", "text/html");

            BodyPart messa = new MimeBodyPart();
            messa.setText(Utility.fetchProperty("MessageBody").toString());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            File filename = getTheNewestFile(System.getProperty("user.dir") + "\\Report\\","html");
            String nsme = "CicodReport";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(nsme);
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messa);
            message.setContent(multipart);

            System.out.println("*************************************Sending Report******************************************");
            Transport.send(message);
            System.out.println("****************************************Done***************************************************");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public File getTheNewestFile(String filePath, String ext) {
        File theNewestFile = null;
        File dir = new File(filePath);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

        assert files != null;
        if (files.length > 0) {

            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            theNewestFile = files[0];
        }

        return theNewestFile;
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    @BeforeMethod
    public void TestName(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName().toUpperCase());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }


    @AfterSuite(alwaysRun=true)
    public void AfterTest() throws IOException {

        if (Boolean.parseBoolean(Utility.fetchProperty("SendReport").toString())) {

            SendReport("Ecicod");
            SendReport("yahoo");
        } else {

            SendReport("gmail");
        }

    }
}
