package org.zoikks.patterns.structural.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Client object that defines the top level information for boxes included in an Order.
 *
 */
class Order {

    private List<Box> boxes;

    Order() {

        this.boxes = new ArrayList<>();
    }

    void addBox(Box box) {

        this.boxes.add(box);
    }

    List<Box> getBoxes() {

        return Collections.unmodifiableList(this.boxes);
    }

    double getOrderCost() {

        double orderCost = 0.00;

        for (Box box : this.boxes) {
            orderCost += box.getPrice();
        }

        return orderCost;
    }
}