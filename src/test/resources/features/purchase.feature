       Feature: Adidas Order Placement Functionalities
         Agile story: As a user i should be able to place order from Website


         Scenario: placing a successful order
           Given user is on the home page
           When user adds "Sony vaio i5" from "Laptops"
           And user adds "Dell i7 8gb" from "Laptops"
           And user removes "Dell i7 8gb" from the cart
           And user places order and captures logs purchase ID and Amount
           Then user verifies purchase amount eqauls expected

