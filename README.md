# Avaj Launcher
This is the first project in a series of 4 projects with a focus on Java and the first
project created by Academy+Plus.

You will have to implement a minimal aircraft simulation program based on a given
UML class diagram. The Unified Modeling Language is used in software engineering
for visualizing the design of an application. It offers programmers a standardized way of
thinking about Object Oriented software, before writing any line of code.

You are allowed to use language features up to Java 7 included.

• You are not allowed to use any external libraries, build tools or code generators.

• Do not use the default package.

• Create your own relevant packages following the Java package naming conventions.

• Java is compiled into an intermediate language. This will generate some .class files.
Do not commit them on your repository!

• Make sure you have javac and java available as commands in your terminal.

• Compile the project running the commands bellow in the root of your project folder.

## Scenario file

The first line of the file contains a positive integer number. This number represents the
number of times the simulation is run. In our case, this will be the number of times a
weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this
format: 
*TYPE NAME LONGITUDE LATITUDE HEIGHT.*

## Weather generation
There are 4 types of weather:
• RAIN

• FOG

• SUN

• SNOW

Each 3 dimensional point has its own weather. Feel free to use whatever generation
algorithm you want, as long as it takes into account the point’s coordinates.

## Aircrafts
### • JetPlane:

◦ SUN - Latitude increases with 10, Height increases with 2

◦ RAIN - Latitude increases with 5

◦ FOG - Latitude increases with 1

◦ SNOW - Height decreases with 7

### • Helicopter:

◦ SUN - Longitude increases with 10, Height increases with 2

◦ RAIN - Longitude increases with 5

◦ FOG - Longitude increases with 1

◦ SNOW - Height decreases with 12

### • Baloon:

◦ SUN - Longitude increases with 2, Height increases with 4

◦ RAIN - Height decreases with 5

◦ FOG - Height decreases with 3

◦ SNOW - Height decreases with 15

## Simulation

• Coordinates are positive numbers.

• The height is in the 0-100 range.

• If an aircraft needs to pass the upper limit height it remains at 100.

• Each time an aircraft is created, it receives a unique ID. There can’t be 2 aircrafts
with the same ID.

• If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters
from the weather tower and logs its current coordinates.

• When a weather change occurs, each aircraft type needs to log a message, as seen in
the example.
The message format is: *TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.*

A funny message will be appreciated during the correction.

• Each time an aircraft registers or unregisters to/from the weather tower, a message
will be logged.

## Validation
The input file needs to be validated. Any abnormal behaviour due to invalid input data
is not acceptable. If the input file data is not correct the program stops execution. Any
error messages will be printed to the standard output.

![Aircraft Simulator](http://www.thebattlesim.com/images/Cockpits-1.jpg)
