package org.zoikks.patterns.creational.prototype;

public interface EmployeePrototype extends Cloneable {

    enum EmployeeType {
        STAFF,
        TEMP,
        RESEARCH,
        LEADER
    }

    String EMPLOYEE_OPTIONS_FILE = "/EmployeeOptions.ser";

    Employee clone() throws CloneNotSupportedException;
}