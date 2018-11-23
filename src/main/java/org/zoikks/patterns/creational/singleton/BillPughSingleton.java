package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates a solution brought by Bill Pugh prior to Java 5 when memory had a lot of issues.
 *
 * This demonstrates a singleton using an inner static helper class.  This seems to be the most popular
 * implementation for singleton classes.
 *
 * No need to add "synchronized" to the code.
 *
 */
class BillPughSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillPughSingleton.class);

    private BillPughSingleton() {

        LOGGER.debug("Initializing the BillPughSingleton instance...");
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}