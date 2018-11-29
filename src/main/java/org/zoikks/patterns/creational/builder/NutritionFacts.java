package org.zoikks.patterns.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Example of the Builder pattern used to build a NutritionFacts object.
 *
 */
class NutritionFacts {

    private static final Logger LOGGER = LoggerFactory.getLogger(NutritionFacts.class);

    private final int servingSize;
    private int calories;
    private int totalFats;
    private int sodium;
    private int totalCarbs;
    private int sugars;
    private int protein;

    private NutritionFacts(NutritionFactsBuilder nutritionFactsBuilder) {

        LOGGER.debug("Initializing NutritionFacts...");

        this.servingSize = nutritionFactsBuilder.servingSize;
        this.calories = nutritionFactsBuilder.calories;
        this.totalFats = nutritionFactsBuilder.totalFats;
        this.totalCarbs = nutritionFactsBuilder.totalCarbs;
        this.sodium = nutritionFactsBuilder.sodium;
        this.sugars = nutritionFactsBuilder.sugars;
        this.protein = nutritionFactsBuilder.protein;
    }

    int getServingSize() {
        return servingSize;
    }

    final int getCalories() {
        return calories;
    }

    final int getTotalFats() {
        return totalFats;
    }

    final int getSodium() {
        return sodium;
    }

    final int getTotalCarbs() {
        return totalCarbs;
    }

    final int getSugars() {
        return sugars;
    }

    final int getProtein() {
        return protein;
    }

    static class NutritionFactsBuilder {

        private final int servingSize;
        private int calories = 0;
        private int totalFats = 0;
        private int sodium = 0;
        private int totalCarbs = 0;
        private int sugars = 0;
        private int protein = 0;

        NutritionFactsBuilder(int servingSize) {

            LOGGER.debug("Initializing NutritionFactsBuilder...");

            this.servingSize = servingSize;
        }

        NutritionFactsBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        NutritionFactsBuilder totalFats(int totalFats) {
            this.totalFats = totalFats;
            return this;
        }

        NutritionFactsBuilder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        NutritionFactsBuilder totalCarbs(int totalCarbs) {
            this.totalCarbs = totalCarbs;
            return this;
        }

        NutritionFactsBuilder sugars(int sugars) {
            this.sugars = sugars;
            return this;
        }

        NutritionFactsBuilder protein(int protein) {
            this.protein = protein;
            return this;
        }

        /**
         *
         * Returns an instance of the NutritionFacts object.
         *
         * @return an instance of the NutritionFacts object.
         */
        NutritionFacts build() {

            return new NutritionFacts(this);
        }
    }
}