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
 * Uses of the singleton pattern are in the following:
 *
 * Logging
 * Drivers objects
 * Caching
 * Thread pools
 *
 * Other patterns that use the singleton design pattern are the following:
 *
 * Abstract Factory
 * Builder
 * Prototype
 * Facade
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

        // Example of a thread-safe, lazily intialized singleton instance:
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        LOGGER.debug("Thread-safe initialized instance: " + threadSafeSingleton);
        LOGGER.debug("Initial: " + threadSafeSingleton + ", New: " + ThreadSafeSingleton.getInstance());
        LOGGER.debug("Equals (.equals): " + threadSafeSingleton.equals(ThreadSafeSingleton.getInstance()));
        boolean threadSafeEquals = threadSafeSingleton == ThreadSafeSingleton.getInstance();
        LOGGER.debug("Equals (==): " + threadSafeEquals);
        LOGGER.debug("Double check locking: " + threadSafeSingleton + " and new: " + ThreadSafeSingleton.getInstanceUsingDoubleLocking());

        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        LOGGER.debug("BillPugh initialized instance: " + billPughSingleton);
        LOGGER.debug("Initial: " + billPughSingleton + ", New: " + BillPughSingleton.getInstance());
        LOGGER.debug("Equals (.equals): " + billPughSingleton.equals(BillPughSingleton.getInstance()));
        boolean billPughEquals = billPughSingleton == BillPughSingleton.getInstance();
        LOGGER.debug("Equals (==): " + billPughEquals);

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        LOGGER.debug("EnumSingleton initialized instance: " + enumSingleton.hashCode());
        LOGGER.debug("Initial: " + enumSingleton.hashCode() + ", New: " + EnumSingleton.INSTANCE.hashCode());
        LOGGER.debug("Equals (.equals): " + enumSingleton.equals(EnumSingleton.INSTANCE));
        LOGGER.debug("No need to check the '==' solution for equality...");
    }

    /**
     *
     * Initializes new threads to demonstrate the negative aspects of unsafe singleton instantiation.
     *
     */
    @SuppressWarnings("unused")
    private void demoMultithreadedLazilyInitializedIssue() {

        for (int i = 0; i < 2; i++) {

            Thread object = new Thread(new NegativeMultiThreadingSingleton());
            object.start();
        }

        // TODO Join the threads that were created to ensure the resulting values are different.
    }

    /**
     *
     * Initializes new threads to demonstrate the resolution to thread unsafe, singleton instantiation.
     *
     */
    @SuppressWarnings("unused")
    private void demoMultithreadedLazilyInitializedResolved() {

        for (int i = 0; i < 2; i++) {
            Thread object = new Thread(new ResolvedMultiThreadingSingleton());
            object.start();
        }
    }
}

/**
 *
 * Demonstrates the negative aspects of an unsafe multithreaded, lazily initialized singleton.
 *
 */
class NegativeMultiThreadingSingleton implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NegativeMultiThreadingSingleton.class);

    @Override
    public void run() {

        LazilyInitializedSingleton singleton = LazilyInitializedSingleton.getInstance(10);
        LOGGER.debug("Singleton Instance: " + singleton);
    }
}

/**
 *
 * Demonstrates the a safe, multi-threaded, lazily initialized instance of a singleton.
 *
 */
class ResolvedMultiThreadingSingleton implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResolvedMultiThreadingSingleton.class);

    @Override
    public void run() {

        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        LOGGER.debug("Thread-safe singleton instance: " + singleton);
    }
}