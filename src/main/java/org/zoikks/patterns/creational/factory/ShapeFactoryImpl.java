package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Implementation of the ShapeFactory interface.
 *
 */
class ShapeFactoryImpl implements ShapeFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeFactoryImpl.class);

    ShapeFactoryImpl() {

        LOGGER.debug("Initializing ShapeFactoryImpl...");
    }

    /**
     *
     * Creates an instance of Shape based on the type passed in.
     *
     * This is considered a "Factory Method" since it is responsible for creating a Shape instance.
     *
     * @param shapeType  Type of Shape to create.
     * @return Returns an instance of Shape based on the initial type passed in.
     */
    public Shape createShape(ShapeType shapeType) {

        if (shapeType == null) {
            return null;
        }

        if (shapeType.equals(ShapeType.CIRCLE)) {
            return new Circle();
        }

        if (shapeType.equals(ShapeType.SQUARE)) {
            return new Square();
        }

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            return new Rectangle();
        }

        return null;
    }
}