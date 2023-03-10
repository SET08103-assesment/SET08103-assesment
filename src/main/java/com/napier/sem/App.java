package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    /**
     * Main method
     *
     * @param args args passed into main
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract country's population information
        ArrayList<CityReport> cities = a.ReportSeven();

        // Display results
        a.printCities(cities);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
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
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Report 1
     * Gets all countries in the world organised by largest population to smallest.
     *
     * @return A list of all countries in the world organised by largest population to smallest, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportOne() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Population DESC; ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 2
     * Gets all countries in a continent organised by largest population to smallest.
     *
     * @return A list of all countries in the world organised by largest population to smallest, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportTwo() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Continent, country.Population DESC; ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 3
     * Gets all countries in a region organised by largest population to smallest.
     *
     * @return A list of all countries in the world organised by largest population to smallest, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportThree() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Population DESC; ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 4
     * Gets The top N populated countries in the world where N is provided by the user.
     * Using prepared statement to allow the user provide the limit.
     *
     * @return A list of The top N populated countries in the world where N is provided by the user, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportFour(int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT ? ";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the limit parameter
            pstmt.setInt(1, limit);
            // Execute the SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 5
     * Gets The top N populated countries in a continent where N is provided by the user.
     * Using prepared statement to allow the user provide the limit.
     *
     * @return A list of The top N populated countries in the world where N is provided by the user, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportFive(int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Continent, country.Population DESC "
                            + "LIMIT ? ";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the limit parameter
            pstmt.setInt(1, limit);
            // Execute the SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 6
     * Gets The top N populated countries in a region where N is provided by the user.
     * Using prepared statement to allow the user provide the limit.
     *
     * @return A list of The top N populated countries in the world where N is provided by the user, or null if there is an error.
     */
    public ArrayList<CountryReport> ReportSix(int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Code, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city ON country.Capital=city.ID "
                            + "ORDER BY country.Region, country.Population DESC "
                            + "LIMIT ? ";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the limit parameter
            pstmt.setInt(1, limit);
            // Execute the SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Extract countries information
            ArrayList<CountryReport> countries = new ArrayList<CountryReport>();
            while (rset.next()) {
                CountryReport ctr = new CountryReport();
                ctr.Name = rset.getString("Name");
                ctr.Code = rset.getString("Code");
                ctr.Continent = rset.getString("Continent");
                ctr.Region = rset.getString("Region");
                ctr.Population = rset.getInt("Population");
                ctr.Capital = rset.getString("city.Name");
                countries.add(ctr);
            }
            return countries;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }
    }

    /**
     * Report 7
     * Gets all cities in the world organised by largest population to smallest.
     *
     * @return A list of all cities in the world organised by largest population to smallest, or null if there is an error.
     */
    public ArrayList<CityReport> ReportSeven() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode=country.Code "
                            + "ORDER BY city.Population DESC; ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<CityReport> cities = new ArrayList<CityReport>();
            while (rset.next()) {
                CityReport cty = new CityReport();
                cty.Name = rset.getString("Name");
                cty.CountryCode = rset.getString("country.Name");
                cty.District = rset.getString("District");
                cty.Population = rset.getInt("Population");
                cities.add(cty);
            }
            return cities;
        } catch (Exception e) {
            // Print a message if failed  to get a data
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     *
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<CountryReport> countries) {
        // Print header
        System.out.println(String.format("%-35s %-15s %-30s %-30s %-20s %-35s", "Name", "Code", "Continent", "Region", "Population", "Capital"));
        // Loop over all countries in the list
        for (CountryReport ctr : countries) {
            String ctr_string =
                    String.format("%-35s %-15s %-30s %-30s %-20s %-35s",
                            ctr.Name, ctr.Code, ctr.Continent, ctr.Region, ctr.Population, ctr.Capital);
            System.out.println(ctr_string);
        }
    }
    /**
     * Prints a list of cities.
     *
     * @param cities The list of countries to print.
     */
    public void printCities(ArrayList<CityReport> cities) {
        // Print header
        System.out.println(String.format("%-35s %-40s %-30s %-30s", "Name", "Country", "District", "Population"));
        // Loop over all countries in the list
        for (CityReport cty : cities) {
            String cty_string =
                    String.format("%-35s %-40s %-30s %-30s",
                            cty.Name, cty.CountryCode, cty.District, cty.Population);
            System.out.println(cty_string);
        }
    }
}