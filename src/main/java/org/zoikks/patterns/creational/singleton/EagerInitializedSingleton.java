package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates the immediate initialization of the class that will be a singleton.
 *
 * Easiest method to create a singleton but its drawback is the instance is created even though it may
 * never get used.  It also doesn't provide any assistance for exception handling.
 *
 */
class EagerInitializedSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(EagerInitializedSingleton.class);

    // Creates the instance at the time of class loading.
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    /**
     *
     * Private constructor to prevent any new instances from being created.
     *
     */
    private EagerInitializedSingleton() {

        LOGGER.debug("Initializing instance of EagerInitializedSingleton...");
    }

    static EagerInitializedSingleton getInstance() {
        return instance;
    }
}