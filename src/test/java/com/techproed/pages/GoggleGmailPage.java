package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoggleGmailPage {
    public GoggleGmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy  (partialLinkText = "Gmail")
    public WebElement gmailLink;
}
