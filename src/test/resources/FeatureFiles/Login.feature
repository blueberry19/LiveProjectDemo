Feature: Login functionality scenarios

@Login @One
Scenario: verify whether the user is able to login with valid credentials

Given I launch the application
And I navigate to the Account login page
When I login to the application using Username "ravi.kiran2003@gmail.com" and Password "rkiran"
Then I should be able to login successfully

@Login @Two
Scenario: verify whether the user is not able to login with invalid credentials

Given I launch the application
And I navigate to the Account login page
When I login to the application using Username "ravi.kiran23@gmail.com" and Password "rhkiran"
Then I should see an error message that the credentials are invalid

@Login @Three
Scenario: verify whether the user is not able to login without providing credentials

Given I launch the application
And I navigate to the Account login page
When I login to the application using Username "" and Password ""
Then I should see an error message that the credentials are invalid

@Login @Four
Scenario: verify whether the user is able to reset the Forgotten password 

Given I launch the application
And I navigate to the Account login page
When I reset the forgotten password for email "ravi.kiran2003@gmail.com"
Then I should see a message informing the user that information related to resetting the password have been sent to email address