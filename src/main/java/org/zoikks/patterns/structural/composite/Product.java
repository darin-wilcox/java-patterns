package org.zoikks.patterns.structural.composite;

/**
 *
 * Used in conjunction with the Composite pattern example.
 *
 * This class represents a Leaf node in a Composite pattern demo.  Aside from holding information
 * about itself, it doesn't hold any other info.
 *
 */
class Product implements Component {

    private double price;

    Product(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
