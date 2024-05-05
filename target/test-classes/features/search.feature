#Author: Pavel Baitalik
#Email:  pavelbaitalik@gmail.com
Feature: Homepage Loading

  Background: Open OneMap URL
    Given User navigates to the OneMap website

  @smoke @search
  Scenario Outline: Verify that the user is able to enter the place name into the search field and Check that the selected place should be displayed on the screen with detailed information.
    When User enters a place name "<Place Name>" into the search field
    And Hit enter
    Then The selected place "<Place Name>" should be displayed on the screen with detailed information

    Examples: 
      | Place Name   |
      | MARINA SOUTH |

  @smoke @search @autoSuggestive
  Scenario Outline: Verify that the user is able to enter the place name into the search field select from auto suggestive dropdown and Check that the selected place should be displayed on the screen with detailed information.
    When User enters a place name "<Place Name>" into the search field
    And User selects the suggested place "<suggested place>" from the search results
    Then The selected place "<suggested place>" should be displayed on the screen with detailed information

    Examples: 
      | Place Name   | suggested place    |
      | MARINA SOUTH | MARINA SOUTH DRIVE |

  @smoke @search @autoSuggestive @route
  Scenario Outline: User plans a route from point A to point B and check whether we are getting proper route or not
    When User selects the route planning button
    And User enters name "<Starting Name>" as the starting location
    Then The selected place "<Starting Name>" should be displayed on the screen with detailed information
    And User enters name "<Destination Name>" as the destination
    Then The selected place "<Destination Name>" should be displayed on the screen with detailed information
    And verify step-by-step directions should be visible for Transit, Bus, Car, Cycle,Walk

    Examples: 
      | Starting Name     | Destination Name   |
      | MARINA EAST DRIVE | MARINA SOUTH DRIVE |
