package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Represents an Equilateral Triangle that extends a ComplexShapeImpl.
 *
 */
class EquilateralTriangle extends ComplexShapeImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquilateralTriangle.class);

    EquilateralTriangle(double sideLength) {
        super(sideLength);
    }

    @Override
    public double getArea() {

        return (Math.sqrt(3)/4) * (Math.pow(getSideLength(), 2));
    }

    @Override
    public double getPerimeter() {

        return (getSideLength() * 3);
    }

    @Override
    public void drawShape() {
        LOGGER.debug("Drawing Equilateral Triangle with area: " + getArea() + " and perimeter: " + getPerimeter());
    }
}