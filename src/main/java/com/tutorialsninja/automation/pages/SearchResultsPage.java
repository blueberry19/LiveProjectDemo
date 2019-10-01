package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class SearchResultsPage {
	
	public SearchResultsPage() {
		
		PageFactory.initElements(Base.driver, this);
		
	}
	
	@FindBy(linkText="Samsung SyncMaster 941BW")
	public static WebElement samsungSyncMasterSearchProduct;
	
	@FindBy(css="#content > p:nth-child(7)")
	public static WebElement noResultsMessage;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span")
	public static WebElement firstAddToCartOption;
	
	public static void addProductFromTheSearchResultsToTheCart() {
		Elements.click(SearchResultsPage.firstAddToCartOption);
	}


}
