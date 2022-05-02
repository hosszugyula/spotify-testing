Feature: Spotify sign in page

  Background:
    Given the home page is opened
    #And the Cookie disclaimer is closed
    And the Bejelentkezés header button is clicked

  @requiredfield
  Scenario: Check required fields
    When the Bejelentkezés button is clicked
    Then the 'Incorrect username or password.' error message of the 'Email address or username' field should be shown
    And the 'Incorrect username or password.' error message of the 'Password' field should be shown

  Scenario Outline: Check the fields with invalid parameters
    When the '<field>' is filled in with '<parameter>' in the login form
    And the Tab button is pressed
    And the Bejelentkezés button is clicked
    Then the '<errorMessage>' error message of the '<field>' field on the login page should be shown

    Examples:
      | field                     | parameter | errorMessage                    |
      | Email address or username | asd       | Incorrect username or password. |
      | Email address or username | aaa123    | Incorrect username or password. |
      | Password                  | asd       | Incorrect username or password. |
      | Password                  | 123       | Incorrect username or password. |
      | Password                  | aaa123    | Incorrect username or password. |

  Scenario: Check invalid login name and password
    When the 'Email address or username' is filled in with 'valaki@gmail.com' in the login form
    And the 'Password' is filled in with 'asdasd123' in the login form
    And the Tab button is pressed
    And the Bejelentkezés button is clicked
    Then the 'Incorrect username or password.' error message of the 'E-mail cím vagy felhasználónév' field on the login page should be shown

  Scenario: Check valid login name and invalid password
    When the 'Email address or username' is filled in with 'szoft.teszt00@gmail.com' in the login form
    And the 'Password' is filled in with 'asdasd123' in the login form
    And the Tab button is pressed
    And the Bejelentkezés button is clicked
    Then the 'Incorrect username or password.' error message of the 'Jelszó' field on the login page should be shown

  Scenario: Check valid login name and password
    When the 'Email address or username' is filled in with 'szoft.teszt00@gmail.com' in the login form
    And the 'Password' is filled in with 'teszt1234' in the login form
    And the Tab button is pressed
    And the Bejelentkezés button is clicked
    Then navigate Main page