package Pages;

import Base.TestBase;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CreditCardPage extends TestBase {

    private final String cookiesPopup = "//div[@class = 'c24-cookie-consent-notice'][contains(@style, 'display: flex')]";
    private final String acceptCookiesButton = ".c24-cookie-consent-notice-buttons a.c24-cookie-consent-button:nth-child(2)";

    //Initializing the Page Objects:
    public CreditCardPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    @Step("Accept cookie popup")
    public void acceptCookies() {
        if (driver.findElement(By.xpath(cookiesPopup)).isDisplayed()) {
            driver.findElement(By.cssSelector(acceptCookiesButton)).click();
        }
    }

    @Step("Find product by order")
    public String getProductIdByOrder(int positionNumber) {
        WebElement element = driver.findElement(By.xpath("//div/span[@class='product-panel__title__counter'][text() ='" + positionNumber + ".']/ancestor::div[2]"));
        return element.getAttribute("id");
    }

    @Step("Find first product in list")
    public String getFirstProductId() {
        WebElement element = driver.findElement(By.xpath("//div/span[@class='product-panel__title__counter'][text() ='1.']/ancestor::div[2]"));
        return element.getAttribute("id");
    }

    @Step("Find first product in list by ID")
    public void selectProductById(String id) {
        WebElement selectButton = driver.findElement(By.xpath("//div[@id='" + id + "']//a[@class='button']"));
        selectButton.click();
    }


}
