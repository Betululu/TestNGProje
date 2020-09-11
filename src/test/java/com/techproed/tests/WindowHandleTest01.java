package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest01 extends TestBase {
    @Test
    public void cokluPencereTest(){

        driver.get("https://the-internet.herokuapp.com/windows");
        //Icinde bulundu ilksayfsanin handlesini alir
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        //Acilan ikinci sayfanin handlesini alir
        driver.findElement(By.partialLinkText("Click Here")).click();
        //String ikinciSayfaHandle = driver.getWindowHandle();
        // System.out.println(ikinciSayfaHandle);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> tumPenceler = driver.getWindowHandles();

        //elinizdeki tüm pencerelerin windows handle'larını bu şekilde ekrana yazdırabilirsiniz.
        for(String handle : tumPenceler){
            System.out.println(handle);
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Acik olan tum pencerelerin icinden en sondaki pencerenin handlesini alir
        Object[] array = (Object[]) tumPenceler.toArray();
        String ikinciSayfaHandle = array[array.length - 1].toString();
        System.out.println(ikinciSayfaHandle);

        //ikincisayfanin  handlesine tekrar doner
        //driver.switchTo().window(sayfaninHandle);
    }

}
