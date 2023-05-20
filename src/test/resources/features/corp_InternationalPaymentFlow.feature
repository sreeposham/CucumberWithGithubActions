@autopoc
Feature: Corp suite portal - International payments
		
@international
      Scenario Outline: Verify navigation to International payments page
      Given I landed on Corp portal Login Page
      When I'm Logged in to the Corp portal
      Then I verify Dashboard page is displayed
      When I click "<button>" button on Dashboard page
      Then I verify "<tilte>" page is displayed
      #When I enter buying "<amount>" and "<currency>" on Exchange page
      #And I click "Next" button on Exchange page
      #Then I verify "Exchange review" page is displayed
      #And I verify Exchange details on Exchange review page
      #When I click "Confirm Exchange" button on Exchange page
      #Then I verify Success modal is displayed
      #Then I verify Exchange details on Success modal
      #When I click "Done" on Success modal
      #Then I verify Dashboard page is displayed
#			Then I navigate to Transactions page      
#			And I verify "Foreign Exchange" record on Transactions page.
			
      Examples:
        | button    |tilte|
        | International payments      |International payments|