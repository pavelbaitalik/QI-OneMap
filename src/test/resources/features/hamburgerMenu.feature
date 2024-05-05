#Author: Pavel Baitalik
#Email:  pavelbaitalik@gmail.com
Feature: Hamburger menus

  Background: Open OneMap URL
    Given User navigates to the OneMap website

  @smoke @hb
  Scenario: verify Hamburger Menu Functionality
    When User clicks on the hamburger menu icon
    Then User should see the hamburger menu open
    And user should see navigation menus

  @smoke @hb
  Scenario: verify Hamburger Menu Functionality
    When User clicks on the hamburger menu icon
    Then User should see the hamburger menu open
    And user should see navigation menus
    Then click on Drone Query menu option
    And verify that is opening


