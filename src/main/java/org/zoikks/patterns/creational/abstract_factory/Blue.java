package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Blue defined as a Color.
 *
 */
public class Blue implements Color {

    private static final Logger LOGGER = LoggerFactory.getLogger(Blue.class);

    @Override
    public void fill() {

        LOGGER.debug("Inside the Blue::fill method.");
    }
}