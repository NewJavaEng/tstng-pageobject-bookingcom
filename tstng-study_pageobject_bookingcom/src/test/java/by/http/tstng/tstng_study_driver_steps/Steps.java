package by.http.tstng.tstng_study_driver_steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.http.tstng.tstng_study_driver.Driver;
import by.http.tstng.tstng_study_driver_pages.MainPage;
import by.http.tstng.tstng_study_driver_pages.ResultPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = Driver.getDriver();
	}

	public void closeDriver() {
		Driver.closeDriver();
	}

	public void selectMinsk(String place) {
		MainPage bookingMainPage = new MainPage(driver);
		bookingMainPage.openPage();
		ResultPage bookingResultPage = bookingMainPage.inputSearchParameters(driver, place);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		bookingResultPage.setAdditionalFilter();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Search returned the following # of results: " + bookingResultPage.getResult());

	}

	public boolean resultIsMoreThan5(int minimalQuantity) {
		ResultPage bookingResultPage = new ResultPage(driver);
		int result = bookingResultPage.getResult();
		return result >= minimalQuantity;
	}

	public void resultWithoutPlace(String place) {
		MainPage bookingMainPage = new MainPage(driver);
		bookingMainPage.openPage();
		bookingMainPage.inputSearchWithoutPlace(place);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean isMessagePlaceEmpty(String errorMessagePlaceOfPlacement) {
		MainPage bookingMainPage = new MainPage(driver);
		String errorMessage = bookingMainPage.errorMessagePlaceEmpty();
		System.out.println(errorMessage);
		return errorMessage.equals(errorMessagePlaceOfPlacement);
	}

	public void correctSymbolsPlaceSearch(String symbols) {
		MainPage bookingMainPage = new MainPage(driver);
		bookingMainPage.openPage();
		bookingMainPage.inputCorrectSymboSearchPlace(symbols);
	}

	public boolean isCorrectSymbolSearch(String correctSymbols) {
		MainPage bookingMainPage = new MainPage(driver);
		String result = bookingMainPage.getCorrectSymbolSearchPlace();
		System.out.println(result);
		return result.equals(correctSymbols);
	}

	public void currencyIconClickable(String place) {
		MainPage bookingMainPage = new MainPage(driver);
		bookingMainPage.openPage();
		ResultPage bookingResultPage = bookingMainPage.inputSearchParameters(driver, place);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bookingResultPage.chooseUSCurrency();
	}

	public boolean isCurrencyIconClickable(String correctUSlineOfPrice) {
		ResultPage bookingResultPage = new ResultPage(driver);
		String lineOfUSPrice = bookingResultPage.getLineOfUSPrice();
		System.out.println("Currency is changed from BYN to US: " + lineOfUSPrice);
		return lineOfUSPrice.equals(correctUSlineOfPrice);
	}

	public void quantityOfPopularCheckbox(String place) {
		MainPage bookingMainPage = new MainPage(driver);
		bookingMainPage.openPage();
		ResultPage bookingResultPage = bookingMainPage.inputSearchParameters(driver, place);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean numOfPopularCheckboxes(int correctQuantityOfPopularCheckBoxs) {
		ResultPage bookingResultPage = new ResultPage(driver);
		List<WebElement> listOfPopularCheckBoxs = bookingResultPage.getListOfPopularCheckbox();
		int quantityOfPopularCheckBoxs = listOfPopularCheckBoxs.size();
		System.out.println("Number of checkboxes in 'Popular' filter: " + quantityOfPopularCheckBoxs);
		return quantityOfPopularCheckBoxs == correctQuantityOfPopularCheckBoxs;
	}

}
