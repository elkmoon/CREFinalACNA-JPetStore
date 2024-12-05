
Feature: Product Purchase
  As a user
  I want to complete the purchase of products in my cart
  So that I can buy those products

 @petstore
  Scenario Outline: Successful purchase of a product
    Given I am on the homepage using "<browser>"
    And I am autenticated with "<username>" and "<password>"
    And I add a product to the cart using "<searchTerm>"
    When I proceed to checkout
    And I fill out my payment details
    And I click the Continue button
    And I confirm the order
   Then I should see a confirmation message

    Examples: 

      | browser | username | password  | searchTerm |
      | chrome  | ElkmoonX |  Xpto0E€  |   Finch    |
      | firefox | ElkmoonX |  Xpto0E€  |   Finch    |
