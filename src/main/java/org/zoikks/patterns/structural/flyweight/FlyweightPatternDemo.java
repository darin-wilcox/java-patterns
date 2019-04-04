package org.zoikks.patterns.structural.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstration of the Flyweight programming pattern.
 *
 * From https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm, the definition for Flyweight is:
 *  Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory
 *  footprint and increase performance.
 *
 * There are many different classes from the core JDK utilize the Flyweight pattern:
 *
 *  - Boolean
 *  - Byte
 *  - Character
 *  - Short
 *  - Long
 *  - BigDecimal
 *  - java.lang.Integer#valueOf(int)
 *
 * This example is pretty weak but gets the point across.  This code generates an object "LastName" that keeps
 * only one instance of a LastName object based on the value of the given last name.
 *
 */
public class FlyweightPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlyweightPatternDemo.class);

    private static final String SMACKER = "Smacker";
    private static final String SCHMOE = "Schmoe";

    public static void main(String... args) {

        LOGGER.debug("Starting the app...");

        new FlyweightPatternDemo();

        LOGGER.debug("Ending the app...");
    }

    private FlyweightPatternDemo() {

        LastNameFactory lastNameFactory = LastNameFactory.getInstance();

        // Populates the intrinsic value during creation.
        LastName Smacker = lastNameFactory.getLastName(SMACKER);
        LastName Schmoe = lastNameFactory.getLastName(SCHMOE);
        LastName Smoker = lastNameFactory.getLastName(SMACKER);
        LastName Schmae = lastNameFactory.getLastName(SCHMOE);

        LOGGER.debug("Tried to create four instances of LastName.  " +
                "However, only " + lastNameFactory.getLastNameCount() + " were created.");

        // Weak example of an extrinsic value.
        Smacker.displayLastName();
        Schmoe.displayLastName();
        Smoker.displayLastName();
        Schmae.displayLastName();

        // The displayed value should be true.
        LOGGER.debug("Smacker and Smoker are equals: " + (Smacker == Smoker));
        // The displayed value should be true.
        LOGGER.debug("Schmoe and Schmae are equals: " + (Schmoe == Schmae));

        // The displayed value should be true.
        LOGGER.debug("Smacker and Smoker have same value: " + Smacker.getValue().equals(Smoker.getValue()));
        // The displayed value should be true.
        LOGGER.debug("Schmoe and Schmae have same value: " + Schmoe.getValue().equals(Schmae.getValue()));
    }
}