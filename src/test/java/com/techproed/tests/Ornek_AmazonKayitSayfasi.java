package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {
    @Test
    public void test01(){
        // 4 dk süreniz.
        // 1. Adım : Mouse'u moveToElement methodunu kullanarak, Account & Lists
        //           webelementinin üzerine götürün.
        // 2. Adım : Start here. linkine tıklayın.

        driver.get("http://amazon.com");
    WebElement menu = driver.findElement(By.id("nav-link-accountList"));
    Actions actions = new Actions(driver);
    // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
    // moveToElement methodunu kullabiliriz.
        actions.moveToElement(menu).perform();
        WebElement startHere= driver.findElement(By.partialLinkText("Start here."));
        startHere.click();
        //WebElement kayit = driver.findElement(By.xpath("//*[.='Starten Sie hier.'] "));
        //kayit.click(); boylede olur
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Amazon Registration",title);

        // 3. Adım : Sayfanın title'ı Amazon Registration ise testiniz başarılı olsun.
        // True kullanarak Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
        // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        //Assert.assertEquals(driver.getTitle(),"Amazon Registration");
}
    @Test (dependsOnMethods = "test01")
    public void test02(){
        WebElement isim = driver.findElement(By.id("ap_customer_name"));
        isim.sendKeys("Hamza Yılmaz");
        driver.findElement(By.id("ap_email")).sendKeys("hamzayilmaz2020@protonmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Amazon06.");
        driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06.");
        driver.findElement(By.id("continue")).click();
    }
}
