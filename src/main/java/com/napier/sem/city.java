package com.napier.sem;

public class city {
    /**
     * City Name
     */
    public String name;

    public String countryCode;

    public String district;

    /**
     * City population
     */
    public int population;

    @Override
    public String toString() {
        return "city{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }


}
