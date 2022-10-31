@FIDE-1449
Feature: Login Functionality

  1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)

  2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

  3- "Please fill out this field" message should be displayed if the password or username is empty

  4-User should see the password in bullet signs by default

  5- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.

  Background: For the scenarios in feature file, user is expected to be on login page
    Given user is on the library login page

  @FIDE-1444
  Scenario Outline: Login with valid credentials.(2 user: PosManager, SalesManager)
    When "<user type>" enters username
    And user type enters "<password>"
    And user clicks the login button
    Then user is on the home page and verify with "<user text>"

    Examples:
      | user type               | password     | user text      |
      | posmanager7@info.com    | posmanager   | POSManager7    |
      | posmanager17@info.com   | posmanager   | POSManager17   |
      | salesmanager7@info.com  | salesmanager | SalesManager7  |
      | salesmanager17@info.com | salesmanager | SalesManager17 |

  @FIDE-1445
  Scenario Outline:  "Wrong login/password" should be displayed for invalid credentials
    When "<user type>" enters username
    And  user type enters "<password>"
    And user clicks the login button
    Then user gets the message that "Wrong login/password"

    Examples:
      | user type               | password     |
      | abc123@info.com         | posmanager   |
      | posmanager17@info.com   | albert       |
      | fener1907@info.com      | salesmanager |
      | salesmanager17@info.com | kawhi        |

  @FIDE-1446
  Scenario Outline:  "Please fill out this field" message should be displayed if the password or username is empty
    When users leave on empty  "<user type>" or "<password>" input box
    And user clicks the login button
    Then user should be able to see the message that "Please fill out this field"

    Examples:
      | user type              | password     |
      | salesmanager7@info.com |              |
      |                        | salesmanager |
      | posmanager17@info.com  |              |
      |                        | posmanager   |
      |                        |              |


    @FIDE-1447
    Scenario: User should see the password in bullet signs by default
      When users enter the password
      Then users see the password with bullet sign


    @FIDE-1448
    Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
      When users enter the password
      And users enter the username
      And users press the enter keyword
      Then user go to the main page







