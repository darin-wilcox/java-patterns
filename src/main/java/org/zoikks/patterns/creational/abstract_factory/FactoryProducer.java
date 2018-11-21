package org.zoikks.patterns.creational.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This is a Factory of Factories.
 *
 */
class FactoryProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryProducer.class);

    enum FactoryOption {
        SHAPE,
        COLOR
    }

    /**
     *
     * Generates a factory based on the FactoryOption argument value.
     *
     * @param factoryOption A definition from FactoryOption enum as the type of factory to retrieve.
     * @return An instance of AbstractFactory defining either a SHAPE or COLOR.
     */
    static AbstractFactory createFactory(FactoryOption factoryOption) {

        if (factoryOption.equals(FactoryOption.SHAPE)) {

            LOGGER.debug("Initializing an AbstractFactory instance as a ShapeFactory...");
            return new ShapeFactory();
        }

        if (factoryOption.equals(FactoryOption.COLOR)) {

            LOGGER.debug("Initializing an AbstractFactory instance as a ColorFactory...");
            return new ColorFactory();
        }

        return null;
    }
}