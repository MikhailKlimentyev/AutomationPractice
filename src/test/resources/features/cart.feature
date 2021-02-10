Feature: Cart

  Background:
    Given Open home page
    When Click on product with name "Blouse"
    And Set product quantity "2"
    And Click on Add To Cart button
    And Click on Proceed To Checkout button

  Scenario: Add product to cart from product page
    Then Number of products in cart is "2"

  Scenario: Remove previously added product from cart
    And Remove product from cart
    Then The following message "Your shopping cart is empty." presents on cart page












