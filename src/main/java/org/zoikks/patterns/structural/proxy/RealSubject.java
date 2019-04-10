package org.zoikks.patterns.structural.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Implements the Subject class.  This is an expensive object to create because it takes a relatively large
 * amount of time to create (due to the sleeping thread)
 *
 */
public class RealSubject implements Subject {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealSubject.class);

    RealSubject() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted exception...", e);
        }
    }

    @Override
    public void sayHello(String name) {

        LOGGER.debug("Hello, " + name);
    }
}