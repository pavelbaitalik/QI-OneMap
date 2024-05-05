#Author: Pavel Baitalik
#Email:  pavelbaitalik@gmail.com
Feature: Homepage Loading

  Background: Open OneMap URL
    Given User navigates to the OneMap website

  @smoke
  Scenario: Verify successful loading of the homepage/OneMap URL
    When The homepage is loaded
    Then The homepage should be displayed and page title should be Mached with "OneMap"

  
