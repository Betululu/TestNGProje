package com.techproed.tests;

import com.techproed.pages.AmazonAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBaseFinal {



    @Test
    public void aramaTest(){
        extentTest =extentReports.createTest("AmazonAramaTest","Amazonda urun ismi kontrolu");

        extentTest.info("Amazon a gidip arama kutusununa erisim sagladik");
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_link"));

        extentTest.info("AmazonAramaPage clasindan nesne urettik");
        AmazonAramaPage amazonAramaPage = new AmazonAramaPage();

        extentTest.info("searcBox a aranacak_kelimeyi yazdik");
        amazonAramaPage.searcBox.sendKeys(ConfigurationReader.getProperty("aranacak_kelime") + Keys.ENTER);

        extentTest.info("result bolumunden yazilari alalim");
        String resultYazisi = amazonAramaPage.result.getText();

        extentTest.info("Assert ile dogrulayalim");
        Assert.assertTrue(resultYazisi.contains(ConfigurationReader.getProperty("aranacak_kelime")));
        extentTest.pass("Testimiz PASSED!");
    }
}
