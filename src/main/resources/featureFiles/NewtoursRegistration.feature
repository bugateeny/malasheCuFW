Feature: Registration to Newtours website

  @Registration
  Scenario Outline: Register  by entering only user  information

    Given User is on Newtours register landing page
    When User clicks on the Register link
    And User enters "<Username>",  and  "<password>" and confirm "<cPassword>"
    And User clicks submit button
    Then confirmation page is displayed with users "<Username>"

    Examples:
      | Username       | password | cPassword |
      | buga@gmail.com | Buga1234 | Buga1234  |


  @NegativeTest
  Scenario Outline: Register by enters INVALID password when confirming password

    Given User is on Newtours register landing page
    When User clicks on the Register link
    And User enters "<Username>",  and  "<password>" and enter invalid password "<iPassword>"
    And User clicks submit button
    Then an error message is displayed "PAssword and con.password does not match"
    Examples:
      | Username       | password | iPassword |
      | buga@gmail.com | Buga1234 | Buga1238  |

  @TestToRunNext
  Scenario Outline: Register by entering only User Information
    Given User is on the Newtours website "http://demo.guru99.com/selenium/newtours/"
#    Given User is on Newtours register landing page
    When User clicks on the Register link
    And  User enters "<Username>",  and  "<password>" and confirm "<cPassword>"
    And User clicks submit button
    Then confirmation page is displayed with users "<Username>"

    Examples:
      | Username    |password|cPassword|
      | Jose1234    |buga122 |buga122  |
#      | Jose1234*!5 |buga333 |buga333  |
#      | Jose1234%3  |byfa55  |byfa55   |
#      | PSKJ78-     |buga6767|buga6767 |


  @NegativePath
  Scenario Outline: Register by entering incorrect password for confirm password throws error
    Given User is on the Newtours website "http://demo.guru99.com/selenium/newtours/"
    When User clicks on the Register link
    And  User enters "<Username>",  and  "<password>" and confirm invalid password "<iPassword>"
    And User clicks submit button
    Then confirmation page should not be displayed
    And "error message is displayed

    Examples:
      | Username    |password|iPassword|
      | Jose1234    |buga122 |buga123  |