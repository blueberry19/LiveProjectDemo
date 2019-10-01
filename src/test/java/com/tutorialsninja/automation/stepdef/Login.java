package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import cucumber.api.java.en.*;

public class Login {
	
	HeaderSection headersection = new HeaderSection();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	
	@And("^I navigate to the Account login page$")
	public void i_navigate_to_the_Account_login_page() {
	    
		Elements.click(HeaderSection.myAccount);
		Elements.click(HeaderSection.Login);
		
	}

	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_Username_and_Password(String email, String password) {
	    
		LoginPage.doLogin(email, password);
		
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() {
	    
		Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffiliateAccount));
		
	}

	@Then("^I should see an error message that the credentials are invalid$")
	public void i_should_see_an_error_message_that_the_credentials_are_invalid() {
	    
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning, "Warning: No match for E-Mail Address and/or Password."));
		
	}
	
	@When("^I reset the forgotten password for email \"([^\"]*)\"$")
	public void i_reset_the_forgotten_password_for_email(String email) {
	    
		Elements.click(LoginPage.forgotPassword);
		Elements.TypeText(ForgotPasswordPage.emailField, email);
		Elements.click(ForgotPasswordPage.continueButton);
		
	}
	
	@Then("^I should see a message informing the user that information related to resetting the password have been sent to email address$")
	public void i_should_see_a_message_informing_the_user_that_information_related_to_resetting_the_password_have_been_sent_to_email_address() {
	    
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning1, "An email with a confirmation link has been sent your email address."));
	}


}
