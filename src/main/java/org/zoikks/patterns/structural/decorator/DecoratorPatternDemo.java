package org.zoikks.patterns.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstration of the Decorator Pattern (aka Wrapper Pattern).  The intent of the Decorator pattern is to extend
 * functionality as an alternative to subclassing.
 *
 * Reasons for using Decorator:
 *
 *  - Add responsibilities to individual objects dynamically and transparently without affecting other objects
 *      (inheritance is static)
 *  - Responsibilities that can be withdrawn.
 *  - When extension by subclassing is impractical.  Maybe a class definition is hidden or simply unavailable
 *      for subclassing.
 *      (Subclasses can have just one parent class)
 *
 * Participants:
 *
 *  - Component: Defines the interface for objects that can have responsibilities added to them dynamically.
 *  - Concrete Component: An object to which additional responsibilities can be attached.
 *  - Decorator: Maintains a reference to a Component object and defines an interface that conforms to Components
 *      interface.
 *  - Concrete Decorator: Adds responsibilities to the component.
 *
 *  The basis of this example was found here:  https://refactoring.guru/design-patterns/decorator
 *
 *  No implementation was found at the above site, but I liked the analogy to layers on a body.
 *
 */
public class DecoratorPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecoratorPatternDemo.class);

    public static void main(String... args) {

        new DecoratorPatternDemo();
    }

    private DecoratorPatternDemo() {

        // This example allows for multiple different combinations of layers
        // without causing a "combinatorial explosion of subclasses"

        Body undecoratedBody = new MyBody();

        LOGGER.debug("Undecorated Body: " + undecoratedBody.getLayer());

        Body tattooedBody = new TattooDecorator(new MyBody());

        LOGGER.debug("Tattooed Body: " + tattooedBody.getLayer());

        // Ooooh, it got a little colder...
        Body multiShirtBody = new SweatshirtDecorator(new ShirtDecorator(new MyBody()));

        LOGGER.debug("Multi-shirted Body: " + multiShirtBody.getLayer());

        multiShirtBody = new SweatshirtDecorator(multiShirtBody);

        LOGGER.debug("Multi-sweatshirted Body: " + multiShirtBody.getLayer());

        Body coatedBody = new WinterCoatDecorator(new MyBody());

        LOGGER.debug("Coated Body: " + coatedBody.getLayer());
    }
}