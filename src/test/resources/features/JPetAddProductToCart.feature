Feature: Add product to Cart
  As a user
  I want to add a product to my cart
  So that I can purchase it

  @petstore
  Scenario Outline: Adding a product to the cart
    Given I am on the homepage using "<browser>"
    And I enter "<searchTerm>" in the search bar
    And I click on the item after searching "<searchTerm>"
    Then I click on the Add to cart button

    Examples: 
      | browser | searchTerm |
      | chrome  |   Finch    |
      | firefox |   Finch    |
     
