package org.zoikks.patterns.structural.bridge;

/**
 *
 * This interface defines an "Implementation" used in conjunction with a demo of the Bridge pattern.
 * Originally, this interface only defined the startEngine().
 *
 * Currently, the classes implementing this interface are BriggsStratton, Kohler and Tecumseh.
 *
 * Normally, this interface along with the classes implementing the interface would be in a separate package.
 * I didn't put them in their own package because I wanted to keep all the classes associated with this Bridge
 * demo in the same package.
 *
 */
public interface Engine {

    /**
     * Constants defining different horse-power options.
     */
    int HP5 = 5;
    int HP7 = 7;
    int HP25 = 25;

    void startEngine();
}