$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cartManagement.feature");
formatter.feature({
  "line": 2,
  "name": "cart Management",
  "description": "increasing products size by 1 in cart and proceeding to checkout\nand making the purchase only if Cash On Delivery Option is present else clear the cart.",
  "id": "cart-management",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@cartManagement"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "To check if the cart is empty or not",
  "description": "",
  "id": "cart-management;to-check-if-the-cart-is-empty-or-not",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@cartEmptinessCheck"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I am on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click cart button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I validate if the cart is empty or not",
  "keyword": "Then "
});
formatter.match({
  "location": "cartManagementTestSteps.i_am_on_homepage()"
});
formatter.result({
  "duration": 1709515200,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_cart_button()"
});
formatter.result({
  "duration": 2697722100,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_validate_if_the_cart_is_empty_or_not()"
});
formatter.result({
  "duration": 70091000,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "increasing the product quantity by 1 for each product in cart",
  "description": "",
  "id": "cart-management;increasing-the-product-quantity-by-1-for-each-product-in-cart",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@IncreasingProductQuantity"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "I am on cart page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I increase the product quantity by one",
  "keyword": "Then "
});
formatter.match({
  "location": "cartManagementTestSteps.i_am_on_cart_page()"
});
formatter.result({
  "duration": 21323700,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_increase_the_product_quantity_by_one()"
});
formatter.result({
  "duration": 13900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "To clear the cart if Cash On Delivery Payment Option is unavailable",
  "description": "",
  "id": "cart-management;to-clear-the-cart-if-cash-on-delivery-payment-option-is-unavailable",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@CheckOut"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "I am on the cart page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I click Proceed To CheckOut button",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I click on Select Delivery Options",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I select Home Delivery as Standard",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click Pay Securely",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I click on UPI/QR",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I navigate back to homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "I LogOut",
  "keyword": "And "
});
formatter.match({
  "location": "cartManagementTestSteps.i_am_on_the_cart_page()"
});
formatter.result({
  "duration": 5006995200,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_Proceed_To_CheckOut_button()"
});
formatter.result({
  "duration": 3135308700,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_on_Select_Delivery_Options()"
});
formatter.result({
  "duration": 12844016300,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_select_Home_Delivery_as_Standard()"
});
formatter.result({
  "duration": 7206348700,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_Pay_Securely()"
});
formatter.result({
  "duration": 8018809200,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_on_UPI_QR()"
});
formatter.result({
  "duration": 2204008400,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_navigate_back_to_homepage()"
});
formatter.result({
  "duration": 1520871900,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_LogOut()"
});
formatter.result({
  "duration": 30455114700,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d80.0.3987.132)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027ZANPAKUTO\u0027, ip: \u0027192.168.20.64\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.132, chrome: {chromedriverVersion: 80.0.3987.16 (320f6526c1632..., userDataDir: C:\\Users\\jomon\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:54758}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 3a145a1a7a6eeb178e4cc75bc2c7aa28\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat com.testDefinition.cartManagementTestSteps.i_LogOut(cartManagementTestSteps.java:121)\r\n\tat ✽.And I LogOut(cartManagement.feature:26)\r\n",
  "status": "failed"
});
formatter.uri("checkout.feature");
formatter.feature({
  "line": 1,
  "name": "Checkout",
  "description": "As a visitor of the ecommerce website\nI want to be able to do a purchase\nSo that I can get the product that I want",
  "id": "checkout",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 8,
  "name": "To clear the cart if Cash On Delivery Payment Option is unavailable",
  "description": "",
  "id": "checkout;to-clear-the-cart-if-cash-on-delivery-payment-option-is-unavailable",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@CheckOut"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I am on the cart page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I click Proceed To CheckOut button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on Select Delivery Options",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I select Home Delivery as Standard",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click Pay Securely",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I click on UPI/QR",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I navigate back to home page",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I log out",
  "keyword": "And "
});
formatter.match({
  "location": "cartManagementTestSteps.i_am_on_the_cart_page()"
});
formatter.result({
  "duration": 7383976600,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_Proceed_To_CheckOut_button()"
});
formatter.result({
  "duration": 4481472700,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_on_Select_Delivery_Options()"
});
formatter.result({
  "duration": 100228300,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_select_Home_Delivery_as_Standard()"
});
formatter.result({
  "duration": 7240099300,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_Pay_Securely()"
});
formatter.result({
  "duration": 8767719200,
  "status": "passed"
});
formatter.match({
  "location": "cartManagementTestSteps.i_click_on_UPI_QR()"
});
formatter.result({
  "duration": 2203581000,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});