package org.zoikks.patterns.structural.adapter;

/**
 *
 * Template of a complex shape type.  Designed to be utilized in conjunction with the Adapter Pattern example.
 *
 */
public interface ComplexShape {

    double getArea();
    double getPerimeter();
    void drawShape();
}