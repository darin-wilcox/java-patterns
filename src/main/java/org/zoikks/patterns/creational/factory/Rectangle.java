package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Rectangle implementation of the Shape interface.
 *
 */
public class Rectangle implements Shape {

    private static Logger LOGGER = LoggerFactory.getLogger(Rectangle.class);

    @Override
    public void draw() {
        LOGGER.debug("Inside Rectangle::draw() method.");
    }
}
