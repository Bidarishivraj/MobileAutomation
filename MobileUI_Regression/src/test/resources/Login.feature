Feature: Login scenarios

  @TC-01
  Scenario: Login with valid username
    Given Open the Qure mobile app
    And Select the region "Global/Others"
    And Click on login button
    #And Click on Use without account button on browser
    And Enter email address "shivraj_alpha@qure.ai"
    And Enter password "@Qure123456"
    And Click on signin
    And Click on login button
    And Click on Settings button
   # And Click on Enable notifications

  @TC-02
  Scenario: Adding Male Patient
    Given Open the Qure mobile app
    And Select the region "Global/Others"
    And Click on login button
    And Enter email address "shivraj_alpha@qure.ai"
    And Enter password "@Qure123456"
    And Click on signin
    And Click on login button
    #And Enter email address "shivraj_alpha@qure.ai"
    #And Enter password "@Qure123456"
    #And Click on signin
    #And Click on login button
    #And Click on Settings button
    And Click on Add button
    #And Enter "Male" Patient details
    #And Click on Register button

