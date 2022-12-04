Feature: Agency management

  @E2E @Post @Success
  Scenario Outline: Add agency succeeded
    Given a valid agency "<requestBody>"
    When  submit, a new agency should be added to catalog
    Then  we should verify the added agency is equal to "<responseBody>"
    And   we should map in "<mapCaseToId>" the saved agency id
    And   response status should be succeeded "<statusCode>" and message "<responseMsg>"
    Examples:
      | mapCaseToId    | requestBody              | responseBody              | statusCode | responseMsg                 |
      | ADD_UC_SUCCESS | add_success_request.json | add_success_response.json | 200        | Agency created successfully |


  @E2E @Post @Fail @Conflict
  Scenario Outline: Add agency failed - Conflict Error
    Given a valid agency "<requestBody>"
    When  submit, an exception should be throw
    Then  response status should be conflict  "<statusCode>" and message "<reasonMsg>"
    Examples:
      | requestBody                 | statusCode | reasonMsg                                  |
      | add_conflicted_request.json | 401        | Conflict : Agency with current name exists |


  @E2E @Post @Fail @AccessDenied
  Scenario Outline: Add agency failed - Access Denied
    Given a valid agency "<requestBody>"
    When  user "<userRoles>" submit, an exception should be throw
    Then  response status should be access denied  "<statusCode>" and message "<reasonMsg>"
    Examples:
      | requestBody                 | statusCode | reasonMsg                             |
      | add_conflicted_request.json | 403        | Access denied : Could not save agency |


  @E2E @Post @Fail
  Scenario Outline: Add agency - Is not published after save
    Given a valid agency "<requestBody>"
    When  submit, a new agency should be added to catalog
    Then  we should verify the added agency is publish "<publishStatus>"
    Examples:
      | requestBody      | publishStatus |
      | add_request.json | true          |


  @E2E @Post @Fail
  Scenario Outline: Add agency - Code format is not valid
    Given a valid agency "<requestBody>"
    When  submit, an exception should be throw
    Then  response status should be bad request  "<statusCode>" and message "<reasonMsg>"
    Examples:
      | requestBody      | statusCode | reasonMsg                             |
      | add_request.json | 403        | Access denied : Could not save agency |


  @E2E @Post @Fail @BadRequest
  Scenario Outline: Add agency - Bad Request
    Given an invalid agency "<requestBody>"
    When  submit, an exception should be throw
    Then  response status should be bad request  "<statusCode>" and message "<reasonMsg>"
    Examples:
      | requestBody      | statusCode | reasonMsg   |
      | add_request.json | 400        | Bad Request |


