package org.ak.printery;

import org.ak.map.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 */
class PrintoutStrategyTest {
    @Test
    void executeCity() {
        PrintoutStrategy printoutStrategy = PrintoutStrategy.Factory.getInstance(new City("Warszawa", 1711000, 517));
        Printout printout = printoutStrategy.execute();
        assertEquals("Warszawa", printout.getName());
        assertEquals("Geo", printout.getContent());
        assertEquals(171, printout.getBrochures().size());
    }

    @Test
    void executeTown() {
        PrintoutStrategy printoutStrategy = PrintoutStrategy.Factory.getInstance(new City("Siedlce", 76585, 32));
        Printout printout = printoutStrategy.execute();
        assertEquals("Siedlce", printout.getName());
        assertEquals("Geo", printout.getContent());
        assertNull(printout.getBrochures());
    }
}