

Feature: API test


  Scenario Outline: validate the response with post request
    When user enter the base url "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com" with passing the mandatory fields
    Then user get the response status code as <status code> and get the success message as "<message>"

    Examples:
      |status code|message|
      |201        |Entity created successfully!|

  Scenario Outline: validate the response with Get request
    When user enter the base url "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com" with passing the mandatory fields
    Then get the response with status code as <status code>

    Examples:
    |status code|
    |200        |
  @SmokeTest
  Scenario Outline: validate the politician information
    When user enter the base url "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com" with passing the mandatory fields
    Then user get the response status code as <status code> and get the politician information as "<country>","<created date>","<name>","<position>",<risk> and <yob>

    Examples:
    |status code|country|created date|name|position|risk|yob|
    |200        |UK     |2019-10-01  |Yellow|Wood  |6   |0  |
    |200        |UK     |2019-10-01  |Yellow|Wood  |6   |1985 |


