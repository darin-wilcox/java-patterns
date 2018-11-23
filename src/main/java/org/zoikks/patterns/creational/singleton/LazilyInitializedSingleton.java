package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates the ability to lazily load a singleton so it doesn't get initialized until requested.
 *
 * There are some issues with these when used in conjunction with multi-threads.  If two threads call the
 * getInstance() at the same time, it has the chance of destroying the singleton instance and each thread
 * will get a different instance.
 *
 */
class LazilyInitializedSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(LazilyInitializedSingleton.class);

    private static LazilyInitializedSingleton instance;

    private LazilyInitializedSingleton() {

    }

    static LazilyInitializedSingleton getInstance(int delayInMillis) {

        if (instance == null) {
            LOGGER.debug("Initializing the lazily loaded instance.");

            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                LOGGER.debug("Error sleeping the thread during initialization.", e);
            }

            instance = new LazilyInitializedSingleton();
        }

        return instance;
    }
}