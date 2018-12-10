package org.zoikks.patterns.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 *
 * Basic controller class for dealing with employees.
 *
 */
class HumanResourcesImpl implements HumanResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(HumanResourcesImpl.class);

    private Map<EmployeePrototype.EmployeeType, Employee> employeeMap;

    /**
     *
     * Default constructor.
     *
     */
    HumanResourcesImpl() {

        this.loadOptionsFromDisk();
    }

    public Employee createEmployee(EmployeePrototype.EmployeeType employeeType) {

        if (employeeType != null && !this.employeeMap.containsKey(employeeType)) {
            throw new IllegalStateException("The type is invalid...");
        }

        try {
            return this.employeeMap.get(employeeType).clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error("Unable to clone an instance of: " + employeeType);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void loadOptionsFromDisk() {

        LOGGER.debug("Loading the input from the file.");

        try {
            FileInputStream fileInputStream = new FileInputStream(this.getClass().getResource(EmployeePrototype.EMPLOYEE_OPTIONS_FILE).getFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.employeeMap = (Map<EmployeePrototype.EmployeeType, Employee>)objectInputStream.readObject();
        } catch (IOException e) {
            LOGGER.error("Unable to find file to read.", e);
        } catch (ClassNotFoundException e) {
            LOGGER.debug("Unable to convert inputstream to appropriate class.",e );
        }
    }

    @SuppressWarnings("unused")
    private void storeOptionsToDisk() {

        LOGGER.debug("Storing options to the file.");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.getClass().getResource(EmployeePrototype.EMPLOYEE_OPTIONS_FILE).getFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employeeMap);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("Unable to find file named: " + EmployeePrototype.EMPLOYEE_OPTIONS_FILE, e);
        } catch (IOException e) {
            LOGGER.error("Unable to write to file named: " + EmployeePrototype.EMPLOYEE_OPTIONS_FILE, e);
        }
    }
}