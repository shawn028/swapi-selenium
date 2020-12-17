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
import entity.Specie;
import objects.SearchPage;

public class TestSpecies {
	WebDriver driver;
    List<SpeciesTestResult> result = new ArrayList<>();
    
    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        String url = Constant.URL;
        driver.get(url);
        driver.manage().window().maximize();// maximum the window
        Log.info("TestSpecies.java - TestSpecies.java - open " + url);
        Reporter.log("TestSpecies.java - TestSpecies.java - open " + url);
    }

    @DataProvider(name = "species")
    public Iterator<Object[]> speciesData() throws IOException {
        return Util.readSpeciesTestCase();
    }
    
    @Test(dataProvider = "species")
    public void testSpecie(String search, Specie specie) {
    	WebElement searchInput = SearchPage.searchInput(driver);
    	WebElement requestBtn = SearchPage.requestBtn(driver);
    	WebElement output = SearchPage.output(driver);
    	
    	searchInput.clear();
        Log.info("TestSpecies.java - TestSpecies.java - clear searchInput area.");
        searchInput.sendKeys(search);
        Log.info("TestSpecies.java - input "+search);
        Reporter.log("TestSpecies.java - input "+search);
        requestBtn.click();
        Log.info("TestSpecies.java - click request button");
        Reporter.log("TestSpecies.java - click request button");
    	
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = output.getText();
        Log.info("TestSpecies.java - get text from response body.");
        Reporter.log("TestSpecies.java - Response assertion starts.");
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        // parse JSON to map
        Map<String, String> map = g.fromJson(text, new TypeToken<Map<String, Object>>() {
        }.getType());
        Assert.assertEquals(specie.getName(), map.get("name"));
        //Assert.assertEquals(specie.getName(), map.get("name"));
        Log.info("TestSpecies.java - assert name");
        Assert.assertEquals(specie.getClassification(), map.get("classification"));
        Log.info("TestSpecies.java - assert classification");
        Assert.assertEquals(specie.getDesignation(), map.get("designation"));
        Log.info("TestSpecies.java - assert designation");
        Assert.assertEquals(specie.getAverage_height(), map.get("average_height"));
        Log.info("TestSpecies.java - assert average_height");
        Assert.assertEquals(specie.getSkin_colors(), map.get("skin_colors"));
        Log.info("TestSpecies.java - assert skin_colors");
        Assert.assertEquals(specie.getHair_colors(), map.get("hair_colors"));
        Log.info("TestSpecies.java - assert hair_colors");
        Assert.assertEquals(specie.getEye_colors(), map.get("eye_colors"));
        Log.info("TestSpecies.java - assert eye_colors");
        Assert.assertEquals(specie.getAverage_lifespan(), map.get("average_lifespan"));
        Log.info("TestSpecies.java - assert average_lifespan");
        Reporter.log("TestSpecies.java - Response assertion ends.");
        //searchInput.clear();
    }
    
    @AfterClass
    public void clear() {
        driver.close();
    }
    
    @AfterMethod
    public void result(ITestResult result) {
        // collect test result
    	Log.info("TestSpecies.java - collect test result,start comparison.");
    	Reporter.log("TestSpecies.java - Start compare results.");
        int status = result.getStatus();
        Object[] parameters = result.getParameters();
        String search = (String) parameters[0];
        Specie specie = (Specie) parameters[1];
        this.result.add(status == ITestResult.SUCCESS ? new SpeciesTestResult(search, specie, "pass") : new SpeciesTestResult(search, specie, "fail"));
        Reporter.log("TestSpecies.java - test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
        Log.info("TestSpecies.java - Comparison ends,test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
    }
    
    @AfterClass
    public void writeRes() {
        // write test res
        try {
            Util.writeSpeciesTestRes(this.result);
        } catch (IOException e) {
        	Log.error("TestSpecies.java - Error occurred while write result to csv file.");
            e.printStackTrace();
        }
        Reporter.log("TestSpecies.java - close browser.");
        Log.info("TestSpecies.java - close browser");
    }
    
    public static class SpeciesTestResult {
        String search;
        Specie specie;
        String result;

        public SpeciesTestResult(String search, Specie specie, String result) {
            this.search = search;
            this.specie = specie;
            this.result = result;
        }

        public String getSearch() {
            return search;
        }

        public Specie getSpecie() {
            return specie;
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
