package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {
    //@Test olsaydi baglama islemini yapacaktik ama Beforemethod olunca gerek kalmadi
    //@BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    //@Test (dependsOnMethods = "girisTest" )
    //public void hotelCreate() {

//        driver.get("  http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
//        WebElement name= driver.findElement(By.id("UserName"));
//        name.sendKeys("manager2");
//
//        WebElement passport=driver.findElement(By.id("Password"));
//        passport.sendKeys("Man1ager2!");
//        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
//        logIn.click();
    //}
    @Test
    public void hotelCreate(){
        giris();
        WebElement codeKutusu = driver.findElement(By.id("Code"));
        WebElement nameKutusu = driver.findElement(By.id("Name"));
        WebElement adresKutusu= driver.findElement(By.id("Address"));
        WebElement phoneKutusu= driver.findElement(By.id("Phone"));
        WebElement emailKutusu= driver.findElement(By.id("Email"));
        WebElement idGrup     = driver.findElement(By.id("IDGroup"));
        WebElement saveButonu = driver.findElement(By.id("btnSubmit"));
        codeKutusu.sendKeys("1234");
        nameKutusu.sendKeys("BETUL ULU");
        adresKutusu.sendKeys("Çıkmaz Sk. 34/20");
        phoneKutusu.sendKeys("022222222222");
        emailKutusu.sendKeys("merhaba@dunya.com");
        Select select = new Select(idGrup);
        select.selectByIndex(2);
        saveButonu.click();
        //Thread.sleep de kullanabiliriz
        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());
    }
}
