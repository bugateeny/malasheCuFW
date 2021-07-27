#@Regression #  Runs all scenarios
Feature:Check whether a visa is required to visit the UK

  Scenario:Japan nationalities coming to study for more than 6 months

    Given User is on the UKBA website
    When User chooses "Japan" nationality
    And User clicks on Continue button
    And User selects the "Study"  as reason for coming to UK
    And User clicks on Continue button
    And User chooses option of longer than 6 months
    And User clicks on Continue button
    Then User should be informed that "You’ll need a visa to study in the UK"

#  @TestToRunNext
  Scenario Outline:Multiple nationalities coming to study for more than 6 months

    Given User is on the UKBA website
    When User chooses "<CountryName>" nationality
    And User clicks on Continue button
    And User selects the "Study"  as reason for coming to UK
    And User clicks on Continue button
    And User chooses option of longer than 6 months
    And User clicks on Continue button
    Then User should be informed that "You’ll need a visa to study in the UK"

    Examples:

      | CountryName |
      | Wales       |
      | Nigeria     |
      | Morocco     |
      | USA         |
      | North Korea |
      | Ghana       |


