Feature: Accessing the user settings
  @UserSettings
  Scenario: Admin access the user settings
    Given Admin is logged in
    When Admin click on User settings
    Then Admin go to User settings page
