package autotest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import commons.Log;

import commons.Constant;

import entity.Person;
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
import java.util.*;

public class TestPeople {
    private WebDriver driver;
    List<PeopleTestResult> result = new ArrayList<>();
    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        String url = Constant.URL;
        driver.get(url);
        driver.manage().window().maximize();// maximum the window
        Log.info("TestPeople.java - TestPeople.java - open " + url);
        Reporter.log("TestPeople.java - TestPeople.java - open " + url);
    }

    @DataProvider(name = "people")
    public Iterator<Object[]> peopleData() throws IOException {
        return Util.readPeopleTestCase();
        
    }

    //This test method declares that its data should be supplied by the Data Provider
//named "test1"
    @Test(dataProvider = "people")
    public void testPeople(String search, Person person) {
    	WebElement searchInput = SearchPage.searchInput(driver);
    	WebElement requestBtn = SearchPage.requestBtn(driver);
    	WebElement output = SearchPage.output(driver);
    	
        searchInput.clear();
        Log.info("TestPeople.java - clear searchInput area.");
        searchInput.sendKeys(search);
        Log.info("TestPeople.java - input "+search);
        Reporter.log("TestPeople.java - input "+search);
        requestBtn.click();
        Log.info("TestPeople.java - click request button");
        Reporter.log("TestPeople.java - click request button");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = output.getText();
        Log.info("TestPeople.java - get text from response body.");
        Reporter.log("TestPeople.java - Response assertion starts.");
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        // parse JSON to map
        Map<String, String> map = g.fromJson(text, new TypeToken<Map<String, Object>>() {}.getType());
        //Start compare .csv data(person) and response data(map).
        Log.info("TestPeople.java - Assertion starts.");
        Assert.assertEquals(person.getName(), map.get("name"));
        Log.info("TestPeople.java - assert name");
        Assert.assertEquals(person.getHeight(), map.get("height"));
        Log.info("TestPeople.java - assert height");
        Assert.assertEquals(person.getMass(), map.get("mass"));
        Log.info("TestPeople.java - assert mass");
        Assert.assertEquals(person.getHair_color(), map.get("hair_color"));
        Log.info("TestPeople.java - assert hair_color");
        Assert.assertEquals(person.getSkin_color(), map.get("skin_color"));
        Log.info("TestPeople.java - assert skin_color");
        Assert.assertEquals(person.getEye_color(), map.get("eye_color"));
        Log.info("TestPeople.java - assert eye_color");
        Assert.assertEquals(person.getBirth_year(), map.get("birth_year"));
        Log.info("TestPeople.java - assert birth_year");
        Assert.assertEquals(person.getGender(), map.get("gender"));
        Log.info("TestPeople.java - assert gender");
        Reporter.log("TestPeople.java - Response assertion ends.");
        //searchInput.clear();
    }

    @AfterMethod
    public void result(ITestResult result){
        // collect test result from search result
    	Log.info("TestPeople.java - collect test result,start comparison.");
    	Reporter.log("TestPeople.java - Start compare results.");
        int status = result.getStatus();
        Object[] parameters = result.getParameters();
        String search = (String) parameters[0];
        Person person= (Person) parameters[1];
        this.result.add(status == ITestResult.SUCCESS ? new PeopleTestResult(search, person, "pass") : new PeopleTestResult(search, person, "fail"));
        Reporter.log("TestPeople.java - test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
        Log.info("TestPeople.java - Comparison ends,test "+search+(status == ITestResult.SUCCESS?" pass.":" fail."));
    }

    @AfterClass
    public void writeRes(){
        // write test result, the result contains all endpoint properties and the pass or fail.
        try {
            Util.writePeopleTestRes(this.result);
        } catch (IOException e) {
        	Log.error("TestPeople.java - Error occurred while write result to csv file.");
            e.printStackTrace();
        }
        driver.close();
        Reporter.log("TestPeople.java - close browser.");
        Log.info("TestPeople.java - close browser");

    }

    public static class PeopleTestResult{
        String search;
        Person person;
        String result;

        public PeopleTestResult(String search, Person person, String result) {
            this.search = search;
            this.person = person;
            this.result = result;
        }

        public String getSearch() {
            return search;
        }

        public Person getPerson() {
            return person;
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
