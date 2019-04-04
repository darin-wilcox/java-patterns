package org.zoikks.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Factory class for managing different instances of the LastName class.
 *
 * This is used in conjunction with the Flyweight pattern demo.
 *
 */
class LastNameFactory {

    private static LastNameFactory instance;

    private Map<String, LastName> lastNameMap = new HashMap<>();

    /**
     * Private default constructor to enforce singleton.
     */
    private LastNameFactory() {}

    public static LastNameFactory getInstance() {

        if (instance == null) {
            instance = new LastNameFactory();
        }

        return instance;
    }

    LastName getLastName(String initialLastName) {

        if (this.lastNameMap.keySet().contains(initialLastName)) {
            return this.lastNameMap.get(initialLastName);
        }

        this.lastNameMap.put(initialLastName, new LastName(initialLastName));

        return this.lastNameMap.get(initialLastName);
    }

    int getLastNameCount() {
        return this.lastNameMap.size();
    }
}