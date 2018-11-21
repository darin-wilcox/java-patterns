package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Green defined as a Color.
 *
 */
public class Green implements Color {

    private static final Logger LOGGER = LoggerFactory.getLogger(Green.class);

    @Override
    public void fill() {

        LOGGER.debug("Inside the Green::fill method.");
    }
}
