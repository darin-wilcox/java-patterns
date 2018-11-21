package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Rectangle defined as a Shape.
 *
 */
public class Rectangle implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rectangle.class);

    @Override
    public void draw() {

        LOGGER.debug("Inside the Rectangle::draw method.");
    }
}