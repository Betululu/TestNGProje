package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAramaPage {
    public AmazonAramaPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (id="twotabsearchtextbox")
    public WebElement searcBox;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement result;
}
