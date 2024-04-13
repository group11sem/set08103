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

    @Test
    void displayCountryNull()
    {
        app.displayCountry(null);
    }

    @Test
    void displayCountryEmpty()
    {
        country area = new country();
        app.displayCountry(area);
    }

    @Test
    void displayCountry()
    {
        country area = new country();
        area.name = "USA";
        area.population = 111111111;
        app.displayCountry(area);
    }

    @Test
    void displayCountryNameNull()
    {
        country area = new country();
        area.name = null;
        area.population = 111111111;
        app.displayCountry(area);
    }


    @Test
    void displayCityNull()
    {
        app.displayCity(null);
    }

    @Test
    void displayCityEmpty()
    {
        city area = new city();
        app.displayCity(area);
    }

    @Test
    void displayCity()
    {
        city area = new city();
        area.name = "New York";
        area.population = 2222222;
        app.displayCity(area);
    }

    @Test
    void displayCityNameNull()
    {
        city area = new city();
        area.name = null;
        area.population = 2222222;
        app.displayCity(area);
    }

    @Test
    void displayDistrictPopNull()
    {
        app.displayDistrictPop(null, null);
    }

    @Test
    void displayDistrictPopEmptyNameNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayDistrictPop(cities, null);
    }

    @Test
    void displayDistrictPopEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayDistrictPop(cities, "Test");
    }

    @Test
    void displayDistrictPopEmptyCityEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city area = new city();
        cities.add(area);
        app.displayDistrictPop(cities, "Test");
    }

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

    @Test
    void displayWorldPopByCountryNull()
    {
        app.displayWorldPopByCountry(null);
    }

    @Test
    void displayWorldPopEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        app.displayWorldPopByCountry(countries);
    }
    @Test
    void displayWorldPopCountryEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        country area = new country();
        countries.add(area);
        app.displayWorldPopByCountry(countries);
    }

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
