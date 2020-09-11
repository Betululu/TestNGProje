package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {
    WebDriver driver;
    public FhcTripHotelCreatePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
