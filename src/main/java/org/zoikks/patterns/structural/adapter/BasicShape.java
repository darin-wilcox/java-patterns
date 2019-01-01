package org.zoikks.patterns.structural.adapter;

/**
 *
 * Template of a basic shape type.  Designed to be utilized in conjunction with the Adapter Pattern example.
 *
 */
public interface BasicShape {

    void draw();
    void resize();
    String getDescription();
    boolean isHidden();
}