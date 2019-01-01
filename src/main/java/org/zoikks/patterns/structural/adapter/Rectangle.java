package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Represents a Rectangle that extends a BasicShapeImpl.
 *
 */
public class Rectangle extends BasicShapeImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rectangle.class);

    Rectangle() {
        super("Rectangle description.");
    }

    @Override
    public void draw() {
        LOGGER.debug("Drawing rectangle...");
    }

    @Override
    public void resize() {
        LOGGER.debug("Resizing rectangle...");
    }
}
