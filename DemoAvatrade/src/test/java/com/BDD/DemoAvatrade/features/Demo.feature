Feature: Demo

@smoke
  Scenario: Demo_Create account and Verify the newly added favorite cryptos in favorites tab
    Given I opned demo url
    Then I create demo account
    Then I navigate to Trade tab
    Then I navigate to Crypto option
    Then I mark some of the crypto as my favorite
    Then I navigate to favorite option
    Then I verify the newly favorite cryptos in favorites tab
    
    

