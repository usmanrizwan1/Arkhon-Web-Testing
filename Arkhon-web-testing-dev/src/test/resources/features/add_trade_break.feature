Feature: Adding a trade break on the portal
  @add-trade-break
  Scenario Outline: Adding a trade break
    Given I am on the reconciliation page
    When I click on the add trade break button
    And I fill in trade break details trade break type "<tradeBreakType>" amount "<amount>" currency type "<currencyType>" reason type "<reasonType>" platform "<platform>" comment "<comment>"
    And I confirm the trade break should be added
    Then I should see that the trade break has been added to the trade break table with correct date and trade break type "<tradeBreakType>" amount "<amount>" currency type "<currencyType>" reason type "<reasonType>" platform "<platform>" comment "<comment>"
    Examples:
    |tradeBreakType|amount|currencyType|reasonType|platform|comment|
    |credit        |3     |BTC         |Gas for LP Settlement|talos|test|
