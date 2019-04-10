package org.zoikks.patterns.structural.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Demonstration of the Proxy programming pattern.  A pretty pathetic example, but gets the point across.
 *
 * Most of the following information below is from the following site:
 *  https://www.javacodegeeks.com/2015/09/proxy-design-pattern.html
 *
 * The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.
 *
 * Different components of the Proxy pattern:
 * Proxy
 *  1a. Maintains a reference that lets the proxy access the real subject. Proxy may refer to a Subject if the RealSubject and Subject interfaces are the same.
 *  1b. Provides an interface identical to Subject’s so that a proxy can be substituted for the real subject.
 *  1c. Controls access to the real subject and may be responsible for creating and deleting it.
 * Subject:
 *  2a. Defines the common interface for RealSubject and Proxy so that a Proxy can be used anywhere a RealSubject is expected.
 * RealSubject:
 *  3a. Defines the real object that the proxy represents.
 *
 * Different types of Proxy pattern implementations:
 *
 *  - Remote Proxy
 *  - Virtual Proxy
 *  - Protection Proxy
 *  - Cache Proxy/Server Proxy
 *  - Firewall Proxy
 *  - Synchronization Proxy
 *  - Smart Reference Proxy
 *  - Counting Proxy
 *
 * When to use the Proxy pattern:
 *  Whenever there is a need for a more versatile or sophisticated reference to an object than a simple
 *  pointer.  For example:
 *
 *  1 - A remote proxy provides a local representative for an object in a different address space.
 *  2 - A virtual proxy creates expensive objects on demand.
 *  3 - A protection proxy controls access to the original object.  Protection proxies are useful when objects should
 *  have different access rights.
 *
 *
 * Implementations in the JDK:
 *  - java.lang.reflect.Proxy
 *  - java.rmi.*
 *
 */
public class ProxyPatternDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyPatternDemo.class);

    public static void main(String... args) {

        LOGGER.debug("Starting the app...");

        new ProxyPatternDemo();

        LOGGER.debug("Ending the app...");
    }

    private ProxyPatternDemo() {

        Subject proxy = new Proxy();

        // This call will take a minimum of 5 seconds to execute:
        proxy.sayHello("Joe");

        // This call should execute much quicker since the RealSubject was already initialized:
        proxy.sayHello("Schmoe");
    }
}