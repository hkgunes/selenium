package tr.com.demoApp.e2e.demoe2e.config;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableConfigurationProperties(AppProperties.class)
public class TestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    public WebDriver webDriver;


    @Autowired
    private AppProperties appProperties;


    @BeforeSuite(alwaysRun = true)
    @BeforeTest(alwaysRun = true)
    @BeforeClass(alwaysRun=true)
    @BeforeMethod(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

    @BeforeTest
    public void setUp()   {
        webDriver.get(appProperties.getBaseUrl());
        webDriver.get(webDriver.getCurrentUrl());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

            // screenshot folder create
            String screenshotPath = "./screenshot/";
            String name = result.getName();

            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date())  + "-" + name + "-"
                        + ".png"));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }





}