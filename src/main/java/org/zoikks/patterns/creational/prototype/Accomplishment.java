package org.zoikks.patterns.creational.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Class representing an accomplishment for an employee and when it occurred.
 *
 */
class Accomplishment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;
    private Date occurrence;

    Accomplishment(String description, Date occurrence) {
        this.description = description;
        this.occurrence = occurrence;
    }

    String getDescription() {
        return description;
    }

    Date getOccurrence() {
        return occurrence;
    }
}