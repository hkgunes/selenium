package tr.com.demoApp.e2e.demoe2e.config;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Parameters;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Configuration
public class SeleniumConfig   {

    @Autowired
    private WebDriver webDriver;

 /*   @Bean
    public WebDriver webDriver(AppProperties appProperties) throws  ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.setProperty(appProperties.getDriver().getType(), appProperties.getDriver().getPath());
        WebDriver driver = (WebDriver) Class.forName(appProperties.getDriver().getDriverClass()).newInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriver = driver;
        return driver;
    }

*/

    @Bean
    public WebDriver webDriver(AppProperties appProperties) throws  ClassNotFoundException, IllegalAccessException, InstantiationException {
        WebDriver driver = null;

        if (appProperties.getSelect().equalsIgnoreCase("chrome")) {
            System.setProperty(appProperties.getDriver().getType(), appProperties.getDriver().getPath());
            driver=(WebDriver) Class.forName(appProperties.getDriver().getDriverClass()).newInstance();


        } else if (appProperties.getSelect().equalsIgnoreCase("firefox")) {
            System.setProperty(appProperties.getDriverFirefox().getType(), appProperties.getDriverFirefox().getPath());
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }




    @PreDestroy
    public void destroy(){
        webDriver.quit();
    }

}
