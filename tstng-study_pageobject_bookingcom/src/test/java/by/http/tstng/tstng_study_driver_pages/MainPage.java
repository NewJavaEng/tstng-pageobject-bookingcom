package by.http.tstng.tstng_study_driver_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private final String BASE_URL = "https://www.booking.com/";
	
	private static final String BACKSPACE = "BACKSPACE";

	@FindBy(xpath = "//div[@class='sb-searchbox__row u-clearfix ']/descendant::input[@id='ss']")
	private WebElement searchPlace;

	@FindBy(xpath = "//li[@data-i=\"0\"]")
	private WebElement liMinskRegion;

	@FindBy(xpath = "//div[@class=\\\"sb-dates__col --checkin-field\\\"]/div[@class=\\\"sb-date-field__display\\\"]")
	private WebElement checkIn;

	@FindBy(xpath = "//div[@class=\\\"sb-dates__col --checkout-field\\\"]/div[@class=\\\"sb-date-field__display\\\"]")
	private WebElement checkOut;

	@FindBy(xpath = "//td[@data-id=\"1514678400000\"]")
	private WebElement span31InCheckInCalendar;

	@FindBy(xpath = "//td[@data-id=\\\"1514764800000\\\"]/span")
	private WebElement span1InCheckOutCalendar;

	@FindBy(xpath = "//button[@class=\"sb-searchbox__button   \"]/span[text()=\"Проверить цены\"]")
	private WebElement buttonSearch;

	@FindBy(xpath = "//form[@id=\"frm\"]/div[2]/div/div[2]/div")
	private WebElement errorMessage;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public ResultPage inputSearchParameters(WebDriver driver, String place) {
		searchPlace.sendKeys(place);
		liMinskRegion.click();
		span31InCheckInCalendar.click();
		buttonSearch.click();
		ResultPage bookingResultPage = new ResultPage(driver);
		return bookingResultPage;
	}

	public void inputSearchWithoutPlace(String place) {
		searchPlace.sendKeys(place);
		liMinskRegion.click();
//		CANNOT DELET VALUE FROM THE FIELD (once it was OK, and that's it!)
		span31InCheckInCalendar.click();
//		searchPlace.click();
		driver.findElement(By.xpath("//div[@class='sb-searchbox__row u-clearfix ']/descendant::input[@id='ss']")).sendKeys(Keys.BACK_SPACE);
//		searchPlace.sendKeys("\u0008");
		buttonSearch.click();
		
		
	}

	public void inputCorrectSymboSearchPlace(String place) {
		searchPlace.sendKeys(place);
	}

	public String getCorrectSymbolSearchPlace() {
		String correctSymbolSearchPlace = searchPlace.getAttribute("value");
		return correctSymbolSearchPlace;
	}

	public String errorMessagePlaceEmpty() {
		String errorMessagePlaceEmpty = errorMessage.getText();
		return errorMessagePlaceEmpty;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
