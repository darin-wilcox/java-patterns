package org.zoikks.patterns.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrates the Bridge Pattern.  Bridge allows the abstraction to be decoupled from its implementation.
 * Although at first look this approach appears logical and nothing wrong in it, abstractions through inheritance
 * isn’t always flexible.  Using inheritance permanently binds the implementation to the abstraction.  As a result,
 * any change made to one affects the other.
 *
 * Implementing the composition over inheritance to facilitate the bridge pattern will likely make the implementation
 * more complicated.  However, the flexibility it provides overshadows the complexity.
 *
 * Use the Bridge Pattern with the following situation (from https://stackoverflow.com/questions/319728/
 * when-do-you-use-the-bridge-pattern-how-is-it-different-from-adapter-pattern/9406293#9406293):
 *
 *         A
 *       /   \
 *      /     \
 *     Aa      Ab
 *    / \     /  \
 *  Aa1 Aa2  Ab1 Ab2
 *
 *  to provide this:
 *
 *      A          N
 *    /   \       / \
 *   /     \     /   \
 * Aa(N) Ab(N)  1     2
 *
 * In this example, the Mower abstraction can be modified independently of the implementation (Engine).
 *
 * "PREFER COMPOSITION OVER INHERITANCE" is the basis of this pattern.
 *
 * Related Patterns (Design Patterns - Elements of Reusable Object-Oriented Software):
 *
 *  - An Abstract Factory can create and configure a particular Bridge.
 *  - The Adapter pattern is geared toward making unrelated classes work together.  It is usually applied
 *      to systems after they're designed.  Bridge is used up-front in a design to let abstractions and
 *      implementations vary independently.
 *
 */
public class BridgePatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(BridgePatternDemo.class);

    public static void main(String... args) {
        new BridgePatternDemo();
    }

    private BridgePatternDemo() {

        LOGGER.debug("Creating multiple instances of the Engine class.");
        Engine briggs5HpVertical = new BriggsStratton(Engine.HP5);
        Engine kohler7HpVertical = new Kohler(Engine.HP7);
        Engine tecumseh25HpVertial = new Tecumseh(Engine.HP25);

        LOGGER.debug("Starting each engine independently of equipment to which it is attached.");
        briggs5HpVertical.startEngine();
        kohler7HpVertical.startEngine();
        tecumseh25HpVertial.startEngine();

        LOGGER.debug("Associating different engines within different mowers.");
        Mower craftsman22 = new Craftsman(briggs5HpVertical, 22);
        craftsman22.isRider(false);
        LOGGER.debug(craftsman22.toString());

        Mower toro27 = new Toro(kohler7HpVertical, 27);
        toro27.isRider(false);
        LOGGER.debug(toro27.toString());

        Mower craftsman52 = new Craftsman(tecumseh25HpVertial, 52);
        craftsman52.isRider(true);
        LOGGER.debug(craftsman52.toString());

        LOGGER.debug("Starting different mowers:");
        craftsman22.startMower();
        craftsman22.startBlades();

        toro27.startMower();
        toro27.startBlades();

        craftsman52.startMower();
        craftsman52.startBlades();
    }
}