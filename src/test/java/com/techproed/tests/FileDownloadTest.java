package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarmi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");
        // C:/Users/isimsiz/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu +"/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
        //Assert.assertTrue(varMi);C:\Adil uluca/logo.png
    }
    @Test
    public void dosyaUpload(){ // bilgisayardan websayfasına doysa yükleme
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));
        // yüklemek istediğimiz dosyanın, path(dosya yolunu) ekleyelim.
        dosyaSecmeButonu.sendKeys("C:\\Adil uluca/logo.png");
        //dosyaSecmeButonu.sendKeys("C:\\Users\\isimsiz\\upload\\logo.png");
        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();
        //WebElement ekranYaizi = driver.findElement(By.xpath("//*[.='File Uploaded!']"));boylede oluyor
        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());

    }
    @Test
    public void dosyaDownload(){
        // C:\Users\isimsiz\Downloads\students.jpg
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement studentsLinki = driver.findElement(By.partialLinkText("students.jpg"));
        studentsLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:/Users/DELL/Downloads/students.jpg"));
        Assert.assertTrue(varMi);
    }









}
