package tr.com.demoApp.e2e.demoe2e.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;
import tr.com.demoApp.e2e.demoe2e.config.TestBase;
import tr.com.demoApp.e2e.demoe2e.util.ElementUtil;
import tr.com.demoApp.e2e.demoe2e.util.LogUtil;
import tr.com.demoApp.e2e.demoe2e.util.WaitUtil;

@Service
public class Redirects_5 extends TestBase {
    @Autowired
    private ElementUtil elementUtil;
    @Autowired
    private WaitUtil waitUtil;
    @Autowired
    private LogUtil logUtil;
    @Autowired
    private WebDriver driver;

    @Test
    public void redirectCheck(){

        String currentUrl = driver.getCurrentUrl();
        String newUrl = driver.getCurrentUrl();


        elementUtil.actionClick("//*[@id=\"jobs-list\"]/div[1]/div",".//a[text()='View Role']");
        if (!currentUrl.equals(newUrl)) {
            LogUtil.printInfoMsgToConsole("Page has been redirected.");
        } else {
            LogUtil.printInfoMsgToConsole("Page has not been redirected.");
        }

    }
}
