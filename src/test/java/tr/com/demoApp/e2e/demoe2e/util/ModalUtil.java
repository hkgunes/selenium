package tr.com.demoApp.e2e.demoe2e.util;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;

@Slf4j
@Service
public class ModalUtil {

    private WebElement pageModal;
    @Autowired
    private WaitUtil waitUtil;
    @Autowired
    private WebDriver driver;





    public void checkPageModal(String page)  {

        Assert.assertTrue(driver.getTitle().contains(page), "Page is not opened");


    }


    public void moduleCheckModal(String moduleXpath) {

        Assert.assertTrue(driver.findElement(By.xpath(moduleXpath)).isDisplayed(), "Module is not displayed");

    }






}
