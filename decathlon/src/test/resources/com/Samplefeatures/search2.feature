
Feature: Search
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
		When I do a single keyword search for (...)
		Then I see a single keyword search result page with more than zero results

	@srch02
	Scenario: srch01- Do a valid search with multiple keyword
		Given I am on the homepage to do a search with multiple keywords
		When I do a multiple keyword search for (... ...)
		Then I see a multiple keyword search result page with more than zero results

	@srch03
	Scenario: srch01 - Filtering the search result
		Given I have done a search using a valid search term
		And I see a certain amount of items
		When I filter on (...)
		Then The results are filtered to display a smaller amount of items
		

	@srch04
	Scenario: pdp01 - Product detail page
		Given I am on a product lister page
		When I select one of the items
		Then I am on the Product detail page of the selected item
		And I can see details of the product

	
		@srch05
	Scenario: plp01 - Navigating to a Product lister page
		Given I am on the homepage where I can go to a product lister page
		When I select a Product lister page from the menu
		Then I am on the Product lister page

	@srch06
	Scenario: plp02 - Filtering on the Product lister page
		Given I am on a Product lister page
		When I select the filter (...)
		And I click the button to confirm filtering
		Then the page is filtered to only show (...) products