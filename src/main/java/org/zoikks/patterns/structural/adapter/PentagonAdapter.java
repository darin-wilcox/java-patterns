package org.zoikks.patterns.structural.adapter;

/**
 *
 * Demonstrates the Adapter Pattern used as a Class Adapater.  It uses inheritance and extends the source class type.
 *
 * Using this implementation of the Adapter Pattern requires a new Adapter for each new object type.
 *
 * This implementation (from "Design Patterns - Elements of reusable object-oriented software":
 *      - won't work to adapt a class and all of its subclasses.
 *      - lets the Adapter override some of the Adaptee's behavior.
 *      - introduces only one object, and no additional pointer indirection is needed to get to the adaptee.
 *
 */
class PentagonAdapter extends Pentagon implements BasicShape {

    PentagonAdapter(double sideLength) {
        super(sideLength);
    }

    @Override
    public void draw() {

    }

    @Override
    public void resize() {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
