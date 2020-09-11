package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.apache.commons.compress.archivers.tar.TarArchiveSparseEntry;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        //Webelement ikincihandle=driver..findElement(By.partialLinkText("Click Here"))
        //ikincihandle.click(); bunun yerine artik asagidaki gibi de kullanabiliriz
        driver.findElement(By.partialLinkText("Click Here")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //String ikinciSayfaHandle = driver.getWindowHandle();
       // System.out.println(ikinciSayfaHandle);

        Set<String> tumPenceler = driver.getWindowHandles();
        // elinizdeki tüm pencerelerin windows handle'larını bu şekilde ekrana yazdırabilirsiniz.
         //        for(String handle : tumPenceler){
         //            System.out.println(handle);
        // }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object[] array = (Object[]) tumPenceler.toArray();
        String ikinciSayfaHandle = array[array.length - 1].toString();
        System.out.println(ikinciSayfaHandle);
        driver.switchTo().window(sayfaninHandle);

    }


}
