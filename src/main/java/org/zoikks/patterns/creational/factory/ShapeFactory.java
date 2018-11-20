package org.zoikks.patterns.creational.factory;

public interface ShapeFactory {

    enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    Shape createShape(ShapeType shapeType);
}