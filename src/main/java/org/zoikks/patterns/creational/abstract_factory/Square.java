package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Square defined as a Shape.
 *
 */
public class Square implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Square.class);

    @Override
    public void draw() {

        LOGGER.debug("Inside the Square::draw method.");
    }
}
