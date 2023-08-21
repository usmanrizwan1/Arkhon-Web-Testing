Feature: Accessing a clients portfolio
  @view-client-portfolio
  Scenario Outline: Accessing a clients portfolio via the Client Account Page
    Given I am on the client account page
    When I click on a client account in the table with row id "<rowNumber>"
    Then I should view the clients portfolio
    Examples:
    |rowNumber|
    |1 |
    |2 |