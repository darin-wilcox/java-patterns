package org.zoikks.patterns.structural.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 *
 * Represents the Proxy portion of the Proxy pattern.  The proxy implements the same interface as the RealSubject.
 * It also holds an instance of the RealProxy that is only created once and then re-used afterwards to prevent
 * the huge time expense in creating the object.
 *
 */
public class Proxy implements Subject {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proxy.class);

    private Subject realSubject;

    @Override
    public void sayHello(String name) {

        Date startDate = new Date();

        if (this.realSubject == null) {
            this.realSubject = new RealSubject();
        }

        this.realSubject.sayHello(name);

        Date endDate = new Date();

        long diff = endDate.getTime() - startDate.getTime();

        LOGGER.debug("Time to execute: " + diff);
    }
}
