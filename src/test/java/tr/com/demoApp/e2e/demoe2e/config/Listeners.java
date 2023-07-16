package tr.com.demoApp.e2e.demoe2e.config;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Slf4j
public class Listeners implements ITestListener {      // extends TestListenerAdapter



    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("SUCCESS : " + iTestResult.getName());
    }


    @Override
    @ExceptionHandler(IOException.class)
    public void onTestFailure(ITestResult iTestResult) {
        log.error("FAIL : " + iTestResult.getName());
        String name = iTestResult.getName();

        WebDriver webDriver = ((TestBase) iTestResult.getInstance()).webDriver;

        try {
            takeScreenshotOnFailure(webDriver,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @ExceptionHandler(IOException.class)
    public void takeScreenshotOnFailure(WebDriver webDriver,String name) throws IOException {

        File screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File destination = new File("target/failure-screenshots/" + name + "-"
                + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ".png");
        FileUtils.copyFile(screenShot, destination);

        InputStream screenShotStream = new FileInputStream(destination);
        byte[] screen = IOUtils.toByteArray(screenShotStream);

        saveScreenshot(screen);
    }


    @Attachment(value = "Screenshot of the failure", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {

        return screenShot;
    }
}
