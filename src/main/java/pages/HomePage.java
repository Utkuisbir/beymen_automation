package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.beymen.com/";
    private WebElement searchBox;

    
    public void navigateToHomePage() {
        driver.get(HOMEPAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Ürün, Marka Arayın']")));
    
    }

    public void enterSearchKeyword(String keyword) {
        searchBox = driver.findElement(By.cssSelector("input[placeholder='Ürün, Marka Arayın']"));
        searchBox.sendKeys(keyword);
    }

    public void clearSearchBox() {
        searchBox.clear();
    }

    public void pressEnterKey() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public boolean isHomePageOpened() {
        return driver.getCurrentUrl().equals(HOMEPAGE_URL);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
