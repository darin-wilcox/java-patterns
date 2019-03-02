package org.zoikks.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Used in conjunction with the Composite pattern example.
 *
 * This represents a composite class since it can hold other Component instances and instances of
 * its same type as well.
 *
 */
class Box implements Component {

    private List<Component> products;
    private double price;

    Box(double price) {

        this.price = price;
        this.products = new ArrayList<>();
    }

    void addProduct(Component product) {

        this.products.add(product);
    }

    void removeProduct(Component product) {

        this.products.remove(product);
    }

    /**
     *
     * Retrieves the cost of the box, plus the cost of everything in the box.
     *
     * @return The total price for the box and contents.
     */
    @Override
    public double getPrice() {

        double price = 0.00;

        // Retrieves the price of each component contained in the box.
        for (Component product : products) {
            price += product.getPrice();
        }

        // Don't forget the price of the box itself.
        price += this.price;

        return price;
    }
}