package autotest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import commons.Constant;
import commons.Log;
import entity.Planet;
import objects.SearchPage;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestPlanets {
    WebDriver driver;
    List<PlanetsTestResult> result = new ArrayList<>();

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        String url = Constant.URL;
        driver.get(url);
        driver.manage().window().maximize();// maximum the window
        Log.info("TestPlanets.java - TestPlanets.java - open " + url);
        Reporter.log("TestPlanets.java - TestPlanets.java - open " + url);
    }

    @DataProvider(name = "planets")
    public Iterator<Object[]> planetsData() throws IOException {
        return Util.readPlanetsTestCase();
    }

    @Test(dataProvider = "planets")
    public void testPlanet(String search, Planet planet) {
    	WebElement searchInput = SearchPage.searchInput(driver);
    	WebElement requestBtn = SearchPage.requestBtn(driver);
    	WebElement output = SearchPage.output(driver);
    	
    	searchInput.clear();
        Log.info("TestPlanets.java - clear searchInput area.");
        searchInput.sendKeys(search);
        Log.info("TestPlanets.java - input "+search);
        Reporter.log("TestPlanets.java - input "+search);
        requestBtn.click();
        Log.info("TestPlanets.java - click request button");
        Reporter.log("TestPlanets.java - click request button");
    	
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = output.getText();
        Log.info("TestPlanets.java - get text from response body.");
        Reporter.log("TestPlanets.java - Response assertion starts.");
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        // parse JSON to map
        Map<String, String> map = g.fromJson(text, new TypeToken<Map<String, Object>>() {
        }.getType());
        Assert.assertEquals(planet.getName(), map.get("name"));
        Log.info("TestPlanets.java - assert name");
        Assert.assertEquals(planet.getRotation_period(), map.get("rotation_period"));
        Log.info("TestPlanets.java - assert rotation_period");
        Assert.assertEquals(planet.getOrbital_period(), map.get("orbital_period"));
        Log.info("TestPlanets.java - assert orbital_period");
        Assert.assertEquals(planet.getDiameter(), map.get("diameter"));
        Log.info("TestPlanets.java - assert diameter");
        Assert.assertEquals(planet.getClimate(), map.get("climate"));
        Log.info("TestPlanets.java - assert climate");
        Assert.assertEquals(planet.getGravity(), map.get("gravity"));
        Log.info("TestPlanets.java - assert gravity");
        Assert.assertEquals(planet.getTerrain(), map.get("terrain"));
        Log.info("TestPlanets.java - assert terrain");
        Assert.assertEquals(planet.getSurface_water(), map.get("surface_water"));
        Log.info("TestPlanets.java - assert surface_water");
        Assert.assertEquals(planet.getPopulation(), map.get("population"));
        Log.info("TestPlanets.java - assert population");
        Reporter.log("TestPlanets.java - Response assertion ends.");
        //searchInput.clear();
    }

    @AfterClass
    public void clear() {
        driver.close();
    }

    @AfterMethod
    public void result(ITestResult result) {
        // collect test result
    	Log.info("TestPlanets.java - collect test result,start comparison.");
    	Reporter.log("TestPlanets.java - Start compare results.");
        int status = result.getStatus();
        Object[] parameters = result.getParameters();
        String search = (String) parameters[0];
        Planet planet = (Planet) parameters[1];
        this.result.add(status == ITestResult.SUCCESS ? new PlanetsTestResult(search, planet, "pass") : new PlanetsTestResult(search, planet, "fail"));
        Reporter.log("TestPlanets.java - test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
        Log.info("TestPlanets.java - Comparison ends,test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
    }

    @AfterClass
    public void writeRes() {
        // write test res
        try {
            Util.writePlanetsTestRes(this.result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("TestPlanets.java - close browser.");
        Log.info("TestPlanets.java - close browser");
    }

    public static class PlanetsTestResult {
        String search;
        Planet planet;
        String result;

        public PlanetsTestResult(String search, Planet planet, String result) {
            this.search = search;
            this.planet = planet;
            this.result = result;
        }

        public String getSearch() {
            return search;
        }

        public Planet getPlanet() {
            return planet;
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
