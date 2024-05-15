
@tag
Feature: To create Query Request With GraphQL
  

  @tag1
  Scenario Outline:
: To get Query Data for user
    Given user has to access the endpoint url "/learn/graphql"
    When user creates a queryrequest using data "<dataKey>" from JSON file "<JSONFile>" 
    Then user should get the response code 200
    
    Examples: 
      | dataKey        | JSONFile         |
      | query          | queryRequest.json |
      