package org.zoikks.patterns.structural.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This is a simple object used in conjunction with the Flyweight demo.
 *
 * The intrinsic value for this object is the value property.  It is what makes the instance unique.
 *
 * This object really doesn't have any extrinsic properties.
 *
 */
class LastName {

    private static final Logger LOGGER = LoggerFactory.getLogger(LastName.class);

    private String value;

    LastName(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }

    void displayLastName() {

        LOGGER.debug("Value: " + value);
        LOGGER.debug("Hashcode: " + value.hashCode());
    }
}