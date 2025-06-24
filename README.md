# CS5700-Assignment1
Shapes Library

In this assignment, you will practice the principles of abstraction and modularity. You will design and build a library of Shapes and write a suite of unit tests to ensure that your library meets the specification. In this assignment (and for all future programming assignments in this class), you are not only graded on the final product but also on how you got there. It is not satisfactory to simply turn in a solution that just "works"; you must follow the appropriate principles, patterns, and practices to receive full points.

Objectives
Implement a system that follows the principles of abstraction, encapsulation, and modularity.
Become familiar with conceptual modelling using UML.
Become familiar with the basics of unit testing.
Learn Kotlin
Requirements
Your shapes library must meet the following requirements: remember that you are building a library, not a program with a main function. For the purpose of this software, the term 'user' refers to any program using your shapes library.

UML (40 pts)
1.1 Before writing any code, you should do your conceptual model using UML.
1.2 Your UML diagram should include all classes and should correctly model their relationships, attributes, and methods. Be sure to indicate which methods are public or private (all attributes should be private).
Implementation - Your library should include implementations for the following shapes (40 pts)
2.1 Point
2.1.1 A point should have x and y attributes, these should be Doubles.
2.1.2 A user should be able to get the x and y attributes
2.1.3 A user should be able to clone a point (get a new point with the same attributes).
2.1.4 A user should be able to move a point by a delta in each axis.
2.2 Line
A line consists of 2 points and cannot have 0 length
A user should be able to get the points that define the line (you might consider strongly encapsulating the points)
A user should be able the get the slope of the line
A user should be able to get the length of the line
A user should be able to move a line
2.3 Rectangle
You can choose how to represent a rectangle, either with lines or points (I think points is easier, just use 2 points)
A rectangle cannot have 0 width or height
A user should be able to get the attributes that define a rectangle (either the points or the lines)
A user should be able to get the area of the rectangle
A user should be able to move a rectangle.
2.4 Square
All of the same requirements for Rectangle, only width and height must be identical
2.5 Ellipse
An ellipse should be represented by a point and 2 radii.
An ellipse cannot have an area of 0
A user should be able to get the attributes that define the ellipse
A user should be able to get the area of an ellipse
A user should be able to move an ellipse
2.6 Circle
All of the same requirements for an ellipse, only the 2 radii are the same.
2.7 Triangle
A triangle can either be made up of lines or points (again, points are easier, I think)
A triangle must not have an area of 0 (this occurs when all 3 points are on the same line)
A user should be able to get the attributes that define the triangle
A user should be able to get the area of the triangle
A user should be able to move a triangle
Unit Tests (40 points)
Executable unit test cases should give reasonable assurances that the system is working correctly.
Executable unit test cases should have high coverage in terms of code paths.