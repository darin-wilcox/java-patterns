package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates using a static block initializer to initialize a singleton.
 *
 * Allows for exception handling during initialization.  However, it still
 * initializes the instance before it is ever used.
 *
 */
class StaticBlockSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaticBlockSingleton.class);

    private static StaticBlockSingleton instance;

    // Creates the instance at the time of class loading.
    static {
        try {
            LOGGER.debug("Creating instance of StaticBlockSingleton...");
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance.");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}