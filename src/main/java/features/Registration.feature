Feature: Registration flow feature

  @ExecutaAcestTC
  Scenario: The Registration page can be accessed from navigation bar
    Given "https://demo-opencart.com/" is accessed
    Given "HomePage" is accessed
    When user clicks on register buttons from navigation bar
    Then Correct "RegisterPage" endpoint dislayed

  Scenario: Open cart page is accessible
    When "https://demo-opencart.com/" is accessed
    Then "https://demo-opencart.com/" is present within the current url

  @LectieAvansata
  Scenario Outline: Invalid email address error is displayed when providing invalid email data for <affectedFiled>
    Given "RegisterPage" is accessed
    When the register fields are populated with the following data:
      | firstName       | <first name>   |
      | lastName        | <last name>    |
      | email           | <email>        |
      | phoneNumber     | <phone number> |
      | password        | Parola123!     |
      | confirmPassword | Parola123!     |
    And privacyCheckBox is clicked
    And Continue button is clicked
    Then the following key words are present within an error message
      | <errorMessage> |
    Examples:
      | affectedField | first name                        | last name | email              | phone number | errorMessage                                    |
      | Email         | Diana                             | Preda     |                    | 079778899    | appear to be valid!                             |
      | First Name    |                                   | Preda     | emailbun@ymail.com | 079778899    | First Name must be between 1 and 32 characters! |
      | Last Name     | Diana                             |           | emailbun@ymail.com | 079778899    | Last Name must be between 1 and 32 characters!  |
      | Phone         | Diana                             | Preda     | emailbun@ymail.com |              | Telephone must be between 3 and 32 characters!  |
      | Phone         | Diana                             | Preda     | emailbun@ymail.com | 07           | Telephone must be between 3 and 32 characters!  |
      | First Name    | sEf6Rf7C6JuavKF9mj4QiixOppunrIMvv | Preda     | emailbun@ymail.com | 079778899    | First Name must be between 1 and 32 characters! |