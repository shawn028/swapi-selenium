package autotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import commons.Constant;
import commons.Log;
import entity.Vehicle;
import objects.SearchPage;

public class TestVehicles {
	WebDriver driver;
    List<VehiclesTestResult> result = new ArrayList<>();

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        String url = Constant.URL;
        driver.get(url);
        driver.manage().window().maximize();// maximum the window
        Log.info("TestVehicles.java - TestVehicles.java - open " + url);
        Reporter.log("TestVehicles.java - TestVehicles.java - open " + url);
    }

    @DataProvider(name = "vehicle")
    public Iterator<Object[]> vehiclesData() throws IOException {
        return Util.readVehiclesTestCase();
    }
    
    @Test(dataProvider = "vehicle")
    public void testVehicle(String search, Vehicle vehicle) {
        WebElement searchInput = SearchPage.searchInput(driver);
    	WebElement requestBtn = SearchPage.requestBtn(driver);
    	WebElement output = SearchPage.output(driver);
    	
    	searchInput.clear();
        Log.info("TestVehicles.java - TestVehicles.java - clear searchInput area.");
        searchInput.sendKeys(search);
        Log.info("TestVehicles.java - TestVehicles.java - input "+search);
        Reporter.log("TestVehicles.java - TestVehicles.java - input "+search);
        requestBtn.click();
        Log.info("TestVehicles.java - TestVehicles.java - click request button");
        Reporter.log("TestVehicles.java - click request button");
    	
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = output.getText();
        Log.info("TestVehicles.java - TestVehicles.java - get text from response body.");
        Reporter.log("TestVehicles.java - Response assertion starts.");
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        // parse JSON to map
        Map<String, String> map = g.fromJson(text, new TypeToken<Map<String, Object>>() {
        }.getType());
        Assert.assertEquals(vehicle.getName(), map.get("name"));
        Log.info("TestVehicles.java - assert name");
        Assert.assertEquals(vehicle.getModel(), map.get("model"));
        Log.info("TestVehicles.java - assert model");
        Assert.assertEquals(vehicle.getManufacturer(), map.get("manufacturer"));
        Log.info("TestVehicles.java - assert manufacturer");
        Assert.assertEquals(vehicle.getCost_in_credits(), map.get("cost_in_credits"));
        Log.info("TestVehicles.java - assert cost_in_credits");
        Assert.assertEquals(vehicle.getMax_atmosphering_speed(), map.get("max_atmosphering_speed"));
        Log.info("TestVehicles.java - assert max_atmosphering_speed");
        Assert.assertEquals(vehicle.getCrew(), map.get("crew"));
        Log.info("TestVehicles.java - assert crew");
        Assert.assertEquals(vehicle.getPassengers(), map.get("passengers"));
        Log.info("TestVehicles.java - assert passengers");
        Assert.assertEquals(vehicle.getCargo_capacity(), map.get("cargo_capacity"));
        Log.info("TestVehicles.java - assert cargo_capacity");
        Assert.assertEquals(vehicle.getConsumables(), map.get("consumables"));
        Log.info("TestVehicles.java - assert consumables");
        Assert.assertEquals(vehicle.getVehicle_class(), map.get("vehicle_class"));
        Log.info("TestVehicles.java - assert vehicle_class");
        Reporter.log("TestVehicles.java - Response assertion ends.");
    }
    
    @AfterClass
    public void clear() {
        driver.close();
    }

    @AfterMethod
    public void result(ITestResult result) {
        // collect test result
    	Log.info("TestVehicles.java - Building test result.");
    	Reporter.log("TestVehicles.java - Building test result.");
        int status = result.getStatus();
        Object[] parameters = result.getParameters();
        String search = (String) parameters[0];
        Vehicle vehicle = (Vehicle) parameters[1];
        this.result.add(status == ITestResult.SUCCESS ? new VehiclesTestResult(search, vehicle, "pass") : new VehiclesTestResult(search, vehicle, "fail"));
        Reporter.log("TestVehicles.java - test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
        Log.info("TestVehicles.java - Test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
    }

    @AfterClass
    public void writeRes() {
        // write test res
        try {
            Util.writeVehiclesTestRes(this.result);
        } catch (IOException e) {
        	Log.error("TestVehicles.java - Error occurred while write result to csv file.");
            e.printStackTrace();
        }
        Reporter.log("TestVehicles.java - close browser.");
        Log.info("TestVehicles.java - close browser");
    }

    public static class VehiclesTestResult {
        String search;
        Vehicle vehicle;
        String result;

        public VehiclesTestResult(String search, Vehicle vehicle, String result) {
            this.search = search;
            this.vehicle = vehicle;
            this.result = result;
        }

        public String getSearch() {
            return search;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public String getResult() {
            return result;
        }
    }
    
    @org.testng.annotations.BeforeClass
    public void BeforeClass(){
        DOMConfigurator.configure("log4j.xml");
    }
}
