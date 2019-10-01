package com.tutorialsninja.automation.stepdef;





import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;



public class Register {
	
	HeaderSection headersection = new HeaderSection();
	RegisterPage registerpage = new RegisterPage();
	AccountSuccessPage accountsuccesspage = new AccountSuccessPage();
	
	@Given("^I launch the application$")
	public void i_launch_the_application() {
		
		Base.driver.get(Base.reader.getUrl());
	    
	}

	@And("^I navigate to Account Registration Page$")
	public void i_navigate_to_Account_Registration_Page() {
		
		Elements.click(HeaderSection.myAccount);
		Elements.click(HeaderSection.Register);
	    
	}

	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable datatable) {
	   
		RegisterPage.enterAllDetails(datatable,"unique");
	}

	@And("^I select privacy policy$")
	public void i_select_privacy_policy() {
		
		Elements.click(RegisterPage.privacyPolicy);
		
	}

	@And("^I click on Continue Button$")
	public void i_click_on_Continue_Button() {
		
		Elements.click(RegisterPage.continueButton);
	    
	}

	@Then("^I should see that the User account has been created successfully$")
	public void i_should_see_that_the_User_account_has_been_created_successfully() {
	    
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadcrumb));
		
		
	}

	@Then("^I should see that the User account is not created$")
	public void i_should_see_that_the_User_account_is_not_created() {
		
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));

	}

	@And("^I should see the error messages informing the users to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_users_to_fill_the_mandatory_fields() {

		Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));
		
	}

	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter()  {
		
		Elements.click(RegisterPage.yesToNewsletter);
	    
	}
	
	@When("^I provide the below duplicate details$")
	public void i_provide_the_below_duplicate_details(DataTable datatable) {
	    
		RegisterPage.enterAllDetails(datatable,"duplicate");
		
	}

	@Then("^I should see that the User is restricted from creating a duplicate account$")
	public void i_should_see_that_the_User_is_restricted_from_creating_a_duplicate_account() {
	    
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning, "Warning: E-Mail Address is already registered!"));
		
	}

}
