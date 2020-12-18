package autotest;

import entity.Person;
import entity.Planet;
import entity.Specie;
import entity.Starship;
import entity.Vehicle;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.testng.Reporter;

import commons.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Util {
	//************************************** Read test data from .csv file ****************************//
	//Read data from people.csv
	
    public static Iterator<Object[]> readPeopleTestCase() throws IOException {
    	Log.info("Util.java - Start reading people.csv");
        Reporter.log("Util.java - Reading people.csv");
        CSVParser parser = new CSVParser(new FileReader("people.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Object[]> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            String search=record.get("search");
            Person person=new Person();
            person.setName(record.get("name"));
            person.setHeight(record.get("height"));
            person.setMass(record.get("mass"));
            person.setHair_color(record.get("hair_color"));
            person.setSkin_color(record.get("skin_color"));
            person.setEye_color(record.get("eye_color"));
            person.setBirth_year(record.get("birth_year"));
            person.setGender(record.get("gender"));
            records.add(new Object[]{search, person});
        }
        parser.close();
        Log.info("Util.java - Finish reading people.csv");
        return records.iterator();
        
    }
    
  //Read data from planets.csv
    public static Iterator<Object[]> readPlanetsTestCase() throws IOException {
    	Log.info("Util.java - Start reading planets.csv");
        Reporter.log("Util.java - Reading planets.csv");
        CSVParser parser = new CSVParser(new FileReader("planets.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Object[]> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            String search=record.get("search");
            Planet planet=new Planet();
            planet.setName(record.get("name"));
            planet.setRotation_period(record.get("rotation_period"));
            planet.setOrbital_period(record.get("orbital_period"));
            planet.setDiameter(record.get("diameter"));
            planet.setClimate(record.get("climate"));
            planet.setGravity(record.get("gravity"));
            planet.setTerrain(record.get("terrain"));
            planet.setSurface_water(record.get("surface_water"));
            planet.setPopulation(record.get("population"));
            records.add(new Object[]{search, planet});
        }
        parser.close();
        Log.info("Util.java - Finish reading planets.csv");
        return records.iterator();
    }
    
  //Read data from starships.csv
    public static Iterator<Object[]> readStarshipsTestCase() throws IOException {
    	Log.info("Util.java - Start reading starships.csv");
        Reporter.log("Util.java - Reading starships.csv");
        CSVParser parser = new CSVParser(new FileReader("starships.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Object[]> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            String search=record.get("search");
            Starship starship=new Starship();
            starship.setName(record.get("name"));
            starship.setModel(record.get("model"));
            starship.setManufacturer(record.get("manufacturer"));
            starship.setCost_in_credits(record.get("cost_in_credits"));
            starship.setLength(record.get("length"));
            starship.setMax_atmosphering_speed(record.get("max_atmosphering_speed"));
            starship.setCrew(record.get("crew"));
            starship.setPassengers(record.get("passengers"));
            starship.setCargo_capacity(record.get("cargo_capacity"));
            records.add(new Object[]{search, starship});
        }
        parser.close();
        Log.info("Util.java - Finish reading starships.csv");
        return records.iterator();
    }
    
    //Read data from species.csv
    public static Iterator<Object[]> readSpeciesTestCase() throws IOException {
    	Log.info("Util.java - Start reading species.csv");
        Reporter.log("Util.java - Reading species.csv");
        CSVParser parser = new CSVParser(new FileReader("species.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Object[]> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            String search=record.get("search");
            Specie specie=new Specie();
            specie.setName(record.get("name"));
            specie.setClassification(record.get("classification"));
            specie.setDesignation(record.get("designation"));
            specie.setAverage_height(record.get("average_height"));
            specie.setSkin_colors(record.get("skin_colors"));
            specie.setHair_colors(record.get("hair_colors"));
            specie.setEye_colors(record.get("eye_colors"));
            specie.setAverage_lifespan(record.get("average_lifespan"));	
            records.add(new Object[]{search, specie});
        }
        parser.close();
        Log.info("Util.java - Finish reading species.csv");
        return records.iterator();
    }
    
  //Read data from vehicles.csv
    public static Iterator<Object[]> readVehiclesTestCase() throws IOException {
    	Log.info("Util.java - Start reading vehicles.csv");
        Reporter.log("Util.java - Reading vehicles.csv");
        CSVParser parser = new CSVParser(new FileReader("vehicles.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Object[]> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            String search=record.get("search");
            Vehicle vehicle=new Vehicle();
            vehicle.setName(record.get("name"));
            vehicle.setModel(record.get("model"));
            vehicle.setManufacturer(record.get("manufacturer"));
            vehicle.setCost_in_credits(record.get("cost_in_credits"));
            vehicle.setMax_atmosphering_speed(record.get("max_atmosphering_speed"));
            vehicle.setCrew(record.get("crew"));
            vehicle.setPassengers(record.get("passengers"));
            vehicle.setCargo_capacity(record.get("cargo_capacity"));	
            vehicle.setConsumables(record.get("consumables"));	
            vehicle.setVehicle_class(record.get("vehicle_class"));	
            records.add(new Object[]{search, vehicle});
        }
        parser.close();
        Log.info("Util.java - Finish reading vehicles.csv");
        return records.iterator();
    }
    //*************************** Writing test data and test result to .csv file ****************************//
    // Not only write the the result, but re-write the whole row in case new columns added in the .csv file.
    
  //write result to people.csv
    public static void writePeopleTestRes(List<TestPeople.PeopleTestResult> results) throws IOException {
    	Log.info("Util.java - Start writing people.csv");
        Reporter.log("Util.java - writing people.csv");
        CSVPrinter printer = new CSVPrinter(new FileWriter("people.csv"), CSVFormat.DEFAULT);
        printer.printRecord("search", "name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", "pass/fail"
        );
        printer.printRecord();
        for (TestPeople.PeopleTestResult result : results) {
            String search = result.getSearch();
            Person person = result.getPerson();
            printer.printRecord(search, person.getName(), person.getHeight(), person.getMass(), person.getHair_color(), person.getSkin_color(), person.getEye_color(), person.getBirth_year(), person.getGender(), result.getResult());
        }
        printer.close();
        Log.info("Util.java - Finish writing people.csv");
    }
   //write result to planets.csv
    public static void writePlanetsTestRes(List<TestPlanets.PlanetsTestResult> results) throws IOException {
    	Log.info("Util.java - Start writing planets.csv");
        Reporter.log("Util.java - writing planets.csv");
        CSVPrinter printer = new CSVPrinter(new FileWriter("planets.csv"), CSVFormat.DEFAULT);
        printer.printRecord("search","name","rotation_period","orbital_period","diameter","climate","gravity","terrain","surface_water","population","pass/fail"
        );
        for (TestPlanets.PlanetsTestResult result : results) {
            String search = result.getSearch();
            Planet planet = result.getPlanet();
            printer.printRecord(search, planet.getName(), planet.getRotation_period(), planet.getOrbital_period(), planet.getDiameter(), planet.getClimate(), planet.getGravity(), planet.getTerrain(), planet.getSurface_water(),planet.getPopulation(), result.getResult());
        }
        printer.close();
        Log.info("Util.java - Finish writing planets.csv");
    }
    
  //write result to starships.csv
    public static void writeStarshipsTestRes(List<TestStarships.StarshipsTestResult> results) throws IOException {
    	Log.info("Util.java - Start writing starships.csv");
        Reporter.log("Util.java - writing starships.csv");
        CSVPrinter printer = new CSVPrinter(new FileWriter("starships.csv"), CSVFormat.DEFAULT);
        printer.printRecord("search","name","model","manufacturer","cost_in_credits","length","max_atmosphering_speed","crew","passengers","cargo_capacity","pass/fail"
        );
        for (TestStarships.StarshipsTestResult result : results) {
            String search = result.getSearch();
            Starship starship = result.getStarship();
            printer.printRecord(search, starship.getName(), starship.getModel(), starship.getManufacturer(), starship.getCost_in_credits(), starship.getLength(), starship.getMax_atmosphering_speed(), starship.getCrew(), starship.getPassengers(),starship.getCargo_capacity(),result.getResult());
        }
        printer.close();
        Log.info("Util.java - Finish writing starships.csv");
    }
  
    //write result to species.csv
    public static void writeSpeciesTestRes(List<TestSpecies.SpeciesTestResult> results) throws IOException {
    	Log.info("Util.java - Start writing species.csv");
        Reporter.log("Util.java - writing species.csv");
        CSVPrinter printer = new CSVPrinter(new FileWriter("species.csv"), CSVFormat.DEFAULT);
        printer.printRecord("search","name","classification","designation","average_height","skin_colors","hair_colors","eye_colors","average_lifespan","pass/fail"
        );
        for (TestSpecies.SpeciesTestResult result : results) {
            String search = result.getSearch();
            Specie specie = result.getSpecie();
            printer.printRecord(search, specie.getName(), specie.getClassification(), specie.getDesignation(), specie.getAverage_height(), specie.getSkin_colors(), specie.getHair_colors(), specie.getEye_colors(), specie.getAverage_lifespan(), result.getResult());
        }
        printer.close();
        Log.info("Util.java - Finish writing species.csv");
    }
    
    //write result to vehicles.csv
    public static void writeVehiclesTestRes(List<TestVehicles.VehiclesTestResult> results) throws IOException {
    	Log.info("Util.java - Start writing vehicles.csv");
        Reporter.log("Util.java - writing vehicles.csv");
        CSVPrinter printer = new CSVPrinter(new FileWriter("vehicles.csv"), CSVFormat.DEFAULT);
        printer.printRecord("search","name","model","manufacturer","cost_in_credits","max_atmosphering_speed","crew","passengers","cargo_capacity","consumables","vehicle_class","pass/fail"
        );
        for (TestVehicles.VehiclesTestResult result : results) {
            String search = result.getSearch();
            Vehicle vehicle = result.getVehicle();
            printer.printRecord(search, vehicle.getName(), vehicle.getModel(), vehicle.getManufacturer(), vehicle.getCost_in_credits(), vehicle.getMax_atmosphering_speed(), vehicle.getCrew(), vehicle.getPassengers(),vehicle.getCargo_capacity(),vehicle.getConsumables(),vehicle.getVehicle_class(),result.getResult());
        }
        printer.close();
        Log.info("Util.java - Finish writing vehicles.csv");
    }
}
