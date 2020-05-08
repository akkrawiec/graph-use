package org.ak.printery;

import org.ak.map.City;

/**
 */
public interface Printer {
    public String print();

    public static class Factory  {
        public static Printer getInstance(City city) {
            return new PrinterImpl(PrintoutStrategy.Factory.getInstance(city));
        }
    }
}
