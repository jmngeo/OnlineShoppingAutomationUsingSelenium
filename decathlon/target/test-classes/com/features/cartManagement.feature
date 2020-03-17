@cartManagement
Feature:  cart Management
	increasing products size by 1 in cart and proceeding to checkout
	and making the purchase only if Cash On Delivery Option is present else clear the cart.
	
		@cartEmptinessCheck
	  Scenario: To check if the cart is empty or not
    Given I am on homepage    
    When I click cart button
    Then I validate if the cart is empty or not
		
		@IncreasingProductQuantity
  	Scenario: increasing the product quantity by 1 for each product in cart
    Given I am on cart page   
    Then I increase the product quantity by one
    