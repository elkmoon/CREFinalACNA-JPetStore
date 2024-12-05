Feature: Search and Check Product
  As a user
  I want to search for products
  So that I can find and view the details of an product I want to purchase

  @petstore
  Scenario Outline: Successful search for an existing product
    Given I am on the homepage using "<browser>"
    When I enter "<searchTerm>" in the search bar
    And I click the Search button
    Then I should see a list of products related to "<searchTerm>"

    Examples: 
      | browser | searchTerm | item id |
      | chrome  | Finch      | EST-19  |
      | firefox | Finch      | EST-19  |

  @petstore
  Scenario Outline: Viewing product details
    Given I am on the homepage using "<browser>"
    And I searched for "<searchTerm>" and results are displayed
    When I click on the first item
   Then I should be redirected to the product details page

    Examples: 
      | browser | searchTerm |
      | chrome  | Finch      |
      | firefox | Finch      |
    
