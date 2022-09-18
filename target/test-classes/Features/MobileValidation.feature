#Author: krithick.email@your.domain.com
Feature: Mobile validation

  Scenario: Mobile validation
    Given user launches flipkart application
    And user handles the login
    When user search mobile 
    And user select the mobile and click add to cart
    And user doing the payment
    Then user recieve the confirmation message

  Scenario: Mobile validation
    Given user launches flipkart application
    And user handles the login
    When user search mobile in oneD
      | SONY | SAMSUNG | Panasonic |
    And user select the mobile and click add to cart
    And user doing the payment
    Then user recieve the confirmation message
