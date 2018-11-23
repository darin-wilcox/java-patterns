package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates the ability to lazily load a singleton in a thread-safe way.
 *
 * It isn't perfect because there is a cost associated with the synchronized method.
 *
 * To resolve the overhead of synchronized on the method call, use "Double Checked Locking".
 *
 */
class ThreadSafeSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSafeSingleton.class);

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    /**
     *
     * Uses synchronized to ensure only a single instance of the class is instantiated.
     *
     * @return An instance of the ThreadSafeSingleton.
     */
    static synchronized ThreadSafeSingleton getInstance() {

        if (instance == null) {
            LOGGER.debug("Initializing the ThreadSafeSingleton instance...");
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }

    /**
     *
     * Uses double checked locking to ensure only a single instance of the class is instantiated.
     *
     * @return An instance of the ThreadSafeSingleton.
     */
    static ThreadSafeSingleton getInstanceUsingDoubleLocking() {

        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    LOGGER.debug("Initializing the DoubleLocked, thread-safe instance...");
                    instance = new ThreadSafeSingleton();
                }
            }
        }

        return instance;
    }
}
