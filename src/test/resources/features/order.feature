Feature: Order

  Scenario: Delivery address on shopping-cart summary page equals to info of logged in user
    Given Open home page
    When Click on Sign In button on home page
    And Fill in email field with "email" value
    And Fill in password field with "password" value
    And Click on Sign In button
    And Click on logo
    And Click on product with name "Printed Dress"
    And Set product quantity "3"
    And Set product size "M"
    And Click on Add To Cart button
    And Click on Proceed To Checkout button
    Then Delivery address info equals info of user
      | firstName | lastName | email   | password | address        | city  | state   | postalCode | country       | phone |
      | Mike      | John     | [blank] | [blank]  | Real Madrid, 5 | Milan | Arizona | 00000      | United States | 666   |

  Rule: Ordering
    Background:
      Given Open home page
      When Click on Sign In button on home page
      And Fill in email field with "email" value
      And Fill in password field with "password" value
      And Click on Sign In button
      And Click on logo
      And Click on product with name "Printed Dress"
      And Set product quantity "3"
      And Set product size "M"
      And Click on Add To Cart button
      And Click on Proceed To Checkout button
      And Click on Proceed To Checkout Summary button
      And Click on Proceed To Checkout Address button
      And Set Cgv checkbox
      And Click on Proceed To Checkout Shipping button

    Scenario: Complete order processing from login to payment verification and choose payment by bank wire
      When Click on Pay by bank wire button
      And Click on Confirm Order button
      Then On Order confirmation page "Your order on My Store is complete." message appears for pay by bank wire

    Scenario: Complete order processing from login to payment verification and choose payment by check
      When Click on Pay By Check button
      And Click on Confirm Order button
      Then On Order confirmation page "Your order on My Store is complete." message appears for pay by check





















