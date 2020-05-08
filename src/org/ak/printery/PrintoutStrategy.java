package org.ak.printery;

import org.ak.map.City;

/**
 */
@FunctionalInterface
public interface PrintoutStrategy {
    public Printout execute();

    public static class Factory  {
        public static PrintoutStrategy getInstance(City city) {
            if (city.getPopulation() > 100000) {
                return new CityPrintoutStrategy(city.getName(), "Geo", city.getPopulation() / 10000);
            } else {
                return new TownPrintoutStrategy(city.getName(), "Geo");
            }
        }
    }
}
