Feature: Accessing the Education/Training
  @EducationTraining
  Scenario: Admin access the Education/Training page
    Given Admin is logged in
    When Admin click on Education Training
    Then Admin go to Education Training page
