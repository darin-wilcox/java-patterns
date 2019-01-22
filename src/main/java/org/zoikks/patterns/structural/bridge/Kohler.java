package org.zoikks.patterns.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * A concrete implementation of the interface used as the "implementation" in the Bridge pattern demo.
 *
 * Used to demonstrate that the implementation can change independent of the abstraction.
 *
 */
public class Kohler implements Engine {

    private static final Logger LOGGER = LoggerFactory.getLogger(Kohler.class);

    private int hp;

    Kohler(int hp) {

        this.hp = hp;
    }

    @Override
    public void startEngine() {

        LOGGER.debug("Starting Kohler engine " + hp + " horsepower.");
    }
}