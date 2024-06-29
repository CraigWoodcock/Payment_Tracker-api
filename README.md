- [Payment Tracker Spring API](#payment-tracker-spring-api)
  - [Overview](#overview)


# Payment Tracker Spring API

## Overview

This is a java spring application that tracks payments for specific events. At the moment it is based on holiday's, but it could be applied to any event where there could be multiple people responsible for making payments.

The application will ask if the user wishes to view an existing holiday(payment plan/event) or if they wish to create a new holiday(payment plan/event).

when creating a new holiday, the user will be asked to enter a name for the event, ask the total cost, specify the amount of people that the cost should be split by and also it will ask for names of the people.

The total cost will then be split by the amount of people and the details will be stored in a mysql database.

The holiday can then be viewed when choosing existing holidays in the future and additional payments can be added to the tracker, the system will ask for the amount of the payment being made and the name of the person making the payment, the amount will be deducted from that persons running total.

