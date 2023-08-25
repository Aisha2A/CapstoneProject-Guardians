@testThree
Feature: Retail Order Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'aisha@tekschool.us' and password 'Aisha@12345'
    And User click on login button
    And User should be logged in into Account

  @additem
  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item ' kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  @addingaddresswithorder
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to the 'Electronics'
    And User search for the item ' Apex Legends '
    And User clicks on Search icon
    And User clicks on item
    And User selects quantity '5'
    And User clicks add to Cart button
    Then the cart icon quantity should changed to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a confirmation message should be displayed 'Order Placed, Thanks'

  @cancelorder
  Scenario: Verify User can cancel the order
    And User click on Orders section
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancelation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then a cancelation message should be displayed 'Your Order Has Been Cancelled'

  @addingaddresswithorder
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to the 'Electronics'
    And User search for the item ' Apex Legends '
    And User clicks on Search icon
    And User clicks on item
    And User selects quantity '5'
    And User clicks add to Cart button
    Then the cart icon quantity should changed to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a confirmation message should be displayed 'Order Placed, Thanks'

  @returnorder
  Scenario: Verify User can Return the order
    And User clicks on Orders section
    And User clicks on first order in list
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then the cancelation message should be displayed 'Return was successful'

  @revieworder
  Scenario: Verify User can write a review on order placed
    And User click on Orders sections
    And User click on first order in the list
    And User click on Review button
    And User write Review headline ' headline value' and 'review text'
    And User click Add your Review button
    Then a review message should be displayed ‘Your review was added successfully’
