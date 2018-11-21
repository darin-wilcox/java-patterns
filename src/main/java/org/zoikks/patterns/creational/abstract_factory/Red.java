package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Blue defined as a Color.
 *
 */
public class Red implements Color {

    private static final Logger LOGGER = LoggerFactory.getLogger(Red.class);

    @Override
    public void fill() {

        LOGGER.debug("Inside the Red::fill method.");
    }
}
