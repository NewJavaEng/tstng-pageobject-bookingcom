package by.http.tstng.tstng_study;

import org.testng.annotations.Test;

import by.http.tstng.tstng_study_driver_steps.Steps;

import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;

public class BookingComTest {

	private Steps steps;
	private static final String PLACE = "Minsk";
	private static final int MIN_RESULT = 5;
	private static final String ERROR_MESSAGE_PLACE = "Введите направление." + "/n" + "Не знаете, куда поехать? Найдите идеальное место для поездки.";
	private static final String SYMBOLS_SEARCH_PLACE = "New York 92986";
	private static final String CORRECT_US_PRICE = "US$0 - US$59 за ночь";
	private static final int NUMBER_OF_POPULAR_CHECKBOX = 7; /*number of checkboxes differs depending on browser, selected place, etc.*/

	@BeforeMethod(description = "Init browser")
	public void beforeMethod() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test /*(description = "PLACE = Minsk, only hotels; test passes only if RESULT >= 5")*/
	public void testMinResult() {
		steps.selectMinsk(PLACE);
		assertTrue(steps.resultIsMoreThan5(MIN_RESULT));
	}

	@Test(enabled = false) /*(description = "Destination, property name or address field should accept letters and digits") */
	public void testPlaceAcceptDigit() {
		steps.correctSymbolsPlaceSearch(SYMBOLS_SEARCH_PLACE);
		assertTrue(steps.isCorrectSymbolSearch(SYMBOLS_SEARCH_PLACE));
	}

	@Test(enabled = false) /*(description = "Destination, property name or address field cannot be empty -> Error is shown")*/
	public void testErrorMessagePlace() {
		steps.resultWithoutPlace(PLACE);
		assertTrue(steps.isMessagePlaceEmpty(ERROR_MESSAGE_PLACE));
	}

	@Test(enabled = false) /*(description = "Currency icon should be clickable; user can change currency to the required one")*/
	public void testCurrencyIcon() {
		steps.currencyIconClickable(PLACE);
		assertTrue(steps.isCurrencyIconClickable(CORRECT_US_PRICE));
	}

	@Test(enabled = false)  /* (description = "'Popular' optional filter should contain 7 checkboxes") */
	public void testQuantityOfPopular() {
		steps.quantityOfPopularCheckbox(PLACE);
		assertTrue(steps.numOfPopularCheckboxes(NUMBER_OF_POPULAR_CHECKBOX));
	}

	@AfterMethod
	public void afterMethod() {
		steps.closeDriver();
	}

}
