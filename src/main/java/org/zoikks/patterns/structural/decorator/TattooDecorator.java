package org.zoikks.patterns.structural.decorator;

/**
 *
 * This class represents a "Concrete Decorator" participant of the Decorator Pattern.
 *
 */
public class TattooDecorator extends BodyDecorator {

    TattooDecorator(Body body) {
        super(body);
    }

    @Override
    public String getLayer() {

        return this.getBody().getLayer() + " Tattoo";
    }
}
