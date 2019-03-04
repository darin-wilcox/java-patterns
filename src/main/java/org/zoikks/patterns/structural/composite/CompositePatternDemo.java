package org.zoikks.patterns.structural.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * Demonstrates the Composite programming pattern using the information found here:
 *
 * https://refactoring.guru/design-patterns/composite
 *
 * In this case, the composite is an order containing boxes.  Each box contains at least one Product
 * and can contain zero or more boxes as well.  Rather than opening each box and revealing its contents,
 * each component can traverse into itself to find the total price for the order.
 *
 * "Using the composite pattern makes sense only when the core model of your app can be represented
 * as a tree."
 *
 * The composite pattern is a structural pattern that lets you compose objects into tree structures
 * and then work with these structures as if they were individual objects.
 *
 * Related Patterns (Design Patterns - Elements of Reusable Object-Oriented Software):
 *
 *  - Often used for a Chain of Responsibility.
 *  - Decorator is object used with Composite.
 *  - Flyweight lets you share components, but they can no longer refer to their parents.
 *  - Iterator can be used to traverse composites.
 *  - Visitor localizes operations and behavior that would otherwise be distributed across Composite and
 *      Leaf classes.
 *
 */
public class CompositePatternDemo {

    private static final double LITTLE_BOX_COST = 2;
    private static final double MEDIUM_BOX_COST = 4;
    private static final double LARGE_BOX_COST = 8;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositePatternDemo.class);

    public static void main(String... args) {

        new CompositePatternDemo();
    }

    private CompositePatternDemo() {

        LOGGER.debug("Defining Product instances to place in order.");
        Product brush = new Product(9.00);
        Product programmingBook = new Product(50.00);
        Product novel = new Product(10.00);
        Product pens = new Product(25.00);
        Product laptop = new Product(499.00);
        Product tablet = new Product(599.00);

        LOGGER.debug("Defining Box instances to pack with Component instances.");
        Box littleBox = new Box(LITTLE_BOX_COST);
        Box mediumBox1 = new Box(MEDIUM_BOX_COST);
        Box mediumBox2 = new Box(MEDIUM_BOX_COST);
        Box largeBox = new Box(LARGE_BOX_COST);

        LOGGER.debug("Adding Component instances to the boxes.");
        littleBox.addProduct(brush);
        mediumBox1.addProduct(pens);
        mediumBox1.addProduct(novel);
        mediumBox2.addProduct(programmingBook);
        mediumBox2.addProduct(littleBox);
        largeBox.addProduct(mediumBox1);
        largeBox.addProduct(mediumBox2);
        largeBox.addProduct(laptop);
        largeBox.addProduct(tablet);

        largeBox.removeProduct(tablet);     // Decided to not include the tablet after all...


        Order order = new Order();
        // Could add other boxes but we'll start here...
        order.addBox(largeBox);

        LOGGER.debug("Total boxes in order: " + order.getBoxes().size());
        LOGGER.debug("Total Cost: $" + order.getOrderCost());        // Should total up to $1210.00 :)
    }
}