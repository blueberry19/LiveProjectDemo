package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class LoginPage {
	
	public LoginPage() {
			
			PageFactory.initElements(Base.driver, this);
			
		}
	
	@FindBy(id="input-email")
	public static WebElement emailField;
	
	@FindBy(id="input-password")
	public static WebElement passwordField;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > form > input")
	public static WebElement loginButton;
	
	@FindBy(css="#account-login > div.alert.alert-danger.alert-dismissible")
	public static WebElement mainWarning;
	
	@FindBy(css="#account-login > div.alert.alert-success.alert-dismissible")
	public static WebElement mainWarning1;
	
	@FindBy(linkText="Forgotten Password")
	public static WebElement forgotPassword;
	
	public static void doLogin(String email, String password) {
		
		Elements.TypeText(LoginPage.emailField, email);
		Elements.TypeText(LoginPage.passwordField, password);
		Elements.click(LoginPage.loginButton);
		
	}
	
    public static void doLogin() {
		
		Elements.TypeText(emailField, Base.reader.getUsername());
		Elements.TypeText(passwordField, Base.reader.getPassword());
		Elements.click(loginButton);
		
	}
}
