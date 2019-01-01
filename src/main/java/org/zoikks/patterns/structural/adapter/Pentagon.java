package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Represents a Pentagon that extends a ComplexShapeImpl.
 *
 */
class Pentagon extends ComplexShapeImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pentagon.class);

    Pentagon(double sideLength) {
        super(sideLength);
    }

    @Override
    public double getArea() {

        return (0.25) * (Math.sqrt(5 + (2 * Math.sqrt(5)))) * (Math.pow(getSideLength(), 2));
    }

    @Override
    public double getPerimeter() {

        return getSideLength() * 5;
    }

    @Override
    public void drawShape() {
        LOGGER.debug("Drawing Pentagon with area: " + getArea() + " and perimeter: " + getPerimeter());
    }
}