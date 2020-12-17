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
import entity.Starship;
import objects.SearchPage;

public class TestStarships {
	WebDriver driver;
    List<StarshipsTestResult> result = new ArrayList<>();

    @BeforeClass
    public void init() {
        driver = new ChromeDriver();
        String url = Constant.URL;
        driver.get(url);
        driver.manage().window().maximize();// maximum the window
        Log.info("TestStarships.java - TestStarships.java - open " + url);
        Reporter.log("TestStarships.java - TestStarships.java - open " + url);
    }
    
    @DataProvider(name = "starship")
    public Iterator<Object[]> starshipsData() throws IOException {
        return Util.readStarshipsTestCase();
    }

    @Test(dataProvider = "starship")
    public void testStarship(String search, Starship starship) {
        WebElement searchInput = SearchPage.searchInput(driver);
    	WebElement requestBtn = SearchPage.requestBtn(driver);
    	WebElement output = SearchPage.output(driver);
    	
    	searchInput.clear();
        Log.info("TestStarships.java - clear searchInput area.");
        searchInput.sendKeys(search);
        Log.info("TestStarships.java - input "+search);
        Reporter.log("TestStarships.java - input "+search);
        requestBtn.click();
        Log.info("TestStarships.java - click request button");
        Reporter.log("TestStarships.java - click request button");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = output.getText();
        Log.info("TestStarships.java - get text from response body.");
        Reporter.log("TestStarships.java - Response assertion starts.");
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        // parse JSON to map
        Map<String, String> map = g.fromJson(text, new TypeToken<Map<String, Object>>() {
        }.getType());
        Assert.assertEquals(starship.getName(), map.get("name"));
        Log.info("TestStarships.java - assert name");
        Assert.assertEquals(starship.getModel(), map.get("model"));
        Log.info("TestStarships.java - assert model");
        Assert.assertEquals(starship.getManufacturer(), map.get("manufacturer"));
        Log.info("TestStarships.java - assert manufacturer");
        Assert.assertEquals(starship.getCost_in_credits(), map.get("cost_in_credits"));
        Log.info("TestStarships.java - assert cost_in_credits");
        Assert.assertEquals(starship.getLength(), map.get("length"));
        Log.info("TestStarships.java - assert length");
        Assert.assertEquals(starship.getMax_atmosphering_speed(), map.get("max_atmosphering_speed"));
        Log.info("TestStarships.java - assert max_atmosphering_speed");
        Assert.assertEquals(starship.getCrew(), map.get("crew"));
        Log.info("TestStarships.java - assert crew");
        Assert.assertEquals(starship.getPassengers(), map.get("passengers"));
        Log.info("TestStarships.java - assert passengers");
        Assert.assertEquals(starship.getCargo_capacity(), map.get("cargo_capacity"));
        Log.info("TestStarships.java - assert cargo_capacity");
        Reporter.log("TestStarships.java - Response assertion ends.");
    }
    
    @AfterClass
    public void clear() {
        driver.close();
        Log.info("TestStarships.java - browser closed.");
    }
    
    @AfterMethod
    public void result(ITestResult result) {
        // collect test result
    	Log.info("TestStarships.java - collect test result,start comparison.");
    	Reporter.log("TestStarships.java - Start compare results.");
        int status = result.getStatus();
        Object[] parameters = result.getParameters();
        String search = (String) parameters[0];
        Starship starship = (Starship) parameters[1];
        this.result.add(status == ITestResult.SUCCESS ? new StarshipsTestResult(search, starship, "pass") : new StarshipsTestResult(search, starship, "fail"));
        Reporter.log("TestStarships.java - test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
        Log.info("TestStarships.java - Comparison ends,test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
    }
    
    @AfterClass
    public void writeRes() {
        // write test res
        try {
            Util.writeStarshipsTestRes(this.result);
        } catch (IOException e) {
        	Log.error("TestStarships.java - Error occurred while write result to csv file.");
            e.printStackTrace();
        }
        Reporter.log("TestStarships.java - close browser.");
        Log.info("TestStarships.java - close browser");
    }
    
    public static class StarshipsTestResult {
        String search;
        Starship starship;
        String result;

        public StarshipsTestResult(String search, Starship starship, String result) {
            this.search = search;
            this.starship = starship;
            this.result = result;
        }

        public String getSearch() {
            return search;
        }

        public Starship getStarship() {
            return starship;
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
