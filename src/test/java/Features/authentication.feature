Feature: Authentication using OTP

  @automated
  Scenario: 1-Launching the app opens LoginPage
    Given the user has the app installed
    When the user launches the app
    Then user sees loginpage

  @automated
  Scenario Outline: 2-Login with Invalid PhoneNumber
    Given the user has the app installed
    When the user launches the app
    Then user sees loginpage
    When enters countrycode as "<country>"
    And enters phonenumber as "<phonenumber>"
    And clicks continue
    Then login should fail with error "<error>"

    Examples: 
      | country       | phonenumber | error                                                                 |
      | Germany       |          44 | That phone number isn’t valid, are you sure you entered it correctly? |
      | Bhutan        | 16200000001 | That phone number isn’t valid, are you sure you entered it correctly? |
      | United States |             | That phone number isn’t valid, are you sure you entered it correctly? |

  @automated
  Scenario: 3-Navigate back from OTP Page
  ## - BDD will fail because of below Bug :
  ## Countrycode not retaining when user navigates back from OTP to Login Screen
    Given the user has the app installed
    When the user launches the app
    And enters countrycode as "Germany"
    And enters phonenumber as "16200000001"
    And clicks continue
    Then user sees otppage
    When user clicks back
    Then countrycode is "+49"
    And phonenumber is "16200000001"

  @automated
  Scenario: 4-Login with Incorrect OTP
    Given the user has the app installed
    When the user launches the app
    And enters countrycode as "Germany"
    And enters phonenumber as "16200000001"
    And clicks continue
    Then user sees otppage
    When user enters otp as "1235"
    Then login should fail with error "The code you entered was incorrect, are you sure you entered it correctly?"

  @automated
  Scenario: 5-Login with valid phone number and valid otp
    Given the user has the app installed
    When the user launches the app
    And enters countrycode as "Germany"
    And enters phonenumber as "16200000001"
    And clicks continue
    Then user sees otppage
    When user enters otp as "1234"
    Then user sees welcomemessage "Welcome to Choco!!"

  @automated
  Scenario: 6-Navigate back from WelcomePage
  ## - BDD will fail because of below Bug :
  ##   Navigating back from Welcomepage closes the app , instead should navigate to LoginScreen
    Given the user has the app installed
    When the user launches the app
    And enters countrycode as "Germany"
    And enters phonenumber as "16200000001"
    And clicks continue
    Then user sees otppage
    When user enters otp as "1234"
    Then user sees welcomemessage "Welcome to Choco!!"
    When user clicks back
    Then user sees loginpage

  @manual
  Scenario: 7-OTP Page shows Number Keyboard
   ## - BDD will fail because of below Bug : 
   ## - Keyboard not displayed as expected , user has to navigate back and return to see the Keyboard
    Given the user has the app installed
    When the user launches the app
    And enters countrycode as "Germany"
    And enters phonenumber as "16200000001"
    And clicks continue
    Then user sees otppage
    And Number Keyboard is available
    And user can manually enter otp
