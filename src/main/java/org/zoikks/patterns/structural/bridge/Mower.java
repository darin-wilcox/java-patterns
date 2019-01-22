package org.zoikks.patterns.structural.bridge;

/**
 *
 * This class is used in conjunction with a demo of the Bridge programming pattern.  It represents
 * the BaseAbstraction.  A specific type of mower can extend this class to get a refined abstraction
 * that will give more details.
 *
 * In this case, Craftsman and Toro are more refined implementations.
 *
 */
public abstract class Mower {

    private boolean rider;
    private int mowingWidth;

    Engine engine;

    Mower(Engine engine, int mowingWidth) {
        this.engine = engine;
        this.mowingWidth = mowingWidth;
    }

    public abstract void startMower();

    public abstract void startBlades();

    void isRider(boolean rider) {
        this.rider = rider;
    }

    boolean isRider() {
        return this.rider;
    }

    int getMowingWidth() {
        return this.mowingWidth;
    }

    @Override
    public String toString() {

        String val = "Type: " + this.getClass().toString();
        val += "\nMowing Width: " + this.getMowingWidth();
        val += "\nIs riding mower: " + this.isRider();

        return val;
    }
}
