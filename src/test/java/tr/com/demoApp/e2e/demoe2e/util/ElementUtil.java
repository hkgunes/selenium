package tr.com.demoApp.e2e.demoe2e.util;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Service
@Slf4j

public class ElementUtil {

    @Autowired
    private WaitUtil waitUtil;
    @Autowired
    private WebDriver driver;






    public WebElement clickElement(String xpath){
        waitUtil.waitElementToBeClickable(xpath, driver);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }

    public void clickLinkText(String xpath){

        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
         driver.findElement(By.linkText(xpath)).click();

    }

    public void filterAction(String first, String select){
        WebElement filter = driver.findElement(By.xpath("//span[text()='"+first+"']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(filter).click().perform();
        WebElement option = driver.findElement(By.xpath("//li[text()='"+select+"']"));
        option.click();

    }

    public void actionClick(String firstXpath, String apply){
        WebElement filter = driver.findElement(By.xpath(firstXpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(filter).click().perform();
        WebElement option = driver.findElement(By.xpath(apply));
        option.click();

    }

    @ExceptionHandler(Throwable.class)
    public WebElement waitAndClickElement(String xpath) {
        Actions action = new Actions(driver);
        waitUtil.waitElementToBeClickable(xpath, driver);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath(xpath));
            executor.executeScript("arguments[0].click();", element);
            log.info(" --- SUCCESS - click try1 < js click > waitAndClickElement : Javascript click xpath : " + xpath);
            return element;

        } catch (Exception e) {
            WebElement element = waitUtil.waitElementToBeClickable(xpath, driver);
            log.info("click js fail - wait - WebElement null control : " + element + " xpath : " + xpath);

            if (element == null) {
                log.info("Birşeyler ters gitti");

            } else {
                try {
                    element.click();
                    log.info(" --- SUCCESS - click try2 < selenium click > WebElement : " + element + " xpath : " + xpath);
                } catch (Exception e1) {
                    action.moveToElement(element).click().build().perform();
                    log.info(" --- SUCCESS - click try3 < action click > WebElement : " + element + " action click xpath : " + xpath);
                }
            }
            return element;
        }
    }




}
