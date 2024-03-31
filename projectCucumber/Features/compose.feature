Feature: Gmail Compose Functionality

  Scenario: Verify Compose Button Functionality
    Given I am on the Gmail inbox page
    When I click on the "Compose" button
    Then a new email composition window should be opened

  Scenario: Verify Recipient Field
    Given I am composing a new email
    When I enter a valid email address in the recipient field
    Then the email address should be accepted and displayed properly

  Scenario: Verify Subject Field
    Given I am composing a new email
    When I enter a subject in the subject field
    Then the subject should be entered and displayed properly

  Scenario: Verify Message Body
    Given I am composing a new email
    When I enter a message in the message body field
    Then the message should be entered and displayed properly

  Scenario: Verify Attachment Functionality
    Given I am composing a new email
    When I attach a file to the email
    Then the file should be successfully attached

  Scenario: Verify Send Functionality
    Given I am composing a new email
    When I enter recipient, subject, and message body
    And I click on the "Send" button
    Then the email should be sent successfully and appear in the sent items folder
