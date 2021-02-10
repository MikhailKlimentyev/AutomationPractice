Feature: Account

  Background:
    Given Open login page

  Scenario: Successfully create new account
    When Fill out email field with still no registered email in order to create an account
    And Click on Create an account button
    And Fill out Create an account form for the following user
      | firstName | lastName | email   | password | address        | city  | state   | postalCode | country       | phone |
      | Mike      | John     | [blank] | [blank]  | Real Madrid, 5 | Milan | Arizona | 00000      | United States | 666   |
    And Click on Register button
    Then User with "Mike" first name and "John" last name is logged in

  Scenario: Impossible create new account with already registered email
    When Fill in email address field with "email" on create new account form
    And Click on Create an account button
    Then The error with following error message appears
      """
      An account using this email address has already been registered. Please enter a valid password or request a new one.
      """