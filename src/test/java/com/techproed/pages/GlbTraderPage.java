package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraderPage {
    public GlbTraderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id="typeahead")
    public WebElement searcBox;
    @FindBy (id="header_search_category")
    public WebElement dropDown;
    @FindBy (xpath = "//h4/a")
    public List<WebElement> sonuclarliste;
}
