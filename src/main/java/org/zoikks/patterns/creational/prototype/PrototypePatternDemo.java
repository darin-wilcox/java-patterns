package org.zoikks.patterns.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 *
 * Demonstrates the ability to Clone objects as an implementation of the Prototype Pattern.
 *
 */
public class PrototypePatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrototypePatternDemo.class);

    public static void main(String... args) {
        new PrototypePatternDemo();
    }

    private HumanResources hr;

    private PrototypePatternDemo() {

        this.hr = new HumanResourcesImpl();

        TempEmployee tempEmployee1 = this.createEmployee();
        TempEmployee tempEmployee2 = this.createEmployee();

        Name tempName2 = new Name();
        tempName2.addFirstName("Tanya");
        tempName2.addLastName("Temporary");
        tempName2.addMiddleName("M.");

        tempEmployee2.setName(tempName2);

        LOGGER.debug(tempEmployee1.toString());
        LOGGER.debug(tempEmployee2.toString());
    }

    private TempEmployee createEmployee() {

        Name tempName = new Name();
        tempName.addFirstName("Tim");
        tempName.addLastName("Temp");

        Accomplishment tempAccomp = new Accomplishment("Didn't cause a problem.", new Date());

        TempEmployee tempClone = (TempEmployee)hr.createEmployee(EmployeePrototype.EmployeeType.TEMP);

        tempClone.setName(tempName);
        tempClone.addAccomplishment(tempAccomp);

        return tempClone;
    }
}