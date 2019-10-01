Feature: End to En scenario for placing order

@Order @One
Scenario: verify whether the user is able to place order

	Given I login to the application
	When I add a product to the cart and checkout
	And I place an order
	Then I should see the order is place successfully