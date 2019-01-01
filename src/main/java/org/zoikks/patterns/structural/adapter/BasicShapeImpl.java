package org.zoikks.patterns.structural.adapter;

/**
 *
 * Represents the basic implementation of a shape.  Designed to be utilized in conjunction
 * with the Adapter Pattern example.
 *
 * This is defined as abstract, since there is no practical reason for getting an instance of the class directly.
 *
 */
public abstract class BasicShapeImpl implements BasicShape {

    private boolean hidden = false;
    private String description;

    BasicShapeImpl(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isHidden() {
        return this.hidden;
    }
}