Feature: Check if a user can receive a gift deposit

  Scenario: User with multiple gift deposits
    Given The user whose name is "JOHN DOE" exists
    When The user whose name is "JOHN DOE" receives multiple gift deposits
      | companyName | value  | receptionDate |
      | APPLE       | 50.00  | 2022-09-29    |
      | TESLA       | 100.00 | 2022-09-30    |
    Then I can check that the user whose name is "JOHN DOE" has received multiple gift deposits
      | companyName | value  | receptionDate |
      | APPLE       | 50.00  | 2022-09-29    |
      | TESLA       | 100.00 | 2022-09-30    |

  Scenario: User with multiple gift deposits and one expired
    Given The user whose name is "MISTER DOE" exists
    When The user whose name is "MISTER DOE" receives multiple gift deposits
      | companyName | value  | receptionDate |
      | APPLE       | 50.00  | 2022-09-29    |
      | MICROSOFT   | 50.00  | 2000-09-29    |
      | TESLA       | 100.00 | 2022-09-30    |
    Then I can check that the user whose name is "MISTER DOE" has received multiple gift deposits
      | companyName | value  | receptionDate |
      | APPLE       | 50.00  | 2022-09-29    |
      | MICROSOFT   | 50.00  | 2000-09-29    |
      | TESLA       | 100.00 | 2022-09-30    |
    And That the user whose name is "MISTER DOE" has 1 expired gift deposit