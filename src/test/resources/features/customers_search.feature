@AdminPortalautopoc
Feature: Search for customer
		

      Scenario Outline: Search customer by Phone number and promote the customer to the Business
      Given I'm Logged in to the Admin portal
      When I navigated to the "<leftmenu>" page
      When I search customer by "<country>" and "<phone>" in the Customers page
      #Then I verify customer registered with "<phone>" in the Customers page
      When I view the customer overview page of customer registered with "<phonenumber>"
      When I open Promote to business form for the customer
      And I fill the business details on Promote to business form for the customer "<businessdetails>"
      And I submit the business details for the customer to Promote to business
      And I update the "Business verification status" to "Approved" with note "Testing" 
      #And I submit the business details for the customer to Promote to business
      Then I verify user is promoted to business successfully
      Examples:
        | leftmenu    |country|phone|phonenumber|businessdetails|
        | Customers      |United Kingdom|7700000071|+447700000071|business registration name=Automation Ltd,business registration id=BR202304281200,Registered country=United Arab Emirates,business operations type=Auto Spare Parts,legal business type=Joint Venture,business address=Dubai Mall,busines city=Dubai,business postal code=50001,business province state=Dubai State,Expected monthly turnover amount=2000000,turnover currency=AED|
