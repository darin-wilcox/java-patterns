package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of running the Singleton Pattern.
 *
 * This example was found using examples from:  https://www.tutorialspoint.com/design_pattern/factory_pattern.htm and
 * from https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 *
 */
public class SingletonPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingletonPatternDemo.class);

    public static void main(String... args) {

        LOGGER.debug("Initializing application...");
        new SingletonPatternDemo();
    }

    private SingletonPatternDemo() {

        // Example of an eagerly initialized singleton instance:
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        LOGGER.debug("Eagerly initialized instance: " + eagerInitializedSingleton);
        LOGGER.debug("Initial: " + eagerInitializedSingleton + ", New: " + EagerInitializedSingleton.getInstance());
        LOGGER.debug("Equals (.equals): " + eagerInitializedSingleton.equals(EagerInitializedSingleton.getInstance()));
        boolean eagerInitializeEquals = eagerInitializedSingleton == EagerInitializedSingleton.getInstance();
        LOGGER.debug("Equals (==): " + eagerInitializeEquals);
    }
}