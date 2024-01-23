#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: login functionality

  Background:
  Given I want to navigate to website
  
  Scenario Outline: login
  
    And send keys to userName as "<user>" and password as "<Password>"
    And click the login button
    Then I validate the outcomes
    Examples:
    |user|Password|
    |student|Password123|
    |incorrectUser|Password123|
    |student|incorrectPassword |
    
    
 
