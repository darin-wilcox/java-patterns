package org.zoikks.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Example of a basic class that enforces immutability used in BuilderPatternDemo.
 *
 */
class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private List<String> phoneNumberList;
    private List<Address> addressList;

    private Person(PersonBuilder personBuilder) {

        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.middleName = personBuilder.middleName;
        this.phoneNumberList = personBuilder.phoneNumberList;
        this.addressList = personBuilder.addressList;
    }

    final String getFirstName() {
        return this.firstName;
    }

    final String getLastName() {
        return this.lastName;
    }

    final String getMiddleName() {
        return this.middleName;
    }

    final List<String> getPhoneNumberList() {

        // Marks the collection as immutable :)
        return Collections.unmodifiableList(this.phoneNumberList);
    }

    final List<Address> getAddressList() {

        // Marks the collection as immutable :)
        return Collections.unmodifiableList(this.addressList);
    }

    /**
     *
     * Builder class to simplify the creation of a Person instance.
     *
     */
    static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String middleName;
        private List<String> phoneNumberList = new ArrayList<>();
        private List<Address> addressList = new ArrayList<>();

        PersonBuilder(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }

        PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        PersonBuilder phoneNumber(String phoneNumber) {
            this.phoneNumberList.add(phoneNumber);
            return this;
        }

        PersonBuilder address(Address address) {
            this.addressList.add(address);
            return this;
        }

        Person build() {

            return new Person(this);
        }
    }
}