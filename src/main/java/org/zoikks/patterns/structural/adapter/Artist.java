package org.zoikks.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Represents the object responsible for directly interacting with instances of BasicShape.
 *
 */
final class Artist {

    private static final Logger LOGGER = LoggerFactory.getLogger(Artist.class);

    private List<BasicShape> shapes = new ArrayList<>();

    List<BasicShape> getShapes() {
        return this.shapes;
    }

    void draw() {
        if (shapes.isEmpty()) {
            LOGGER.debug("Nothing to draw!");
        } else {
            shapes.forEach(
                    BasicShape::draw
            );
        }
    }

    void resize() {
        if (shapes.isEmpty()) {
            LOGGER.debug("Nothing to resize!");
        } else {
            shapes.forEach(
                    BasicShape::resize
            );
        }
    }

    void showIsHidden() {
        if (shapes.isEmpty()) {
            LOGGER.debug("Nothing to hide!");
        } else {
            for (BasicShape shape : shapes) {
                LOGGER.debug("Hidden: " + shape.isHidden());
            }
        }
    }
}
