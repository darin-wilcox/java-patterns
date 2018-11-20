package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ShapeFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeFactory.class);

    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    ShapeFactory() {

        LOGGER.debug("Initializing ShapeFactory...");
    }

    Shape createShape(ShapeType shapeType) {

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