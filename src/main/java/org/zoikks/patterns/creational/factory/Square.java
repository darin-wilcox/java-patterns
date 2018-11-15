package org.zoikks.patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Square.class);

    @Override
    public void draw() {
        LOGGER.debug("Inside Square::draw() method.");
    }
}
