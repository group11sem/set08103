package com.napier.sem;

public class country {

    public  String code;
    /**
     * Country name
     */
    public String name;

    public String continent;

    public String region;

    /**
     * Country population
     */
    public int population;
    public int capital;


    @Override
    public String toString() {
        return "country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
