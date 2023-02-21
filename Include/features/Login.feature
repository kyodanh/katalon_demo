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
@tag
Feature: kiểm tra tính năng login của hệ thống

  @Valid
  Scenario Outline: Check login successful
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |


  #@invalid
  #Scenario Outline: Check login failed
    #Given user is on login page
    #When user input wrong <username> and <password>
    #And clicks on login button
    #Then there is notifivation worng password
#
    #Examples: 
      #| username | password |
      #| admin    | admin    |
#
  #@lockuser
  #Scenario Outline: Check user blocked
    #Given user is on login page
    #When user input <username> and <password> has been block
    #And clicks on login button
    #Then there is notifivation that account has been lock
#
    #Examples: 
      #| username        | password     |
      #| locked_out_user | secret_sauce |
      #

      
