package org.zoikks.patterns.structural.decorator;

/**
 *
 * This class represents the "Concrete Component" participant of the Decorator Pattern.
 *
 */
public class MyBody implements Body {

    @Override
    public String getLayer() {

        return "Skin";
    }
}
