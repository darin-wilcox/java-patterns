package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Circle implementation of the Shape interface.
 *
 */
public class Circle implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Circle.class);

    @Override
    public void draw() {
        LOGGER.debug("Inside Circle::draw() method.");
    }
}
