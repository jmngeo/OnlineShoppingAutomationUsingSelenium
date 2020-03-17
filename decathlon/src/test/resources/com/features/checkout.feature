Feature: Checkout
	As a visitor of the ecommerce website
	I want to be able to do a purchase
	So that I can get the product that I want


    @CheckOut
    Scenario: To clear the cart if Cash On Delivery Payment Option is unavailable
    Given I am on the cart page    
    And I click Proceed To CheckOut button
    And I click on Select Delivery Options
    And I select Home Delivery as Standard
    When I click Pay Securely 
    And I click on UPI/QR
    Then I navigate back to homepage
    And I LogOut

	@check02
	Scenario: check02 - Checkout with incorrect delivery details
		Given I have added an item to my shopping bag
		And I click the shopping bag icon
		When I proceed to check out
		And I select a payment method
		And I enter invalid details
		And I click the pay button
		Then I receive feedback that the purchase details are incorrect
		
