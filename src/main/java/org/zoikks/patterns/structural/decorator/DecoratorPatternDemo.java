package org.zoikks.patterns.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstration of the Decorator Pattern (aka Wrapper Pattern).  The intent of the Decorator pattern is to extend functionality as an
 * alternative to subclassing.
 *
 * Reasons for using Decorator:
 *
 *  - Add responsibilities to individual objects dynamically and transparently without affecting other objects.
 *  - Responsibilities that can be withdrawn.
 *  - When extension by subclassing is impractical.  Maybe a class definition is hidden or simply unavailable
 *      for subclassing.
 *
 * Participants:
 *
 *  - Component: Defines the interface for objects that can have responsibilities added to them dynamically.
 *  - Concrete Component: An object to which additional responsibilities can be attached.
 *  - Decorator: Maintains a reference to a Component object and defines an interface that conforms to Components
 *      interface.
 *  - Concrete Decorator: Adds responsibilities to the component.
 *
 */
public class DecoratorPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecoratorPatternDemo.class);

    public static void main(String... args) {

        new DecoratorPatternDemo();
    }

    private DecoratorPatternDemo() {

    }
}