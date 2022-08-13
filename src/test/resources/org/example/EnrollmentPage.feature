Feature: Enrollment Page
  These test will verify the functionality of the enrollment page

  Scenario: Valid personal information test
    Given I am on the sign up page
    When I introduce the required data
    And I press next button
    Then we should be taken to the contact information section

  Scenario: Valid contact information test
    Given I am on the contact information section
    When I introduce the required information
    And I press next button from the contact information section
    Then we should be taken to the course options

  Scenario: Valid course options test
    Given I am on the course options section
    When I select Software Testing - Manual tester certificate
    And I press next button from the course options
    Then we should be taken to the payment information

  Scenario: Invalid personal
    Given I am on the enrollment page
    When I press next button without introduce data
    Then an red error message will appear under every data case
