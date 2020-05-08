package org.ak.map;

/**
 */
public class City {
    private final String name;
    private int population;
    private int area;

    public City(String name, int population, int area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    /**
     *
     * @param city
     * @param road
     * @return
     */
    public static double getRoadRelativeCost( City city, Road road) {
        if (road == null) {
            return 0;
        }
        return road.getLength() + city.getPopulation() / (city.getArea());
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
