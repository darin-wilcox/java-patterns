package org.zoikks.patterns.creational.prototype;

public interface HumanResources {

    /**
     *
     * Returns a cloned instance of the information cached.
     *
     * @param employeeType If null or unknown type, then new IllegalStateException is thrown.
     * @return An instance of an Employee object.
     */
    Employee createEmployee(EmployeePrototype.EmployeeType employeeType);
}