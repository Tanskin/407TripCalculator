# 407 Trip Calculator

## Exercise

Create a simple toll calculator Write a program that calculates the cost of a vehicle driving from one point on 407ETR, to another point. For this exercise, the toll rate will be $0.25/km . Please use the file interchanges.json to calculate the distances between interchanges.


## Assumptions

- Valid JSON file format
- The first route always has the distance to the next interchange in the list


## Tests

Open CMD in the main folder with Maven installed and use 'mvn clean test' to run the unit tests. I have included the following tests for both the distance and cost.

QEW -> Salem Road
Britannia Road -> Leslie Street
Salem Road -> QEW
QEW -> Bronte Road


## Running the program

Open CMD in the main folder and use 'java -cp TripCalculator.jar TripParser' to run the app. It will ask for a start and ending interchange and output the results in console.
