package org.ak.map;

/**
 */
public class Road {
    private String name;
    private int length;
    private int maxSpeed;

    public Road(int length, int maxSpeed) {
        this.length = length;
        this.maxSpeed = maxSpeed;
    }

    public Road(String name, int length, int maxSpeed) {
        this(length, maxSpeed);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double maxDistancePerHour() {
        return this.length / this.maxSpeed;
    }

    /**
     *
     * @param city
     * @param road
     * @return
     */
    public static double getRoadAbsoluteCost(City city, Road road) {
        if (road == null) {
            return 0;
        }
        return road.getLength();
    }

    /**
     *
     * @param city
     * @param road
     * @return
     */
    public static double getRoadRelativeCost(City city, Road road) {
        if (road == null) {
            return 0;
        }
        return road.maxDistancePerHour();
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
