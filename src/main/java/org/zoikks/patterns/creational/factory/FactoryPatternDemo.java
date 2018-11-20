package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of running the Factory Pattern.
 *
 * This example was found using examples from:  https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *
 */
public class FactoryPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryPatternDemo.class);

    public static void main(String[] args) {
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