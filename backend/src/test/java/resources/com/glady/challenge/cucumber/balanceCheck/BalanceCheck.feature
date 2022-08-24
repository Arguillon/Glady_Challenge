Feature: Check the balance of a user after receiving gift and meal deposits

  Scenario: User with multiple gift and meal deposits
    Given The user whose name is "JOE DOE" exists
    When The user whose name is "JOE DOE" receives multiple gift deposits
      | companyName | value  | receptionDate |
      | APPLE       | 50.00  | 2022-09-29    |
      | TESLA       | 100.00 | 2022-09-30    |
    And The user whose name is "JOE DOE" receives multiple meal deposits
      | companyName | value | receptionDate |
      | GLADY       | 60.00 | 2022-09-29    |
      | WEDOOGIFT   | 50.00 | 2022-09-30    |
    Then I can check that the user whose name is "JOE DOE" has 150.00 euros in gift deposits and 110.00 euros in meal deposits

  Scenario: User with no gift and meal deposits
    Given The user whose name is "NO DOE" exists
    Then I can check that the user whose name is "NO DOE" has 0.00 euros in gift deposits and 0.00 euros in meal deposits