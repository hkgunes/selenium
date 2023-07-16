package tr.com.demoApp.e2e.demoe2e.module;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;
import tr.com.demoApp.e2e.demoe2e.config.TestBase;
import tr.com.demoApp.e2e.demoe2e.util.ElementUtil;
import tr.com.demoApp.e2e.demoe2e.util.LogUtil;
import tr.com.demoApp.e2e.demoe2e.util.ModalUtil;
import tr.com.demoApp.e2e.demoe2e.util.WaitUtil;

import java.io.IOException;

@Service
@Slf4j
public class HomePage_1 extends TestBase {

    @Autowired
    private ElementUtil elementUtil;
    @Autowired
    private WebDriver driver;

    @Autowired
    private WaitUtil waitUtil;
    @Autowired
    private ModalUtil modalUtil;






    @Test
    public void homePageCheck() {

        driver.findElement(By.id("wt-cli-accept-all-btn")).click();
        Assert.assertTrue(driver.getTitle().contains("Insider"));



    }
}
