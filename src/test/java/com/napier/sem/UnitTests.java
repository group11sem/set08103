package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests
{
    static Main app;

    @BeforeAll
    static void init()
    {
        app = new Main();
    }


    /**
     * Testing if displayCountry(null) does output and does not produce an error.
     */
    @Test
    void displayCountryNull()
    {
        app.displayCountry(null);
    }

    /**
     * Testing if displayCountry(area) with an empty country area does not produce errors
     */
    @Test
    void displayCountryEmpty()
    {
        country area = new country();
        app.displayCountry(area);
    }

    /**
     * Testing if the display Country method outputs the correct data when fed
     * a country variable with all correct information
     */
    @Test
    void displayCountry()
    {
        country area = new country();
        area.name = "USA";
        area.population = 111111111;
        app.displayCountry(area);
    }

    /**
     * Testing if the display Country method outputs the correct data
     * when fed a country variable with all the correct information
     * except for the name being null
     */
    @Test
    void displayCountryNameNull()
    {
        country area = new country();
        area.name = null;
        area.population = 111111111;
        app.displayCountry(area);
    }


    /**
     * Testing if the display City method does not produce an error
     * when given a null element
     */
    @Test
    void displayCityNull()
    {
        app.displayCity(null);
    }

    /**
     * Testing if the display City method produces no output
     * when given an empty city variable
     */
    @Test
    void displayCityEmpty()
    {
        city area = new city();
        app.displayCity(area);
    }

    /**
     * Testing if the display City method outputs the correct
     * information when provided a city method with all the correct
     * information
     */
    @Test
    void displayCity()
    {
        city area = new city();
        area.name = "New York";
        area.population = 2222222;
        app.displayCity(area);
    }

    /**
     * Testing if the display City method outputs the correct
     * information when provided a city variable with all
     * the correct information except for the name field being
     * null
     */
    @Test
    void displayCityNameNull()
    {
        city area = new city();
        area.name = null;
        area.population = 2222222;
        app.displayCity(area);
    }

    /**
     * Testing if the display District method does not produce
     * any areas when given null in both parameter fields
     */
    @Test
    void displayDistrictPopNull()
    {
        app.displayDistrictPop(null, null);
    }

    /**
     * Testing if the display District method outputs nothing
     * given a city array list that is empty and the name parameter
     * being null
     */
    @Test
    void displayDistrictPopEmptyNameNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayDistrictPop(cities, null);
    }

    /**
     * Testing if the display District method is able to output the name only,
     * when given an empty city array list and an example name field
     */
    @Test
    void displayDistrictPopEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayDistrictPop(cities, "Test");
    }

    /**
     * Testing if display District method only outputs the name field when
     * given a city array list with an empty city in the array and an example
     * name field
     */
    @Test
    void displayDistrictPopEmptyCityEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        cities.add(area);
        app.displayDistrictPop(cities, "Test");
    }

    /**
     * Testing Display District method produces the correct result
     * when given complete field parameters
     */
    @Test
    void displayDistrictPop()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        area.name = "New York";
        area.population = 333333333;
        cities.add(area);
        app.displayDistrictPop(cities, "Test");
    }

    /**
     * Testing display District method produces the
     * correct result when the city array list has a
     * city element with a null name field and the method name field is given
     * an example field
     */
    @Test
    void displayDistrictPopNameNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        area.name = null;
        area.population = 333333333;
        cities.add(area);
        app.displayDistrictPop(cities, "Test");
    }

    /**
     * Testing display world population by country method
     * produces the correct result with a
     * null field parameter
     */
    @Test
    void displayWorldPopByCountryNull()
    {
        app.displayWorldPopByCountry(null);
    }

    /**
     * Testing display world population by country method produces the
     * correct result given
     * an empty countries array list
     */
    @Test
    void displayWorldPopEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        app.displayWorldPopByCountry(countries);
    }

    /**
     * Testing display world population by country method produces the
     * correct result given the parameter is
     * a country array list with a empty country element
     */
    @Test
    void displayWorldPopCountryEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country area = new country();
        countries.add(area);
        app.displayWorldPopByCountry(countries);
    }

    /**
     * Testing if display world population by country method produces
     * the correct output given the correct field parameter
     */
    @Test
    void displayWorldPopByCountry()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country area = new country();
        area.name = "United States";
        area.population = 44444444;
        countries.add(area);
        app.displayWorldPopByCountry(countries);
    }

    /**
     * Testing if display world population by country produces
     * the correct result when given partially fill field
     * parameter
     */
    @Test
    void displayWorldPopByCountryNameNull()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country area = new country();
        area.name = null;
        area.population = 44444444;
        countries.add(area);
        app.displayWorldPopByCountry(countries);
    }


    /**
     * Testing display N cities in world method produces the correct result
     * given a null parameter for the city array list field and a 0 for the limit
     * field
     */
    @Test
    void displayDisplayNCitiesInWorldNull()
    {
        app.displayNCitiesInWorld(null, 0);
    }

    @Test
    void displayDisplayNCitiesInWorldEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayNCitiesInWorld(cities, 3);
    }
    @Test
    void displayNCitiesInWorldCountryEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        cities.add(area);
        app.displayNCitiesInWorld(cities, 3);
    }

    @Test
    void displayNCitiesInWorldByCountry()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        area.name = "New York";
        area.population = 55555555;
        cities.add(area);
        app.displayNCitiesInWorld(cities, 5);
    }

    @Test
    void displayNCitiesInWorldByCountryNameNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        area.name = null;
        area.population = 55555555;
        cities.add(area);
        app.displayNCitiesInWorld(cities, 5);
    }

    @Test
    void displayCountriesNull()
    {
        app.displayCountries(null);
    }

    @Test
    void displayCountriesNullMember()
    {
        ArrayList<country> countries = new ArrayList<country>();
        countries.add(null);
        app.displayCountries(countries);
    }

    @Test
    void displayCountriesEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        app.displayCountries(countries);
    }

    @Test
    void displayCountriesEmptyMember()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country c = new country();
        countries.add(c);
        app.displayCountries(countries);
    }

    @Test
    void displayCountriesNormal()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country c = new country();
        c.code = "GBR";
        c.name = "United Kingdom";
        c.region = "Western Europe";
        c.population = 9999;
        c.capital = 1234;
        countries.add(c);
        app.displayCountries(countries);
    }

    @Test
    void displayCountriesNameNull()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country c = new country();
        c.code = "GBR";
        c.name = null;
        c.region = "Western Europe";
        c.population = 9999;
        c.capital = 1234;
        countries.add(c);
        app.displayCountries(countries);
    }

    @Test
    void displayCitiesNameNull()
    {
        app.displayCities(null);
    }

    @Test
    void displyCitiesNullMember(){
        ArrayList<city> cities = new ArrayList<city>();
        cities.add(null);
        app.displayCities(cities);
    }

    @Test
    void displayCitiesEmpty(){
        ArrayList<city> cities = new ArrayList<city>();
        app.displayCities(cities);
    }

    @Test
    void displayCitiesEmptyMember(){
        ArrayList<city> cities = new ArrayList<city>();
        city test = new city();
        cities.add(test);
        app.displayCities(cities);

    }

    @Test
    void displayCitiesNormal(){
        ArrayList<city> cities = new ArrayList<city>();
        city test = new city();
        test.name = "Richmond";
        test.population = 100;
        cities.add(test);
        app.displayCities(cities);
    }

    @Test
    void displayCitiesCityNameNull(){
        ArrayList<city> cities = new ArrayList<city>();
        city test = new city();
        test.name = null;
        test.population = 100;
        cities.add(test);
        app.displayCities(cities);
    }


}
