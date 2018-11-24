package org.zoikks.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 *
 * Demonstrates a solution for singleton classes that are serialized.
 *
 */
@SuppressWarnings("unused")
class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializedSingleton.class);

    private SerializedSingleton(){}

    private static class SingletonHelper{

        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    // This method must be implemented in order to use a serialized singleton.
    protected Object readResolve() {
        return getInstance();
    }
}