package org.zoikks.patterns.structural.decorator;

/**
 *
 * This class represents the "Decorator" participant of the Decorator Pattern.
 *
 * As the base decorator, this class must maintain a reference to a Component object and define an interface
 * that conforms to Component's interface.
 *
 */
abstract class BodyDecorator implements Body {

    private Body body;

    BodyDecorator(Body body) {
        this.body = body;
    }

    Body getBody() {
        return this.body;
    }
}
