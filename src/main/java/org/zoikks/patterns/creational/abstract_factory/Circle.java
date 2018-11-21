package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Circle defined as a Shape.
 *
 */
public class Circle implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Circle.class);

    @Override
    public void draw() {

        LOGGER.debug("Inside the Circle::draw method.");
    }
}
