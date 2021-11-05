# 407 Trip Calculator

## Exercise

*Redacted for privacy*


## Assumptions

- Valid JSON file format
- The first route always has the distance to the next interchange in the list


## Tests

Open CMD in the main folder with Maven installed and use 'mvn clean test' to run the unit tests. I have included the following tests for both the distance and cost.

* QEW -> Salem Road
* Britannia Road -> Leslie Street
* Salem Road -> QEW
* QEW -> Bronte Road

![Example](https://i.gyazo.com/ec146a0d4a9a1822aa141840df34fce2.png)


## Running the program

Open CMD in the main folder and use 'java -cp TripCalculator.jar TripParser' to run the app. It will ask for a start and ending interchange and output the results in console.

![Example](https://i.gyazo.com/f4b496ded661ae7dbe91b6d2967a5885.png)
