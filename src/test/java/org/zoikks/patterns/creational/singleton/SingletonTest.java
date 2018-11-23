package org.zoikks.patterns.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest extends Assert {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingletonTest.class);

    private EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
    private EagerInitializedSingleton instanceTwo = EagerInitializedSingleton.getInstance();

    @Test
    public void reflectionTest() {

        assertEquals(instanceOne, instanceTwo);

        Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();

        try {
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.debug("Unable to instantiate the class using reflection.", e);
        }

        assertNotEquals(instanceOne.hashCode(), instanceTwo.hashCode());
    }
}