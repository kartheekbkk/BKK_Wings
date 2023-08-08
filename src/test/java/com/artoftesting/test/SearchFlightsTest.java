package com.artoftesting.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.artoftesting.base.TestBase;
import com.artoftesting.pages.FlightSearchPage;


public class SearchFlightsTest extends TestBase{

	FlightSearchPage flightSearchPage;
	TestBase testBase = new TestBase();
	

	//Log4j configuration
	private static final Logger log = LogManager.getLogger(SearchFlightsTest.class);
	
	//search flights on a particular date, verify if flights are available on other available days as well
	@Test
	public void searchFlights() throws Exception{
		
		log.info("Searching for flights on a date");
		
		flightSearchPage = new FlightSearchPage(driver);
		
		testBase.waitForElementPresent(flightSearchPage.getIUnderstand());
		flightSearchPage.getIUnderstand().click();
		
		testBase.waitForElementPresent(flightSearchPage.getAirportButtons().get(0));
		flightSearchPage.getAirportButtons().get(0).click();
		flightSearchPage.selectAirportName("CGN");
		
		flightSearchPage.getAirportButtons().get(1).click();
		flightSearchPage.selectAirportName("BER");
		
		flightSearchPage.getDate().click();
		flightSearchPage.getActiveDates().get(0);
		flightSearchPage.getActiveDates().get(0).click();
		flightSearchPage.getShowFlights().click();
		
		testBase.waitForElementPresent(flightSearchPage.getFlightDetails().get(0));
		
		Assert.assertTrue(flightSearchPage.getFlightDetails().size()!=0, "No Flights are found for this flight route on this date");
		
		testBase.waitForElementPresent(flightSearchPage.getSearchResultsAvailableDates().get(0));
		
		flightSearchPage.getSearchResultsAvailableDates().get(0).click();
		testBase.waitForElementPresent(flightSearchPage.getFlightDetails().get(0));
		Assert.assertTrue(flightSearchPage.getFlightDetails().size()!=0, "No Flights are found for this flight route on this" + flightSearchPage.getSearchResultsAvailableDates().get(0).getText());
		
		
	}
	
	@Test
	public void verifyNoFlightsFound() throws Exception {
		log.info("Verify no flights found message is shown when there are no flight route");
		
		flightSearchPage = new FlightSearchPage(driver);
		
		testBase.waitForElementPresent(flightSearchPage.getIUnderstand());
		flightSearchPage.getIUnderstand().click();
		
		testBase.waitForElementPresent(flightSearchPage.getAirportButtons().get(0));
		flightSearchPage.getAirportButtons().get(0).click();
		flightSearchPage.selectAirportName("LHR");
		
		flightSearchPage.getAirportButtons().get(1).click();
		flightSearchPage.selectAirportName("BER");
		
		flightSearchPage.getDate().click();
		flightSearchPage.getActiveDates().get(0);
		flightSearchPage.getActiveDates().get(0).click();
		flightSearchPage.getShowFlights().click();
		
		testBase.waitForElementPresent(flightSearchPage.getNoFlightsMessage());
		
		Assert.assertTrue(flightSearchPage.getNoFlightsMessage().isDisplayed(), "No Flights message is not found");
				
	}
	
	@Test
	public void verifyFlightNumberDislayedInSearchResults() throws Exception {
		log.info("Verify if all flight details are showing flight number");
		
		flightSearchPage = new FlightSearchPage(driver);
		
		testBase.waitForElementPresent(flightSearchPage.getIUnderstand());
		flightSearchPage.getIUnderstand().click();
		
		testBase.waitForElementPresent(flightSearchPage.getAirportButtons().get(0));
		flightSearchPage.getAirportButtons().get(0).click();
		flightSearchPage.selectAirportName("CGN");
		
		flightSearchPage.getAirportButtons().get(1).click();
		flightSearchPage.selectAirportName("BER");
		
		flightSearchPage.getDate().click();
		flightSearchPage.getActiveDates().get(0);
		flightSearchPage.getActiveDates().get(0).click();
		flightSearchPage.getShowFlights().click();
		
		testBase.waitForElementPresent(flightSearchPage.getFlightDetails().get(0));
		
		Assert.assertTrue(flightSearchPage.getFlightDetails().size()!=0, "No Flights are found for this flight route on this date");
		Assert.assertTrue(flightSearchPage.getFlightNumber().size() == flightSearchPage.getFlightDetails().size(), "Flight number is not dislayed in one of flight details");
			
	}
}
