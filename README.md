# Car Customization and Purchasing System
This project is a Car Customization and Purchasing System! 🚗💻 Built with data structures &amp; algorithms, it offers seamless vehicle customization &amp; purchase.

### | Contributors: [SarithRanathunge](https://github.com/SarithRanathunge) & [TharunPerera](https://github.com/TharunPerera)

## Overview of the project 🔍🔍🔍🔍
The car customization and purchasing system is a Java Swing project which primarily focuses on selecting a car to purchase and additionally adding customizations to it and then placing the order. 
The system is designed for the agents that purchase cars from a foreign manufacturer and deliver it to the customer’s address. The agent will be able to see a main screen which will display the cars. Each car has a different manufacturer from different countries. When a customer visits the shop requesting the car, the agent will click on the car and will be directed to the page where the car can be customized under several categories like body color, tires and rims, and more. The agent can select on the customization the customer requires and it will be added to the cart along with the car that was selected from the main screen. If the customer requests to view the customization options from the cheapest to the most expensive, this sorting technique is possible along with sorting from the most expensive customization to the cheapest and alphabetical order sorting. During the order process, the customer information is also gathered. Once the order is confirmed, the agent will place the order.Once the order has been placed, the order will be displayed to the Manufacturer under the customer’s name and information and by clicking on the customer name, the details of the order the customer made will be displayed. In addition, the customer will be notified and shown how long the order will take to be delivered to the customer along with the order details through email.


## Features of the project ⚙⚙⚙⚙🧩🧩🧩🧩
- *Inputs*
    - The branch agent can select the car and add it to the cart. 
    - The branch agent can select customization plans and add them to the cart. 
    - Customer information will be gathered and entered to the system. 
    - Default customization plans’ information will be entered to the system to perform input operations. 
    - Assumption that a new customization plan is available from the manufacturer, the branch manager can add the new plan to the system. 
    - Route information from the manufacturer to the branch and from branch to the customer’s location will be inserted for the shortest path algorithm. 

- *Processes*
    - Perform calculations to get the total cost (cost of car and customization items). 
    - Perform calculations to separate the advance pay from the total cost. 
    - Calculate the shortest route using the Dijkstra’s algorithm (from manufacturer to branch and from Branch to customer’s location). 
    - Calculate how long it will take for the order to be delivered to the customer. 
    - The branch manager can perform sorting techniques to effectively search for the customization plan based on the customer requirements (cheapest to expensive, expensive to cheapest or alphabetical order). 

- *Output*
    - Display the shortest path (From which country the car is coming from and display the duration taken to deliver the customized car to the customer). 
    - Display the ongoing orders that were made in the ongoing orders tab. 
    - Send an Email to the customer so the customer can view the order details. 
    - Output the calculated total bill.


## Data Structures and Algorithms 🧩💻🧩💻🧩💻🧩💻
- *Doubly Linked List:*
   
   The purpose: Purpose of using doubly linked list in our system is to dynamically insert customization plans into the structure. Multiple information can be stored inside one node of a linked list and the most important is its beneficial for efficient sorting because each node connects to the next and the previous which maintains the link of the list.
   
   Usage: Used in the system to efficiently store the customization plans of a car with details like the name and price dynamically. 

- *Singly Linked List:*
  
   The purpose: Purpose of a singly linked list is like the doubly as they both support dynamic insertion.
  
   Usage: This data structure is used to store the details of the order. Each order has a separate node, an order node and an Array node are passed into this data structure to maintain the order information alongwith the items inside it and the customer information that is both passed to the ongoing orders page. 

- *Merge Sort:*
  
    The purpose: The purpose of using merge sort is because it is one of the most efficient sorting techniques that use the Divide and Conquer technique and it is the most suitable for larger data sets. This sorting technique has a lower time complexity making it the most suitable and efficient to use.
   
     Usage: This sorting technique was applied in the project to make it efficient to sort the customization plan from cheapest to the most expensive, or from the most expensive to the cheapest or additionally, in alphabetical order, descending and ascending order. 

- *Dijkstra’s Algorithm:*
  
    The purpose: The purpose of this algorithm is to determine the shortest path from one Vertex to another. Each edge that connects the vertices has a weight and using this weight, the algorithm will determine the shortest path.
  
    Usage: This algorithm is used twice. Once to calculate the shortest path from the manufacturer of one car to the branch and the other is used to calculate the shortest path from the branch to the customer’s location.



