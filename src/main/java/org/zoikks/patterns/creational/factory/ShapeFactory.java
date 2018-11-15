package org.zoikks.patterns.creational.factory;

public class ShapeFactory {

    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    public Shape createShape(ShapeType shapeType) {

        if (shapeType == null) {
            return null;
        }

        if (shapeType.equals(ShapeType.CIRCLE)) {
            return new Circle();
        }

        if (shapeType.equals(ShapeType.SQUARE)) {
            return new Square();
        }

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            return new Rectangle();
        }

        return null;
    }
}