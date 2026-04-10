package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.QuoraPage;
import utils.ConfigReader;

public class QuoraSearchTest extends BaseTest {

    @Test
    public void verifySignUpFlow() throws IOException, InterruptedException {

        QuoraPage page = new QuoraPage(driver);

       
        SoftAssert aseert=new SoftAssert();
       aseert.assertTrue(page.isSignUpButtonDisabled(), "Sign Up button should be disabled");

       
        page.search("Testing");
        Thread.sleep(3000);

        
        page.clickSignUpWithEmail();

        
        page.enterName(ConfigReader.get("name"));
        Thread.sleep(1000);

      
        page.enterEmail(ConfigReader.get("invalidEmail"));
        Thread.sleep(3000);

     
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshot/quoraSignup.png");
        dest.getParentFile().mkdirs();
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
    }
}
