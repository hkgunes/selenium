package tr.com.demoApp.e2e.demoe2e.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

@Slf4j
@Service
public class WaitUtil {

    @Autowired
    protected WebDriver driver;

    public static final int TIMEOUT_IN_SECONDS = 10;   //60 100



    @ExceptionHandler(Throwable.class)
    public WebElement waitElementToBeClickable(String path, WebDriver driver){
        By by = By.xpath(path);
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }


    @ExceptionHandler(Throwable.class)
    public WebElement waitElementToBeVisible(String path, WebDriver driver){
        By by = By.xpath(path);
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    @ExceptionHandler(Throwable.class)
    public List<WebElement> waitElementsToBeVisible(String path, WebDriver driver){
        By by = By.xpath(path);
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }






}
