package tr.com.demoApp.e2e.demoe2e.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;
import tr.com.demoApp.e2e.demoe2e.config.TestBase;
import tr.com.demoApp.e2e.demoe2e.util.ElementUtil;
import tr.com.demoApp.e2e.demoe2e.util.ModalUtil;

@Service
public class JobList_3 extends TestBase {

    @Autowired
    private ElementUtil elementUtil;
    @Autowired
    private ModalUtil modalUtil;
    @Autowired
    private WebDriver driver;
    @Test
    public void jobLists(){

        elementUtil.waitAndClickElement("//*[@id=\"career-find-our-calling\"]/div/div/a");
        elementUtil.waitAndClickElement("//*[@id=\"career-find-our-calling\"]/div/div/div[2]/div[12]/div[2]/a/h3");
        //elementUtil.waitAndClickElement("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a");
        elementUtil.clickElement("//a[text()='See all QA jobs']");


        elementUtil.filterAction("All","Istanbul, Turkey");
        elementUtil.filterAction("Quality Assurance","Quality Assurance");


       Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"jobs-list\"]")).size() > 0);
    }
}
