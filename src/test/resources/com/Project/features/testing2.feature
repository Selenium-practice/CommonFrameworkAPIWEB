@tag11
Feature: Title of your feature
@tag112
Scenario Outline: Searching with selenium for a term with submit

    Given I am on wikipedia.com
    When I enter word '<keyword>'
    And I click submit button
    Then I should see keyword results: '<keyword>'

     Examples:
     {'datafile':'C:\Users\42131\Documents\data.csv'}
     |keyword|
     
     
   @tag117
Scenario Outline: Searching with selenium for a term with submit

    Given I am on wikipedia.com
    When I enter word "<keyword>"
    And I click submit button
    Then I should see keyword results "<keyword>"

     Examples:
    # @excel|C:\Users\42131\Documents\data.xlsx|sheet=Sheet1|
     |keyword|
     
       
