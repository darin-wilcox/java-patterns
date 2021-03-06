package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of running the Factory Pattern.
 *
 * This example was found using examples from:  https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *
 * Precisely, this an example of "Parameterized Factory Methods".
 *
 * Related Patterns (Design Patterns - Elements of Reusable Object-Oriented Software):
 *
 *  - Abstract Factory is often implemented with factory methods.
 *  - Factory methods are usually called within Template Methods.
 *  - Prototypes don't require subclassing Creator.  However, they often require an Initialize operation on the Product
 *      class.  Factory Method doesn't require such an operation.
 *
 */
public class FactoryPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryPatternDemo.class);

    public static void main(String[] args) {

        LOGGER.debug("Running the FactoryPatternDemo app: ");

        new FactoryPatternDemo();
    }

    private FactoryPatternDemo() {

        // Initialize the factory.
        ShapeFactory shapeFactory = new ShapeFactoryImpl();

        // The factory generates instances of the Shape interface based on the type passed in ->

        // Circle as an instance of Shape
        Shape circleShape = shapeFactory.createShape(ShapeFactoryImpl.ShapeType.CIRCLE);
        circleShape.draw();

        // Square as an instance of Shape
        Shape squareShape = shapeFactory.createShape(ShapeFactoryImpl.ShapeType.SQUARE);
        squareShape.draw();

        // Rectangle as an instance of Shape
        Shape rectangleShape = shapeFactory.createShape(ShapeFactoryImpl.ShapeType.RECTANGLE);
        rectangleShape.draw();
    }
}