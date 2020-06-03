@smoke
Feature: Add functionality

  Scenario Outline: Verify the user credentials
    Given I hit on the URL of login
    Then Click on the Login icon
    Then I fill the "<User name>"and"<Password>"
    And I clicked on the Signin icon
    Examples:
      | User name       | Password |
      | FSAdministrator | FSA@2018 |


  Scenario: To verify the add functionality without filling all the mandatory fields

    Then click on the configTools
    And click on the Product
    Then click on the hide button
    And Click on the Add button
    Then Fill the required fields one by one
      | Name | Value | Measure Unit | Duration | L range | Storm drain | Active |
      | ABC  | 01    | briquet      | 2        | 1       | True        | True   |
    And Click on the save button
