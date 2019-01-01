package org.zoikks.patterns.structural.adapter;

/**
 *
 * Represents the implementation of a complex shape.  Designed to be utilized in conjunction
 * with the Adapter Pattern example.
 *
 * This is defined as abstract, since there is no practical reason for getting an instance of the class directly.
 *
 */
abstract class ComplexShapeImpl implements ComplexShape {

    private double sideLength;

    ComplexShapeImpl(double sideLength) {
        this.sideLength = sideLength;
    }

    double getSideLength() {
        return this.sideLength;
    }
}
