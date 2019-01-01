package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of an Object Adapter (implementation of the Adapter Pattern).  This implementation uses
 * composition to hold the original instance of ComplexShape object and minimally handles the necessary
 * methods for all methods of the BasicShape type.
 *
 * This isn't a great adapter implementation because each instance of an object requires a different
 * resize() implementation.  Additionally, this adapter would have to be modified for each new instance
 * of ComplexShape created.
 *
 * This type of adapter should be utilized when you need to use several existing subclasses, but it is
 * impractical to adapt their interface by subclassing every one.
 *
 */
public class ComplexShapeAdapter extends BasicShapeImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexShapeAdapter.class);

    private ComplexShape complexShape;

    ComplexShapeAdapter(ComplexShapeImpl complexShape, String description) {
        super(description);

        this.complexShape = complexShape;
    }

    @Override
    public void draw() {

        this.complexShape.drawShape();
    }

    @Override
    public void resize() {
        LOGGER.debug(this.getDescription() + " can't be resized. Please create a new one with required values.");
    }

    @Override
    public String getDescription() {
        if (this.complexShape instanceof Pentagon) {
            return "Pentagon object.";
        } else if (this.complexShape instanceof EquilateralTriangle) {
            return "Triangle object.";
        } else {
            return "Unknown object type.";
        }
    }
}