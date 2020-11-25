package com.techproed.tests;

import com.techproed.pages.GoggleGmailPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleGmailTest extends TestBaseFinal {
    @Test
    public void gmailTest() throws InterruptedException {
        extentTest = extentReports.createTest("Gmail Test", "Gmail.com a Google uzerinden erisim testi");

        extentTest.info("Google.com a gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("GoggleGmailPageden nesne olusturuyoruz");
        GoggleGmailPage goggleGmailPage = new GoggleGmailPage();

        extentTest.info("gmaillinki Webelementine tikliyoruz");
        goggleGmailPage.gmailLink.click();

        extentTest.info("3 saniye bekliyoruz");
        Thread.sleep(3000);

        extentTest.info("Assert islemi ile dogrulatiyoruz");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Gmail"));
        extentTest.pass("Testimiz PASSED !");



    }
}
