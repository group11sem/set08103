package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests
{
    static Main app;

    @BeforeAll
    static void init()
    {
        app = new Main();
        app.connect("localhost:33060", 30000);

    }

    /**
     * Testing get Country method to ensure it is
     * able to produce the correct country information
     */
    @Test
    void getCountryTest(){
        country area = app.getCountryPop("United States");
        assertEquals(area.population, 278357000);
        assertEquals(area.name, "United States");
    }

    /**
     * Testing get City population method to check
     * that it can obtain the correct city information
     */
    @Test
    void getCityPopTest(){
        city area = app.getCityPop("Edinburgh");
        assertEquals(area.name, "Edinburgh");
        assertEquals(area.population, 450180);
    }

    /**
     * Testing that get all cities population in district method
     * can obtain all the information for all the cities in
     * that specific district
     */
    @Test
    void getAllCitiesPopInDistrictTest(){
        ArrayList<city> cities = app.getALlCitiesPopInDistrict("Scotland");
        assertEquals(cities.get(0).name, "Glasgow");
        assertEquals(cities.get(1).name, "Edinburgh");
        assertEquals(cities.get(2).name, "Aberdeen");
        assertEquals(cities.get(3).name, "Dundee");
        assertEquals(cities.get(0).population, 619680);
        assertEquals(cities.get(1).population, 450180);
        assertEquals(cities.get(2).population, 213070);
        assertEquals(cities.get(3).population, 146690);

    }

    /**
     * Testing if get all countries population in world method
     * is able to return a country array list with correct indexed country
     * elements
     */
    @Test
    void getAllCountriesPopInWorldTest(){
        ArrayList<country> countries = app.getALlCountriesPopInWorld();
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(1).name, "India");
        assertEquals(countries.get(2).name, "United States");
        assertEquals(countries.get(3).name, "Indonesia");
        assertEquals(countries.get(0).population, 1277558000);
        assertEquals(countries.get(1).population, 1013662000);
        assertEquals(countries.get(2).population, 278357000);
        assertEquals(countries.get(3).population, 212107000);
    }

    /**
     * Testing that get all cities population in world method
     * is able to obtain an array list of all
     * the cities in the world
     */
    @Test
    void getAllCitiesPopInWorldTest(){
        ArrayList<city> cities = app.getALlCitiesPopInWorld();
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(1).name, "Seoul");
        assertEquals(cities.get(2).name, "São Paulo");
        assertEquals(cities.get(3).name, "Shanghai");
        assertEquals(cities.get(0).population, 10500000);
        assertEquals(cities.get(1).population, 9981619);
        assertEquals(cities.get(2).population, 9968485);
        assertEquals(cities.get(3).population, 9696300);
    }

    /**
     * Testing that get countries in continent method is able
     * to obtain an array list of all the countries in a
     * continent
     */
    @Test
    void getCountriesInContinentTest(){
        ArrayList<country> countries = app.getCountriesInContinent("North America");
        assertEquals(countries.get(0).name, "United States");
        assertEquals(countries.get(1).name, "Mexico");
        assertEquals(countries.get(2).name, "Canada");
        assertEquals(countries.get(3).name, "Guatemala");
        assertEquals(countries.get(0).population, 278357000);
        assertEquals(countries.get(1).population, 98881000);
        assertEquals(countries.get(2).population, 31147000);
        assertEquals(countries.get(3).population, 11385000);
    }

    /**
     * Testing that get countries in region method is able
     * to obtain an array list of all the countries in a
     * region
     */
    @Test
    void getCountriesInRegionTest(){
        ArrayList<country> countries = app.getCountriesInRegion("Eastern Asia");
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(1).name, "Japan");
        assertEquals(countries.get(2).name, "South Korea");
        assertEquals(countries.get(3).name, "North Korea");
        assertEquals(countries.get(4).name, "Taiwan");
        assertEquals(countries.get(5).name, "Hong Kong");
        assertEquals(countries.get(0).population, 1277558000);
        assertEquals(countries.get(1).population, 126714000);
        assertEquals(countries.get(2).population, 46844000);
        assertEquals(countries.get(3).population, 24039000);
        assertEquals(countries.get(4).population, 22256000);
        assertEquals(countries.get(5).population, 6782000);
    }

    /**
     * Testing if get capitals in world method is able to
     * return an array list of all the capital cities in the
     * world
     */
    @Test
    void getCapitalsInWorldTest(){
        ArrayList<city> cities = app.getCapitalsInWorld();
        assertEquals(cities.get(0).name, "Seoul");
        assertEquals(cities.get(1).name, "Jakarta");
        assertEquals(cities.get(2).name, "Ciudad de México");
        assertEquals(cities.get(3).name, "Moscow");
        assertEquals(cities.get(0).population, 9981619);
        assertEquals(cities.get(1).population, 9604900);
        assertEquals(cities.get(2).population, 8591309);
        assertEquals(cities.get(3).population, 8389200);
    }

    /**
     * Testing if get capitals in continent method is able
     * to return an array list of all the capital cities
     * in a continent
     */
    @Test
    void getCapitalsInContinentTest(){
        ArrayList<city> cities = app.getCapitalsInContinent("Europe");
        assertEquals(cities.get(0).name, "Moscow");
        assertEquals(cities.get(1).name, "London");
        assertEquals(cities.get(2).name, "Berlin");
        assertEquals(cities.get(3).name, "Madrid");
        assertEquals(cities.get(0).population, 8389200);
        assertEquals(cities.get(1).population, 7285000);
        assertEquals(cities.get(2).population, 3386667);
        assertEquals(cities.get(3).population, 2879052);
    }

    /**
     * Testing if get capitals region method returns
     * an array list of all the captials in a region
     */
    @Test
    void getCapitalsInRegionTest(){
        ArrayList<city> cities = app.getCapitalsInRegion("Western Europe");
        assertEquals(cities.get(0).name, "Berlin");
        assertEquals(cities.get(1).name, "Paris");
        assertEquals(cities.get(2).name, "Wien");
        assertEquals(cities.get(3).name, "Amsterdam");
        assertEquals(cities.get(0).population, 3386667);
        assertEquals(cities.get(1).population, 2125246);
        assertEquals(cities.get(2).population, 1608144);
        assertEquals(cities.get(3).population, 731200);
    }

    /**
     * Testing if get capitals in region method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCapitalsInRegionNullTest(){
        ArrayList<city> cities = app.getCapitalsInRegion("Western Euro");
        ArrayList<city> test = new ArrayList<city>();
        assertEquals(cities, test );
    }

    /**
     * Testing if get capitals in continent method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCapitalsInContinentNullTest(){
        ArrayList<city> cities = app.getCapitalsInContinent("Asiar");
        ArrayList<city> test = new ArrayList<city>();
        assertEquals(cities, test );
    }


    /**
     * Testing if get countries in region method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCountriesInRegionNullTest(){
        ArrayList<country> countries = app.getCountriesInRegion("Ghk;");
        ArrayList<country> test = new ArrayList<country>();
        assertEquals(countries, test );
    }

    /**
     * Testing if get countries in continent method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCountriesInContinentNullTest() {
        ArrayList<country> countries = app.getCountriesInContinent("Europ");
        ArrayList<country> test = new ArrayList<country>();
        assertEquals(countries, test);
    }

    /**
     * Testing if get cities population in district
     * method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCitiesPopInDistrictNullTest(){
        ArrayList<city> cities = app.getALlCitiesPopInDistrict("dsgasd");
        ArrayList<city> test = new ArrayList<city>();
        assertEquals(cities, test );
    }

    /**
     * Testing if get country method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCountryNullTest(){
        country area = app.getCountryPop("United St");
        assertEquals(area, null);

    }

    /**
     * Testing if get city method is able to handle
     * an incorrect parameter and not cause an error
     */
    @Test
    void getCityPopNullTest(){
        city area = app.getCityPop("Edinbur");
        assertEquals(area, null);
    }
}
