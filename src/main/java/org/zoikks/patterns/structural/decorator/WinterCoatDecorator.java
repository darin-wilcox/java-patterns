package org.zoikks.patterns.structural.decorator;

/**
 *
 * This class represents a "Concrete Decorator" participant of the Decorator Pattern.
 *
 */
public class WinterCoatDecorator extends BodyDecorator {

    WinterCoatDecorator(Body body) {
        super(body);
    }

    @Override
    public String getLayer() {

        return this.getBody().getLayer() + " Winter Coat";
    }
}
