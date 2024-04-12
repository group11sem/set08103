package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Create new Application
        Main a = new Main();

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 5000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }
        System.out.println("Displaying a Country's Population: ");

        //Commeneted Out to perform more testing with less clutter.

        /**
        //Gets the population of given country
        country area = a.getCountryPop("United States");

        //Displays the information of given country
        a.displayCountry(area);

        System.out.println("Displaying a city's Population: ");

        city place = a.getCityPop("Edinburgh");

        a.displayCity(place);

        //Displaying all cities in a district and their population
        ArrayList<city> cities = a.getALlCitiesPopInDistrict("Scotland");

        System.out.println("Displaying a district's Population: ");

        a.displayDistrictPop(cities, "Scotland");

        System.out.println("Displaying all countries in the world ordered by largest to smallest population: ");

        ArrayList<country> countries = a.getALlCountriesPopInWorld();

        a.displayWorldPopByCountry(countries);

        System.out.println("Displaying N largest cities in the world where N is provided by the user: ");
        // Disconnect from database

        Scanner scan = new Scanner(System.in);

        System.out.println("What number of largest cities in the world would you like to view:");
        int n_city_world = 2;

        //n_city_world = scan.nextInt();

        System.out.println(n_city_world);

        cities = a.getALlCitiesPopInWorld();

        a.displayNCitiesInWorld(cities, n_city_world);


        //FERGUS WORK, ISSUES #4 TO #?

        //#4
        a.displayCountries(a.getCountries("", "LIMIT 3 "));

        //#5
        a.displayCountries(a.getCountries("WHERE Continent='Europe' ", "LIMIT 3 "));

        //#6
        a.displayCountries(a.getCountries("WHERE Region='Western Europe' ", "LIMIT 3 "));

        //#7
        a.displayCities(a.getCities("", ""));

        //#8
        //displayCities(a.getCities("WHERE continent='Europe'", ""));



        a.displayCountries(a.getCountriesInContinent("Europe"));
        **/

        a.displayCountries(a.getCountriesInRegion("Eastern Asia"));
        System.out.println("\n Displaying Scotland Cities:");
        a.displayCities(a.getALlCitiesPopInDistrict("Scotland"));
        System.out.println("\n Displaying Captial Cities in the World:");
        a.displayCities(a.getCapitalsInWorld());
        System.out.println("\n Displaying Captial Cities in a continent:");
        a.displayCities(a.getCapitalsInContinent("Europe"));
        System.out.println("\n Displaying Captial Cities in a region:");
        a.displayCities(a.getCapitalsInRegion("Western Europe"));
        a.disconnect();
    }
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public country getCountryPop(String name)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE name = '" + name + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                country area = new country();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                return area;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(country area)
    {
        if (area != null)
        {
            System.out.println(
                    "Name: " + area.name + "\n" +
                            "Population: " + area.population);
        }
    }

    public city getCityPop(String name)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE name = '" + name + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                city area = new city();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                return area;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(city area)
    {
        if (area != null)
        {
            System.out.println(
                    "Name: " + area.name + "\n" +
                            "Population: " + area.population);
        }
    }

    public ArrayList<city> getALlCitiesPopInDistrict(String name)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE district = '" + name + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city area = new city();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                cities.add(area);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities within a district");
            return null;
        }
    }
    public void displayDistrictPop(ArrayList<city> cities, String name)
    {
        if (cities != null)
        {
            district dist = new district();
            dist.name = name;
            for(int i = 0; i < cities.size();i++){
                dist.population += cities.get(i).population;
            }
            System.out.println("District Name: " + dist.name + "\n" + "Population: " + dist.population);
        }
    }

    public ArrayList<country> getALlCountriesPopInWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country area = new country();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                countries.add(area);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities within a district");
            return null;
        }
    }

    public void displayWorldPopByCountry(ArrayList<country> countries)
    {
        if (countries != null)
        {
            for(int i = 0; i < countries.size(); i++){
                System.out.println("Country Name: " + countries.get(i).name + " Population: " + countries.get(i).population);
            }

        }
    }

    public ArrayList<city> getALlCitiesPopInWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city area = new city();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                cities.add(area);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities within a district");
            return null;
        }
    }

    public void displayNCitiesInWorld(ArrayList<city> cities, int n)
    {
        if (cities != null)
        {
            if(cities.size() >= n) {
                for (int i = 0; i < n; i++) {
                    System.out.println("City Name: " + cities.get(i).name + " Population: " + cities.get(i).population);
                }
            }
            else{
                System.out.println("Given Integer was too large");
            }
        }
    }


    public ArrayList<country> getCountries(String whereStatement, String limitStatement)
    {
        if(whereStatement == null || limitStatement == null){System.out.println("Part of your statement is null, use an empty string instead"); return null;}

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT * "
                            + "FROM country "
                            + whereStatement
                            + "ORDER BY population DESC "
                            + limitStatement;

            System.out.println(strSelect);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country c = new country();
                c.code = rset.getString("code");
                c.name = rset.getString("name");
                c.region = rset.getString("region");
                c.population = rset.getInt("population");
                c.capital = rset.getInt("capital");
                countries.add(c);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
            return null;
        }
    }

    public void displayCountries(ArrayList<country> countries)
    {
        if(countries == null) {System.out.println("countries arraylist is null"); return;}
        if(countries.isEmpty()) {System.out.println("countries arraylist is empty"); return;}

        for (country country : countries)
        {
            if(country == null) {System.out.println("country is null"); return;}

            System.out.println("Name: " + country.name + " Population: " + country.population);
        }
    }



    public ArrayList<city> getCities(String whereStatement, String limitStatement)
    {
        if(whereStatement == null || limitStatement == null){System.out.println("Part of your statement is null, use an empty string instead"); return null;}

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT * "
                            + "FROM city "
                            + whereStatement
                            + "ORDER BY population DESC "
                            + limitStatement;

            System.out.println(strSelect);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city c = new city();
                c.name = rset.getString("name");
                c.countryCode = rset.getString("countrycode");
                c.district = rset.getString("district");
                c.population = rset.getInt("population");
                cities.add(c);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }

    public void displayCities(ArrayList<city> cities)
    {
        if(cities == null) {System.out.println("countries arraylist is null"); return;}
        if(cities.isEmpty()) {System.out.println("countries arraylist is empty"); return;}

        for (city city : cities)
        {
            if(city == null) {System.out.println("country is null"); return;}

            System.out.println("Name: " + city.name + " Population: " + city.population);
        }
    }

    public ArrayList<country> getCountriesInContinent(String continent){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE continent = '" + continent + "'"
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country area = new country();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                countries.add(area);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities within a district");
            return null;
        }
    }

    public ArrayList<country> getCountriesInRegion(String region){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE region = '" + region + "'"
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country area = new country();
                area.name = rset.getString("name");
                area.population = rset.getInt("population");
                countries.add(area);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities within a district");
            return null;
        }
    }

    public ArrayList<city> getCapitalsInWorld(){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city, country "
                            + "WHERE city.id = country.capital "
                            + "ORDER BY population DESC ";

            System.out.println(strSelect);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city c = new city();
                c.name = rset.getString("city.name");
                c.population = rset.getInt("city.population");
                cities.add(c);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }

    public ArrayList<city> getCapitalsInContinent(String continent){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city, country "
                            + "WHERE city.id = country.capital " +
                            "AND country.continent = '" + continent + "' "
                            + "ORDER BY population DESC ";

            System.out.println(strSelect);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city c = new city();
                c.name = rset.getString("city.name");
                c.population = rset.getInt("city.population");
                cities.add(c);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }

    public ArrayList<city> getCapitalsInRegion(String region){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city, country "
                            + "WHERE city.id = country.capital " +
                            "AND country.region = '" + region + "' "
                            + "ORDER BY population DESC ";

            System.out.println(strSelect);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city c = new city();
                c.name = rset.getString("city.name");
                c.population = rset.getInt("city.population");
                cities.add(c);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }
}