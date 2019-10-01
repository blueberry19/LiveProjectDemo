package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {
	
	public RegisterPage() {
				
				PageFactory.initElements(Base.driver, this);
				
	}
	
	@FindBy(id="input-firstname")
	public static WebElement firstName;
	
	@FindBy(id="input-lastname")
	public static WebElement lastName;
	
	@FindBy(id="input-email")
	public static WebElement email;
	
	@FindBy(id="input-telephone")
	public static WebElement telephone;
	
	@FindBy(id="input-password")
	public static WebElement password;
	
	@FindBy(id="input-confirm")
	public static WebElement confirmPassword;
	
	@FindBy(name="agree")
	public static WebElement privacyPolicy;
	
	@FindBy(css="#content > form > div > div > input.btn.btn-primary")
	public static WebElement continueButton;
	
	@FindBy(linkText="Register")
	public static WebElement registerBreadcrumb;
	
	@FindBy(css="#account > div:nth-child(3) > div > div")
	public static WebElement firstNameWarning;
	
	@FindBy(css="#account > div:nth-child(4) > div > div")
	public static WebElement lastNameWarning;
	
	@FindBy(css="#account > div:nth-child(5) > div > div")
	public static WebElement emailWarning;
	
	@FindBy(css="#account > div:nth-child(6) > div > div")
	public static WebElement telephoneWarning;
	
	@FindBy(css="#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")
	public static WebElement passwordWarning;
	
	@FindBy(css="#account-register > div.alert.alert-danger.alert-dismissible")
	public static WebElement mainWarning;
	
	@FindBy(css="#content > form > fieldset:nth-child(3) > div > div > label:nth-child(1)")
	public static WebElement yesToNewsletter;
	
	public static void enterAllDetails(DataTable datatable, String detailsType) {
		
        Map<String,String> map = datatable.asMap(String.class, String.class);
		
		Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
		
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password, map.get("Password"));
		Elements.TypeText(RegisterPage.confirmPassword, map.get("Password"));
		
		if(detailsType.equalsIgnoreCase("duplicate")){
			
			Elements.TypeText(RegisterPage.email, map.get("Email"));
			
		}else {
			
			Elements.TypeText(RegisterPage.email, System.currentTimeMillis() + map.get("Email"));
		}
		
	}
	
		

}
