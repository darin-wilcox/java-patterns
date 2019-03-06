package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of running the Abstract Factory Pattern.
 *
 * This example was found using examples from:  https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *
 * Personally, not a fan of this example of the pattern.  There should be a cleaner way than defining a No-Op
 * implementation for one of the types of factories.
 *
 * Related Patterns (Design Patterns - Elements of Reusable Object-Oriented Software):
 *
 *  - Abstract Factory classes are often implemented with factory methods.  But they can also be implemented using
 *      Prototype.
 *  - A concrete factory is often a singleton.
 *
 */
public class AbstractFactoryPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFactoryPatternDemo.class);

    public static void main(String... args) {

        LOGGER.debug("Initializing application...");

        new AbstractFactoryPatternDemo();
    }

    private AbstractFactoryPatternDemo() {

        // Get an instance of the ShapeFactory
        AbstractFactory shapeFactory = FactoryProducer.createFactory(FactoryProducer.FactoryOption.SHAPE);

        if (shapeFactory != null) {

            // Create an instance of Circle:Shape
            Shape shape1 = shapeFactory.createShape(AbstractFactory.ShapeType.CIRCLE);
            shape1.draw();

            // Create an instance of Rectangle:Shape
            Shape shape2 = shapeFactory.createShape(AbstractFactory.ShapeType.RECTANGLE);
            shape2.draw();

            // Create an instance of Square:Shape
            Shape shape3 = shapeFactory.createShape(AbstractFactory.ShapeType.SQUARE);
            shape3.draw();
        }

        // Get an instance of the ColorFactory
        AbstractFactory colorFactory = FactoryProducer.createFactory(FactoryProducer.FactoryOption.COLOR);

        if (colorFactory != null) {
            // Create an instance of Red:Color
            Color color1 = colorFactory.createColor(AbstractFactory.ColorType.RED);
            color1.fill();

            // Create an instance of Green:Color
            Color color2 = colorFactory.createColor(AbstractFactory.ColorType.GREEN);
            color2.fill();

            // Create an instance of Blue:Color
            Color color3 = colorFactory.createColor(AbstractFactory.ColorType.BLUE);
            color3.fill();
        }
    }
}