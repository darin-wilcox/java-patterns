package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates the Adapter Pattern used as a Class Adapter.  It uses inheritance and extends the source class type.
 *
 * Using this implementation of the Adapter Pattern requires a new Adapter for each new object type.
 *
 * This implementation (from "Design Patterns - Elements of reusable object-oriented software":
 *      - won't work to adapt a class and all of its subclasses.
 *      - lets the Adapter override some of the Adaptee's behavior.
 *      - introduces only one object, and no additional pointer indirection is needed to get to the adaptee.
 *
 */
class EquilateralTriangleAdapter extends EquilateralTriangle implements BasicShape {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquilateralTriangleAdapter.class);

    EquilateralTriangleAdapter(double sideLength) {

        super(sideLength);
    }

    @Override
    public void draw() {
        this.drawShape();
    }

    @Override
    public void resize() {
        LOGGER.debug("EquilateralTriangle cannot be resized.  Please create a new one with required values.");
    }

    @Override
    public String getDescription() {
        return "Triangle object";
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}