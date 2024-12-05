Feature: New User Registration
  As a new user
  I want to create an account
  So that I can shop online and manage my purchases

  @petstore
  Scenario Outline: Successful user registration
    Given I am on the homepage using "<browser>"
    And I navigate to the Create an account page
    When I fill in account registration with valid values
    And I click the Create an Account button
    Then I should see be redirected to the main page

    Examples: 
      | browser |
      | chrome  |
      | firefox |
  
