package CICOD.ModuleCICOD;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import org.testng.annotations.Test;
import java.io.IOException;

public class SessionTimeOutTest extends TestBase {
    @Test
    public void SessionTimeOut() throws IOException, InterruptedException {
        test = extent.createTest("SESSION TIMEOUT");
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        Thread.sleep(3000);
        utility.DoAssertTittle("TittleBF_TEXT","BFPass_TEXT","BFFail_TEXT");

        login.Login();

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleAF_TEXT","AFPass_TEXT","AFFail_TEXT");

        Thread.sleep(60000);
        Thread.sleep(3600000);
        utility.DoAssertTittle("TittleBF_TEXT","BFPass_TEXT","BFFail_TEXT");
    }
}