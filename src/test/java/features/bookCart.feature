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
@book
Feature: Adding a book to the cart

Background:
		Given i want to navigate to website
    And enter username as "ortoni" and password as "pass1234" 
    Then click the login button and validate the outcomes
  	
  Scenario Outline: login
  	And after the login search the "<book>" and click the first book
    Then check the cart and get title
    And add the book to the cart
    Then logout from the website  
	Examples:
		|book|
		|Birthday Girl|
		|A Dance with Dragons|
		|Harry Potter|
		
