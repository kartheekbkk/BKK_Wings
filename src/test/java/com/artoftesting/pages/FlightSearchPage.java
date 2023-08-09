package com.artoftesting.pages;

import java.lang.reflect.Array;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;



public class FlightSearchPage {

	WebDriver driver;
	
	private static final Logger log = LogManager.getLogger(FlightSearchPage.class);
	
	@FindBy(xpath="//div[@class='o-station-select__new-station-list__station']")
	List<WebElement> airportList;
	
	@FindBy(xpath="//span[contains(text(),'Departure')]")
	WebElement departureAirportButton;
	
	@FindBy(xpath="//button[@class='o-compact-search__cta-button-button']")
	List<WebElement> airportButtons;
	
	@FindBy(xpath="//button[@class='cookie-consent--cta-accept a-cta a-cta-prio1']")
	WebElement iUnderstand;
	
	@FindBy(xpath="//input[@class='calendar-date__input'][not(contains(@aria-disabled,'true'))]")
	List<WebElement> activeDates;
	
	@FindBy(xpath="//input[@name='datepicker_input_27']")
	WebElement date;
	
	@FindBy(xpath="//button[@type='submit']//span[contains(text(),'Show flight')]")
	WebElement showFlightsButton;
	
	@FindBy(xpath="//div[@class='o-search-flight-status__card-time-details']")
	List<WebElement> flightDetails;
	
	@FindBy(xpath="//button[@class='o-search-flight-status__date-navigation__date o-search-flight-status__date-navigation__date--align-center'][not(contains(@disabled,'disabled'))]")
	List<WebElement> searchResultsAvailableDates;
	
	@FindBy(xpath="//div[@class='o-search-flight-status__card-flight-number']")
	List<WebElement> flightNumber;
	
	@FindBy(xpath="//h2[@class='a-headline a-headline--h4'][contains(text(),'Unfortunately')]")
	WebElement noFlightsMessage;
	
	public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
        	
	public void selectAirportName(String airportName) {
		
		String xpath = "//div[@class='o-station-select__new-station-list__station']//span[contains(text(),'%airportName%')]";
		driver.findElement(By.xpath(xpath.replace("%airportName%", airportName))).click();
		
	}
	
	public List<WebElement> getAirportButtons() {
		return airportButtons;
	}
	public WebElement getIUnderstand() {
		return iUnderstand;
	}
	
	public List<WebElement> getActiveDates() {
		return activeDates;
	}
	
	public WebElement getDate() {
		return date;
	}
	
	public List<WebElement> getAirportList() {
		return airportList;
	}
	
	public WebElement getShowFlights() {
		return showFlightsButton;
	}
	
	public List<WebElement> getFlightDetails() {
		return flightDetails;
	}
	
	public List<WebElement> getSearchResultsAvailableDates() {
		return searchResultsAvailableDates;
	}
	
	public List<WebElement> getFlightNumber(){
		return flightNumber;
	}
	
	public WebElement getNoFlightsMessage() {
		return noFlightsMessage;
	}
	////p[contains(text(),"353")]/following-sibling::button
	
	
	
}
