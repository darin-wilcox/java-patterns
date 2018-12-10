package org.zoikks.patterns.creational.prototype;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Represents a name of an Employee.  Names are taking an interesting approach and this should
 * handle all kinds of names :)
 *
 * A secondary simple class to demonstrate a Prototype Pattern.
 *
 */
public class Name implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> lastNames;
    private List<String> firstNames;
    private List<String> middleNames;

    Name() {
        this.lastNames = new ArrayList<>();
        this.firstNames = new ArrayList<>();
        this.middleNames = new ArrayList<>();
    }

    List<String> getLastNames() {

        return Collections.unmodifiableList(this.lastNames);
    }

    void addLastName(String lastName) {

        if (!StringUtils.isBlank(lastName)) {
            this.lastNames.add(lastName);
        }
    }

    List<String> getFirstNames() {

        return Collections.unmodifiableList(this.firstNames);
    }

    void addFirstName(String firstName) {

        if (!StringUtils.isBlank(firstName)) {
            this.firstNames.add(firstName);
        }
    }

    List<String> getMiddleNames() {

        return Collections.unmodifiableList(this.middleNames);
    }

    void addMiddleName(String middleName) {

        if (!StringUtils.isBlank(middleName)) {
            this.middleNames.add(middleName);
        }
    }

    @Override
    public Name clone() throws CloneNotSupportedException {

        return (Name)super.clone();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("Last names: ");

        for (String lastName : this.getLastNames()) {
            stringBuilder.append(lastName);
            stringBuilder.append(", ");
        }

        stringBuilder.append("\nFirst names: ");

        for (String firstName : this.getFirstNames()) {
            stringBuilder.append(firstName);
            stringBuilder.append(", ");
        }

        stringBuilder.append("\nMiddle names: ");

        for (String middleName : this.getMiddleNames()) {
            stringBuilder.append(middleName);
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }
}