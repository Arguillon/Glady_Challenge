Feature: Check if a user can receive a meal deposit

  Scenario: User with multiple meal deposits
    Given The user whose name is "JESSICA DOE" exists
    When The user whose name is "JESSICA DOE" receives multiple meal deposits
      | companyName | value    | receptionDate |
      | GLADY       | 5000.00  | 2022-09-29    |
      | WEDOOGIFT   | 10000.00 | 2022-09-30    |
    Then I can check that the user whose name is "JESSICA DOE" has received multiple meal deposits
      | companyName | value    | receptionDate |
      | GLADY       | 5000.00  | 2022-09-29    |
      | WEDOOGIFT   | 10000.00 | 2022-09-30    |

  Scenario: User with multiple meal deposits and one expired
    Given The user whose name is "MISS DOE" exists
    When The user whose name is "MISS DOE" receives multiple meal deposits
      | companyName | value    | receptionDate |
      | GLADY       | 5000.00  | 2022-09-29    |
      | COMPANY_1   | 1.00     | 2000-09-29    |
      | WEDOOGIFT   | 10000.00 | 2022-09-30    |
    Then I can check that the user whose name is "MISS DOE" has received multiple meal deposits
      | companyName | value    | receptionDate |
      | GLADY       | 5000.00  | 2022-09-29    |
      | COMPANY_1   | 1.00     | 2000-09-29    |
      | WEDOOGIFT   | 10000.00 | 2022-09-30    |
    And That the user whose name is "MISS DOE" has 1 expired meal deposit