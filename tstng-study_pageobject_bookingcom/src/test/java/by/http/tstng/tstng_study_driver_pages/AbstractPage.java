package by.http.tstng.tstng_study_driver_pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public abstract void openPage();

}
