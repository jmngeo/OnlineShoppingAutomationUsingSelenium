Feature: Search Product From Search BAR and add to cart
	As a visitor of the ecommerce website
	I want to search for products
	I want to see the details of the product
	So that I know if the product fits my needs
	So that I can quickly find what I am looking for
	I want to see an overview of products
	So that I can select a product that fits my needs

	@srch01
	Scenario: srch01- Do a valid search with a single keyword
		Given I am on the homepage to do a single keyword search
		Then I do a single keyword search for (...)

	@srch02
	Scenario: srch01 - Filtering the search result
		Given I have search a keyword and then i select from dropdown 
		Then I filter on (...)
		
	@srch03
	Scenario: pdp01 - Product detail page
		Given I select one of the items		 
		When I am on the Product detail page of the selected item
		Then I can see details of the product