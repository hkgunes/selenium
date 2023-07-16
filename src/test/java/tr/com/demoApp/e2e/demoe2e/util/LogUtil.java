package tr.com.demoApp.e2e.demoe2e.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.testng.Assert;

@Slf4j
@Service
public class LogUtil {

    public static void assertFail(String errMsg) {
        printErrorMsgToConsole(errMsg);
        Assert.fail(errMsg);
    }

    public static void assertTrue(boolean real, String msg) {
        Assert.assertTrue(real, msg);
    }

    public static void assertFalse(boolean real, String msg) {
        Assert.assertFalse(real, msg);
    }

    public static void printErrorMsgToConsole(String errMsg) {
        log.error(errMsg);
    }

    public static void printInfoMsgToConsole(String errMsg) {
        log.info(errMsg);
    }

    public static void printWarnMsgToConsole(String msg) {
        log.warn(msg);
    }
}
