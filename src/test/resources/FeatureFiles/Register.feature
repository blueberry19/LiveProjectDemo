Feature: Registration functionaity scenarios

@Register @One
Scenario: Verify whether the user is able to register into the application by providing all the details
 Given I launch the application
 And I navigate to Account Registration Page
 When I provide all the below valid details
    | FirstName | Ravi                |
    | LastName  | Kiran               |
    | Email     | ravi.kiran2003@gmail.com|
    | Telephone | 965743568           |
    | Password  | rkiran              |
 And I select privacy policy
 And I click on Continue Button
 Then I should see that the User account has been created successfully
    
 @Register @Two
 Scenario: Verify whether the user is not allowed to register on skipping the mandatory fields
 Given I launch the application
 And I navigate to Account Registration Page
 And I click on Continue Button
 Then I should see that the User account is not created
 And I should see the error messages informing the users to fill the mandatory fields
 
  @Register @Three
 Scenario: Verify whether the user is able to register into the application by subscribing to the newsletter
 Given I launch the application
 And I navigate to Account Registration Page
 When I provide all the below valid details
    | FirstName | Ravi                |
    | LastName  | Kiran               |
    | Email     | ravi.kiran2003@gmail.com|
    | Telephone | 965743568           |
    | Password  | rkiran              |
 And I select privacy policy
 And I subscribe to Newsletter
 And I click on Continue Button
 Then I should see that the User account has been created successfully
 
 @Register @Four
Scenario: Verify whether the user is able to register into the application by providing all the details
 Given I launch the application
 And I navigate to Account Registration Page
 When I provide the below duplicate details
    | FirstName | Ravi                |
    | LastName  | Kiran               |
    | Email     | ravi.kiran2003@gmail.com|
    | Telephone | 965743568           |
    | Password  | rkiran              |
 And I select privacy policy
 And I click on Continue Button
 Then I should see that the User is restricted from creating a duplicate account