Feature: Hotel Booking
  Verify if user is able to Book the Hotel

   Scenario: Hotel booking
    Given User is on homepage
    When Enter the id and Pass
    And  I want to login
    When I want to Book the Hotel
    And  I select the options
    When Entering user info
    And I want to make Payment
    And I want to book the hotel
    Then I verify the Hotel is booked or not 