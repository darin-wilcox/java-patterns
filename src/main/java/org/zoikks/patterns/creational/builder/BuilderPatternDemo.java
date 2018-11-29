package org.zoikks.patterns.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Example of the Builder Pattern.
 *
 * The basis for this example came from "Effective Java 2" by Josh Bloch.
 *
 * The other parts came from my own brain :)
 *
 */
public class BuilderPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuilderPatternDemo.class);

    public static void main(String... args) {

        new BuilderPatternDemo();
    }

    private BuilderPatternDemo() {

        this.executeSimpleDataBuilder();

        this.executeComplexDataBuilder();
    }

    /**
     *
     * Executes a simple example of a Builder pattern.
     *
     */
    private void executeSimpleDataBuilder() {

        LOGGER.debug("Initializing Cream Soda nutritional informatino.");
        NutritionFacts creamSodaNutrition = new NutritionFacts.NutritionFactsBuilder(1)
                .calories(170).totalFats(5).sodium(70).totalCarbs(46).sugars(46).protein(0).sugars(19).build();
        LOGGER.debug("Cream Soda Nutrition Info Instance: " + creamSodaNutrition);
        LOGGER.debug("Serving Size: " + creamSodaNutrition.getServingSize());
        LOGGER.debug("Calories: " + creamSodaNutrition.getCalories());
        LOGGER.debug("Sodium: " + creamSodaNutrition.getSodium());
        LOGGER.debug("Total Fats: " + creamSodaNutrition.getTotalFats());
        LOGGER.debug("Total Carbs: " + creamSodaNutrition.getTotalCarbs());
        LOGGER.debug("Protein: " + creamSodaNutrition.getProtein());
        LOGGER.debug("Sugars: " + creamSodaNutrition.getSugars());

        LOGGER.debug("Initializing Canada Dry nutritional information.");
        NutritionFacts canadaDryNutrition = new NutritionFacts.NutritionFactsBuilder(1)
                .calories(140).totalFats(10).sodium(50).totalCarbs(36).protein(10).build();
        LOGGER.debug("Canada Dry Nutrition Info Instance: " + canadaDryNutrition);
        LOGGER.debug("Serving Size: " + canadaDryNutrition.getServingSize());
        LOGGER.debug("Calories: " + canadaDryNutrition.getCalories());
        LOGGER.debug("Sodium: " + canadaDryNutrition.getSodium());
        LOGGER.debug("Total Fats: " + canadaDryNutrition.getTotalFats());
        LOGGER.debug("Total Carbs: " + canadaDryNutrition.getTotalCarbs());
        LOGGER.debug("Protein: " + canadaDryNutrition.getProtein());
        LOGGER.debug("Sugars: " + canadaDryNutrition.getSugars());
    }

    /**
     *
     * Executes a more complex example of a Builder pattern.
     *
     */
    private void executeComplexDataBuilder() {

        Address homeAddress = new Address.AddressBuilder().street("666 North Palm Drive")
                .city("Baskerville").state("Some State").zip("55555").type(Address.Type.HOME)
                .apartment("2A").build();
        Address workAddress = new Address.AddressBuilder().street("777 South Pole Drive")
                .city("North Pole").state("AL").zip("84444").type(Address.Type.WORK)
                .apartment("2B").build();

        List<Person> people = new ArrayList<>();

        people.add(new Person.PersonBuilder("Jack", "Frost").middleName("Cold").address(homeAddress)
                .address(workAddress).phoneNumber("201-555-9724").build());
        people.add(new Person.PersonBuilder("Frosty", "Snowman").middleName("the").phoneNumber("202-555-9723").build());

        for (Person person : people) {

            LOGGER.debug("Person Instance: " + person);
            LOGGER.debug("First Name: " + person.getFirstName());
            LOGGER.debug("Middle Name: " + person.getMiddleName());
            LOGGER.debug("Last Name: " + person.getLastName());

            for (Address address : person.getAddressList()) {
                LOGGER.debug(address.getType().toString());
                LOGGER.debug(address.getStreet());
                LOGGER.debug(address.getApartment());
                LOGGER.debug(address.getCity());
                LOGGER.debug(address.getState());
                LOGGER.debug(address.getZip());
            }

            for (String phoneNumber : person.getPhoneNumberList()) {
                LOGGER.debug(phoneNumber);
            }
        }
    }
}