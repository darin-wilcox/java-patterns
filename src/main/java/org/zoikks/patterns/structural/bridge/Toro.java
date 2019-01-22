package org.zoikks.patterns.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This class represents a refined abstraction of the Mower class.
 *
 */
public class Toro extends Mower {

    private static final Logger LOGGER = LoggerFactory.getLogger(Toro.class);

    Toro(Engine engine, int mowerWidth) {

        super(engine, mowerWidth);
    }

    @Override
    public void startMower() {

        LOGGER.debug("Starting Toro mower with mowing width: " + this.getMowingWidth() + ".");
        this.engine.startEngine();
    }

    @Override
    public void startBlades() {
        LOGGER.debug("Blade(s) starting on Toro mower with mowing width: " + this.getMowingWidth() + ".");
    }

    @Override
    public String toString() {

        String val = "Type: " + this.getClass().toString();
        val += "\nMowing Width: " + this.getMowingWidth();
        val += "\nIs riding mower: " + this.isRider();

        return val;
    }
}
