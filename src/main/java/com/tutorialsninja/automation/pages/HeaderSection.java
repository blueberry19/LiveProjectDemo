package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class HeaderSection {
	
	public HeaderSection() {
		
		PageFactory.initElements(Base.driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	public static WebElement myAccount;
	
	@FindBy(linkText="Register")
	public static WebElement Register;
	
	@FindBy(linkText="Login")
	public static WebElement Login;
	
	@FindBy(name="search")
	public static WebElement searchBoxField;
	
	@FindBy(css="#search > span > button")
	public static WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	public static WebElement viewShoppingCart;
	
	public static void navigateToLoginPage() {
		
		Elements.click(HeaderSection.myAccount);
		Elements.click(HeaderSection.Login);
		
	}
	
	public static void searchProduct() {
		
		Elements.TypeText(HeaderSection.searchBoxField, Base.reader.getProduct());	
		Elements.click(HeaderSection.searchButton);
		
	}
	
	public static void navigateToShoppingCartPage() {
		
		Elements.click(HeaderSection.viewShoppingCart);
		
	}

}
