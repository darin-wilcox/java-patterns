package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Represents a Circle that extends a BasicShapeImpl.
 *
 */
public class Circle extends BasicShapeImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(Circle.class);

    Circle() {
        super("Circle description.");
    }

    @Override
    public void draw() {
        LOGGER.debug("Drawing circle...");
    }

    @Override
    public void resize() {
        LOGGER.debug("Resizing circle...");
    }
}
