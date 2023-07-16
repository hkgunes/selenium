package tr.com.demoApp.e2e.demoe2e.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;
import tr.com.demoApp.e2e.demoe2e.config.TestBase;
import tr.com.demoApp.e2e.demoe2e.util.ElementUtil;
import tr.com.demoApp.e2e.demoe2e.util.LogUtil;
import tr.com.demoApp.e2e.demoe2e.util.WaitUtil;

import java.util.List;

@Service
public class CheckJobs_4  extends TestBase {
    @Autowired
    private ElementUtil elementUtil;
    @Autowired
    private WaitUtil waitUtil;
    @Autowired
    private LogUtil logUtil;
    @Autowired
    private WebDriver driver;

    @Test
    public void checkJobList(){

        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }
            List<WebElement> page = waitUtil.waitElementsToBeVisible("//*[@id=\"jobs-list\"]/div", driver);
            if(!page.isEmpty()){
                LogUtil.printInfoMsgToConsole("Filtreleme yapılcı" + "//*[@id=\"jobs-list']/div");

                for (int i=1;i<= page.size();i++){

                    String qa= driver.findElement(By.xpath("//*[@id='jobs-list']/div["+i+"]/div/p")).getText();;
                    String location= driver.findElement(By.xpath("//*[@id='jobs-list']/div["+i+"]/div/div")).getText();
                    elementUtil.clickElement("//*[@id='jobs-list']/div["+i+"]");
                    String btn= driver.findElement(By.xpath("//*[@id='jobs-list']/div["+i+"]/div/a")).getText();
                    LogUtil.printInfoMsgToConsole(qa);
                    LogUtil.printInfoMsgToConsole(location);
                    LogUtil.printInfoMsgToConsole(btn);

                    Assert.assertTrue(qa.contains("Quality Assurance") && location.contains("Istanbul, Turkey") && btn.contains("View Role"));

                }



            }else{
                LogUtil.assertFail("job list is empty ");
            }


    }


}
