package tr.com.demoApp.e2e.demoe2e.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;
import tr.com.demoApp.e2e.demoe2e.config.TestBase;
import tr.com.demoApp.e2e.demoe2e.util.ElementUtil;
import tr.com.demoApp.e2e.demoe2e.util.ModalUtil;

@Service
public class CareersPage_2 extends TestBase {

    @Autowired
    private ElementUtil elementUtil;
    @Autowired
    private ModalUtil modalUtil;

    @Test(description = "Careers Page click " ,priority = 1)
    public void careersPageClick(){

        elementUtil.clickLinkText("Company");
        elementUtil.clickLinkText("Careers");

    }
    @Test(description = "Careers Page  check" ,priority = 2)
    public void careersPageCheck(){

        modalUtil.checkPageModal("Careers");
        modalUtil.moduleCheckModal("//*[@id='career-our-location']/div/div/div/div[1]/h3");
        modalUtil.moduleCheckModal("//a[text()='See all teams']");
        modalUtil.moduleCheckModal("//h2[text()='Life at Insider']");

    }


}
