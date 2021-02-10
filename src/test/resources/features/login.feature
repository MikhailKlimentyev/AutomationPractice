Feature: Login

  Background:
    Given Open login page

  Scenario: Successful logIn
    When Fill in email field with "email" value
    And Fill in password field with "password" value
    And Click on Sign In button
    Then User with "Mike" first name and "John" last name is logged in

  Scenario Outline: Login with invalid data
    When Fill in email field with <email> value
    And Fill in password field with <password> value
    And Click on Sign In button
    Then Error message with text <error message> is appeared
    Examples:
      | email                        | password             | error message                |
      | "ghjd%$:125'?ikil@gmail.com" | "password"           | "Invalid email address."     |
      | "ghjd@gmail.com"             | "password"           | "Authentication failed."     |
      | "email"                      | "698$2%$:fhj'354787" | "Authentication failed."     |
      | "ghjd@gmail.com"             | "698$2%$:fhj'354787" | "Authentication failed."     |
      | ""                           | "password"           | "An email address required." |
      | "email"                      | ""                   | "Password is required."      |

  Scenario: Successful logOut
    When Fill in email field with "email" value
    And Fill in password field with "password" value
    And Click on Sign In button
    And Click on Sign Out button
    Then LogOut is successful







