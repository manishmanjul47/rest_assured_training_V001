Feature: Get Operation
  Verify different GET operations using REST-Assured

  Scenario: Verify one author of the post
    Given An employee exists
    Then I should see first name as "Byron"
     And Status code should be 200
