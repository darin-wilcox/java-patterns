package org.zoikks.patterns.creational.singleton;

/**
 *
 * Demonstrates the implementation of a singleton using Enum.  Solution recommended by Joshua Bloch.
 *
 * This type of solution provides security against reflection breakage...
 *
 * Unfortunately, this solution only supports eager initialization.
 *
 */
enum EnumSingleton {

    INSTANCE
}