# Fawry Challenge –  E-Commerce System

## Project Overview

This is a console-based Java application built as part of the Fawry Rise Full Stack Development Internship Challenge.

The system simulates a basic e-commerce flow with support for:

-   Multiple types of products (some expire, some require shipping)
-   Cart management
-   Checkout process
-   Shipping service integration
-   Console-based output

## Features

-   Products can have a name, price, and quantity
-   Some products may expire (e.g., Cheese, Biscuits)
-   Some products require shipping and provide a weight (e.g., TV, Cheese)
-   Customers can add products to their cart
-   Customers can perform checkout, which:
    -   Calculates subtotal
    -   Adds shipping fees if applicable
    -   Deducts the total from customer balance
    -   Prints receipt and shipping summary
-   Error handling for:
    -   Expired products
    -   Out-of-stock items
    -   Empty cart
    -   Insufficient customer balance

## Technologies Used

-   Java 24
-   Maven (project management & build tool)
