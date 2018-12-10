package org.zoikks.patterns.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * Base object representing an Employee that is cloneable.
 *
 */
public class Employee implements EmployeePrototype, Serializable {

    private static final long serialVersionUID = 129348938L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

    private Name name;
    private int employeeId;
    private Date hireDate;
    private boolean active = true;
    private List<Accomplishment> accomplishments;

    /**
     *
     * Default constructor.
     *
     */
    Employee() {

        this.name = new Name();
        this.accomplishments = new ArrayList<>();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {

        LOGGER.debug("Cloning an Employee...");

        return (Employee)super.clone();
    }

    @Override
    public String toString() {

        return "Name: " + getName().toString() + ", \nEmployee ID: " + getEmployeeId() + ", \nHire Date: " + getHireDate();
    }

    void setName(Name name) {
        this.name = name;
    }

    Name getName() {
        return this.name;
    }

    int getEmployeeId() {
        return employeeId;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    Date getHireDate() {
        return hireDate;
    }

    void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    boolean isActive() {
        return active;
    }

    void setActive(boolean active) {
        this.active = active;
    }

    List<Accomplishment> getAccomplishments() {

        // Prevents modifications to the List once returned.
        return Collections.unmodifiableList(this.accomplishments);
    }

    void addAccomplishment(Accomplishment accomplishment) {

        if (accomplishment != null) {
            this.accomplishments.add(accomplishment);
        }
    }
}