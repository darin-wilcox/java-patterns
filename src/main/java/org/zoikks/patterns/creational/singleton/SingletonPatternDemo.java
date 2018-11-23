package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * Example of running different implementations of the Singleton Pattern.
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

        // Example of a static block initialized singleton instance:
        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        LOGGER.debug("Static Block initialized instance: " + staticBlockSingleton);
        LOGGER.debug("Initial: " + staticBlockSingleton + ", New: " + StaticBlockSingleton.getInstance());
        LOGGER.debug("Equals (.equals): " + staticBlockSingleton.equals(StaticBlockSingleton.getInstance()));
        boolean staticBlockEquals = staticBlockSingleton == StaticBlockSingleton.getInstance();
        LOGGER.debug("Equals (==): " + staticBlockEquals);

        // Example of a lazily initialized singleton instance:
        LazilyInitializedSingleton lazilyInitializedSingleton = LazilyInitializedSingleton.getInstance(0);
        LOGGER.debug("Lazily initialized instance: " + lazilyInitializedSingleton);
        LOGGER.debug("Initial: " + lazilyInitializedSingleton + ", New: " + LazilyInitializedSingleton.getInstance(0));
        LOGGER.debug("Equals (.equals): " + lazilyInitializedSingleton.equals(LazilyInitializedSingleton.getInstance(0)));
        boolean lazilyInitializeEquals = lazilyInitializedSingleton == LazilyInitializedSingleton.getInstance(0);
        LOGGER.debug("Equals (==): " + lazilyInitializeEquals);
    }

    /**
     *
     * Initializes new threads to demonstrate the negative aspects of unsafe singleton instantiation.
     *
     */
    @SuppressWarnings("unused")
    private void demoMultithreadedLazilyInitializedIssue() {

        for (int i = 0; i < 2; i++) {

            Thread object = new Thread(new MultiThreadingSingleton());
            object.start();
        }

        // TODO Join the threads that were created to ensure the resulting values are different.
    }
}

/**
 *
 * Demonstrates the negative aspects of an unsafe multithreaded, lazily initialized singleton.
 *
 */
class MultiThreadingSingleton implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiThreadingSingleton.class);

    @Override
    public void run() {

        LazilyInitializedSingleton singleton = LazilyInitializedSingleton.getInstance(0);
        LOGGER.debug("Singleton Instance: " + singleton);
    }
}