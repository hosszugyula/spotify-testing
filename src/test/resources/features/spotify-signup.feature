Feature: Spotify sign up page

  Background:
    Given the home page is opened
      #And the Cookie disclaimer is closed
      And the Regisztráció header button is clicked

    @requiredfield
  Scenario: Check required fields
    Given it is scrolled down
    When the Regisztráció button is clicked
    Then the 'You need to enter your email.' error message of the 'Enter your email.' field should be shown
      And the 'You need to confirm your email.' error message of the 'Enter your email again.' field should be shown
      And the 'You need to enter a password.' error message of the 'Create password.' field should be shown
      And the 'Enter a name for your profile.' error message of the 'Enter a profile name.' field should be shown
      And the 'Select your birth month.' error message of the 'Month' field should be shown
      And the 'Enter a valid day of the month.' error message of the 'DD' dropdown should be shown
      And the 'Enter a valid year.' error message of the 'YYYY' dropdown should be shown
      And the 'Select your gender.' error message of the 'Male, Female, Non-binary' radio buttons should be shown
      And the 'Please accept the terms and conditions to continue.' error message of the 'privacy policy' checkbox should be shown
      And the 'Confirm you're not a robot.' error message of the 'captcha' field should be shown

  Scenario Outline: Check the fields with invalid parameters
    When the '<field>' is filled in with '<parameter>'
      And the Tab button is pressed
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field                    | parameter         | errorMessage                                                         |
      | Enter your email.        | wrongtest         | This email is invalid. Make sure it's written like example@email.com |
      | Enter your email.        | 123456789         | This email is invalid. Make sure it's written like example@email.com |
      | Create password.         | aaab              | Your password is too short.                                          |
      | DD                       | bc                | Enter a valid day of the month.                                      |
      | YYYY                     | aaaa              | Enter a valid year.                                                  |

    @email
  Scenario: Fill email fields with valid but not equal values
    When the 'Enter your email.' is filled in with 'hosszugyula456@gmail.com'
      And the 'Enter your email again.' is filled in with 'acsi_milan@gmail.com'
      And the Tab button is pressed
    Then the 'The email addresses don't match.' error message of the 'Enter your email again.' field should be shown

    @day
  Scenario: Fill day field with valid format but non-existent month number
    When the 'DD' is filled in with '32'
      And the Tab button is pressed
    Then the 'Enter a valid day of the month.' error message of the 'DD' field should be shown

    @yearlessthan1900
  Scenario: Fill year field with valid format but with a date less than 1900
    When the 'YYYY' is filled in with '1899'
      And the Tab button is pressed
    Then the 'Enter a valid year.' error message of the 'YYYY' field should be shown

    @nottooold
  Scenario: Fill year field with valid format but the user don't meet Spotify's age requirements
    When the 'YYYY' is filled in with '2023'
      And it is scrolled down
      And the Regisztráció button is clicked
    Then the 'Sorry, you don't meet Spotify's age requirements.' error message of the 'YYYY' field should be shown

    @happypath
    Scenario: Check a valid registration
      When the 'Enter your email.' is filled in with 'random8888234@gmail.com'
      And the 'Enter your email again.' is filled in with 'random8888234@gmail.com'
      And the 'Create password.' is filled in with 'Kiskulacs12'
      And the 'Enter a profile name.' is filled in with 'Randomka885'
      And the 'YYYY' is filled in with '2000'
      And the month selector is clicked
      And the 'Month' is filled in with 'J'
      And the 'DD' is filled in with '10'
      And the male of gender options selected
      And it is scrolled down
      And the accept the terms and conditions is clicked
      #And the i'm not a robot is clicked
      Then the Regisztráció button is clicked