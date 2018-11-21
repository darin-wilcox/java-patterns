package org.zoikks.patterns.creational.abstract_factory;

/**
 *
 * Base type definition for all factories that can be instantiated.
 *
 */
abstract class AbstractFactory {

    enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    enum ColorType {
        RED,
        GREEN,
        BLUE
    }

    abstract Color createColor(ColorType colorType);

    abstract Shape createShape(ShapeType shapeType);
}