package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * ColorFactory defining a factory that creates colors.
 *
 */
class ColorFactory extends AbstractFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorFactory.class);

    @Override
    Color createColor(ColorType colorType) {

        if (colorType == null) {
            return null;
        }

        if (colorType.equals(ColorType.RED)) {
            LOGGER.debug("Initializing a Red:Color instance.");
            return new Red();
        }

        if (colorType.equals(ColorType.GREEN)) {
            LOGGER.debug("Initializing a Green:Color instance.");
            return new Green();
        }

        if (colorType.equals(ColorType.BLUE)) {
            LOGGER.debug("Initializing a Blue:Color instance.");
            return new Blue();
        }

        return null;
    }

    @Override
    Shape createShape(ShapeType shapeType) {
        return null;
    }
}
