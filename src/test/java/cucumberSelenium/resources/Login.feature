Feature: Login Functionality

  Background:
    Given im on logging page


  Scenario: Login valid
    When i logging with valid phone and password
    Then i can click button Tôi bán to access to private dashboard

  Scenario: Wrong username and password
    When User input wrong username and password
    Then After four times wrong user get banned

  Scenario: User want to login with 3th party account
    Then Popup appear to login with Facebook
    And Popup appear to login with Google
    And Popup appear to login with AppleID

  Scenario Outline: Login invalid input
    When User input invalid username "<username>" and password "<password>"
    Then The message will show

    Examples:
      | username   | password |
      | 0198882323 | superpassword   |
      | dkajsdkajs | superpassword   |
      | @#!@123231 | superpassword   |
      | 0298882    | superpassword   |

