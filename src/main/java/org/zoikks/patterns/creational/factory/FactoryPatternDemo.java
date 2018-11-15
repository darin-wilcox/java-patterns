package org.zoikks.patterns.creational.factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        new FactoryPatternDemo();
    }

    private FactoryPatternDemo() {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circleShape = shapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE);
        circleShape.draw();

        Shape squareShape = shapeFactory.createShape(ShapeFactory.ShapeType.SQUARE);
        squareShape.draw();

        Shape rectangleShape = shapeFactory.createShape(ShapeFactory.ShapeType.RECTANGLE);
        rectangleShape.draw();
    }
}