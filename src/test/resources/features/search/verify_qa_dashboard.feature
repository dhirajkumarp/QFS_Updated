@tag1
Feature: Verify QA Dashboard page
  I want to use this template for my feature file

  Background: Login feature
    Given login to application with admin

  @temp12
  Scenario: Verify content present on QA dashboard page
    When I click on QA Dashboard tab
    And I verify the page title
    And I verify the content present on page
    Then I validate the content present on page
    And user logout from application

  @temp1
  Scenario: Verify My Productivity section present on QA dashboard page
    When I click on QA Dashboard tab
    And I click on the My Productivity button
    Then I validate the My Productivity Popup window content
    And user logout from application

  @t5
  Scenario: Verify Cancel button on Popup window functionality
    Given Login to Application
    When I click on the My Productivity button
    And I click on the Cancel button
    Then Popup window should be closed on Cancel button click
    And user logout from application

  @t5
  Scenario: Verify Invalid date range selection in My productivity search area.
    Given Login to Application
    When I click on the My Productivity button
    And I select invalid date range
    And click on Go button
    Then Validation message should be shown for invalid date selection
    And user logout from application

  @t5
  Scenario: Verify valid date range selection in My productivity search area.
    Given Login to Application
    When I click on the My Productivity button
    And I select valid date range
    And click on Go button
    Then result grid should be display to user
    And user logout from application
