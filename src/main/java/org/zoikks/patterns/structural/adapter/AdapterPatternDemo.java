package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstrations of the Adapter Pattern.  Adapters allows client to make use of libraries and subsets without
 * changing any code from the libraries directly.
 *
 * There are three different types of implementation:
 *
 *      - Object adapter pattern (single object that minimally converts the foreign elements to the proper format)
 *      - Class adapter pattern (a specific Adapter class instance for each type of class to adapt)
 *      - Two-way adapter pattern (allows for transparency to all clients - NOT ACTUALLY IMPLEMENTED HERE...)
 *
 * JDK examples using Adapter Pattern:
 *
 * java.util.Arrays#asList()
 * java.io.InputStreamReader(InputStream) (returns a Reader)
 * java.io.OutputStreamWriter(OutputStream) (returns a Writer)
 *
 */
public final class AdapterPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdapterPatternDemo.class);

    public static void main(String... args) {

        new AdapterPatternDemo();
    }

    private AdapterPatternDemo() {

        this.displayBasicShapesOnly();

        // Object Adapter is used to convert the complex instances to proper object type:
        this.displayObjectAdaptedComplexShapesOnly();

        // Example of using Class Adapters to convert each complex instance to expected object type:
        this.displayClassAdaptedComplexShapesOnly();
    }

    /**
     *
     * Demonstrates an Artist instance consuming BasicShape instances without any adaptation.
     *
     */
    private void displayBasicShapesOnly() {
        Artist basicArtist = new Artist();

        LOGGER.debug("Creating drawing of basic shapes...");
        BasicShape rectangle = new Rectangle();
        BasicShape circle = new Circle();

        basicArtist.getShapes().add(rectangle);
        basicArtist.getShapes().add(circle);

        LOGGER.debug("Drawing...");
        basicArtist.draw();

        LOGGER.debug("Resizing...");
        basicArtist.resize();

        basicArtist.showIsHidden();
    }

    /**
     *
     * Demonstrates an example of using ComplexShape instances by the Artist class without modifying the Artist
     * instance.
     *
     */
    private void displayObjectAdaptedComplexShapesOnly() {
        Artist objectAdaptedArtist = new Artist();

        objectAdaptedArtist.getShapes().add(new ComplexShapeAdapter(new EquilateralTriangle(1), "Equilateral Triangle..."));
        objectAdaptedArtist.getShapes().add(new ComplexShapeAdapter(new Pentagon(5), "Pentagon..."));

        LOGGER.debug("Drawing...");
        objectAdaptedArtist.draw();

        LOGGER.debug("Resizing...");
        objectAdaptedArtist.resize();

        objectAdaptedArtist.showIsHidden();
    }

    /**
     *
     * Uses the class adapter implementation to convert ComplexShape instances to BasicShape instances
     * that are consumed by the Artist instance.
     *
     */
    private void displayClassAdaptedComplexShapesOnly() {
        Artist classAdaptedArtist = new Artist();

        classAdaptedArtist.getShapes().add(new EquilateralTriangleAdapter(1));
        classAdaptedArtist.getShapes().add(new PentagonAdapter(5));

        LOGGER.debug("Drawing...");
        classAdaptedArtist.draw();

        LOGGER.debug("Resizing...");
        classAdaptedArtist.resize();

        classAdaptedArtist.showIsHidden();
    }
}