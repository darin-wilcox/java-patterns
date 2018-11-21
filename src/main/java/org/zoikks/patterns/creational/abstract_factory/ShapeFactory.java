package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * ShapeFactory defining a factory that creates shapes.
 *
 */
class ShapeFactory extends AbstractFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeFactory.class);

    @Override
    Color createColor(ColorType colorType) {
        return null;
    }

    @Override
    Shape createShape(ShapeType shapeType) {

        if (shapeType == null) {
            return null;
        }

        if (shapeType.equals(ShapeType.CIRCLE)) {
            LOGGER.debug("Initializing a Circle:Shape instance.");
            return new Circle();
        }

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            LOGGER.debug("Initializing a Rectangle:Shape instance.");
            return new Rectangle();
        }

        if (shapeType.equals(ShapeType.SQUARE)) {
            LOGGER.debug("Initializing a Square:Shape instance.");
            return new Square();
        }

        return null;
    }
}
