package org.ak.printery;

import org.ak.map.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 */
class PrinterTest {
    @Test
    void print() {
        String result = Printer.Factory.getInstance(new City("Grudziądz", 100001, 58)).print();
        assertEquals("Grudziądz,Geo,[Brochure, Brochure, Brochure, Brochure, Brochure, Brochure, Brochure, Brochure, Brochure, Brochure]", result);
    }
}