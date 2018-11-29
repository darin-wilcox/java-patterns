package org.zoikks.patterns.creational.builder;

/**
 *
 * Represents an Address.
 *
 * Example POJO with a Builder contained inside.
 *
 */
public class Address {

    enum Type {
        HOME,
        WORK
    }

    private String street;
    private String apartment;
    private String city;
    private String state;
    private String zip;
    private Type type;

    private Address(AddressBuilder addressBuilder) {

        this.type = addressBuilder.type;
        this.apartment = addressBuilder.apartment;
        this.street = addressBuilder.street;
        this.city = addressBuilder.city;
        this.state = addressBuilder.state;
        this.zip = addressBuilder.zip;
    }

    final String getStreet() {
        return this.street;
    }

    final String getApartment() {
        return this.apartment;
    }

    final String getCity() {
        return this.city;
    }

    final String getState() {
        return this.state;
    }

    final String getZip() {
        return this.zip;
    }

    final Type getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Address)) {
            return false;
        }

        Address a = (Address)o;

        return (a.getStreet().equals(this.street) &&
                a.getCity().equals(this.city) &&
                a.getState().equals(this.state) &&
                a.getZip().equals(this.zip) &&
                a.getType().equals(this.type));
    }

    @Override
    public int hashCode() {
         int result = 17;

         result = 31 * result + this.street.length();
         result = 31 * result + this.city.length();
         result = 31 * result + this.state.length();
         result = 31 * result + this.zip.length();

         return result;
    }

    @Override
    public String toString() {

        return "Address: \nType: " + this.type + "\nStreet: " + this.street
                + "\nApartment: " + this.apartment + "\nCity: " + this.city
                + "\nState: " + this.state + "\nZip: " + this.zip;
    }

    /**
     *
     * AddressBuilder for making the Address instances.
     *
     */
    static class AddressBuilder {

        private String street;
        private String apartment;
        private String city;
        private String state;
        private String zip;
        private Type type;

        AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        AddressBuilder apartment(String apartment) {
            this.apartment = apartment;
            return this;
        }

        AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        AddressBuilder state(String state) {
            this.state = state;
            return this;
        }

        AddressBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        AddressBuilder type(Type type) {
            this.type = type;
            return this;
        }

        Address build() {

            return new Address(this);
        }
    }
}