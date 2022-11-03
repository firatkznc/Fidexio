@Logout
  Feature: Logout Functionality
    User Story :
    As a user, I should be able to log out.

    1- User can log out and ends up in login page.

    2- The user can not go to the home page again by clicking the step back button after successfully logged out.

    Background: Users are already on the main page after login to the page successfully
      Given the user logged in as "posmanager"

      Scenario: User can log out and ends up in login page.
        When user clicks the username module on the right upper
        Then user clicks the logout button
        And user lands on the login page

        Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
          When user clicks the username module on the right upper
          Then user clicks the logout button
          Then user lands on the login page
          Then user clicks the step back button
          And user can not go back to the home page





