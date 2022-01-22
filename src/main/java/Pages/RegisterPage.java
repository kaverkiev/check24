package Pages;

import Base.TestBase;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class RegisterPage extends TestBase {

    private final String loginButton = "//button[@id='c24-uli-login-btn']";
    private final String registerButton = "//button[@id='c24-uli-register-btn']";
    private final String registerFromButton = "//a[@target='_self']";
    private final String emailInput = "//input[@data-tid='input-login']";
    private final String guestOption = "(//div[@class='c24-uli-cl-box-option style-scope unified-login'])[2]";
    private final String errorMessage = "//div[@type='ERROR']";
    private final String[] expectedErrorsList = {"Bitte wählen Sie Ihre Anrede aus.", "Bitte geben Sie Ihren Vornamen an.", "Bitte geben Sie Ihren Nachnamen an.", "Bitte geben Sie Ihr Geburtsdatum an.", "Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer."};
    private final String frauRadioButton = "//label[@for='GENDER_FEMALE']";
    private final String herrRadioButton = "//label[@for='GENDER_MALE']";
    private final String firstNameInput = "GIVEN_NAME";
    private final String lastNameInput = "LAST_NAME";
    private final String dateOfBirthInput = "DATE_OF_BIRTH";
    private final String phoneNumberInput = "PHONENUMBER_MOBILE";
    private final String contactEmailInput = "CONTACT_EMAIL";
    private final String placeOfBirth = "PLACE_OF_BIRTH";


    //Initializing the Page Objects:
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    //actions
    @Step("Input email")
    public void inputEmail(String email) {
        driver.findElement(By.xpath(emailInput)).sendKeys(email);
        driver.findElement(By.xpath(loginButton)).click();
    }

    @Step("Select guest mode")
    public void selectGuestMode() {
        driver.findElement(By.xpath(guestOption)).click();
        driver.findElement(By.xpath(registerButton)).click();
    }

    @Step("Verify from without user data")
    public void verifyBlankFormErrors() {
        driver.findElement(By.xpath(registerFromButton)).click();
        List<WebElement> errorMessages = driver.findElements(By.xpath(errorMessage));
        //verify amount of erros
        Assert.assertEquals(5, errorMessages.size());
        ArrayList<String> actualErrorsList = new ArrayList<String>();
        for (WebElement message : errorMessages) {
            actualErrorsList.add(message.getText());
        }
        //verify content of errors
        if (Arrays.equals(expectedErrorsList, actualErrorsList.toArray())) {
            log.info("Error messages is displayed correct");
        } else {
            log.error("Error messages doesn't displayed correct");
            Assert.fail();
        }
    }

    @Step("Verify from without user data")
    public void verifyErrorMessageNotDisplayed() {
        driver.findElement(By.xpath(registerFromButton)).click();
        List<WebElement> errorMessages = driver.findElements(By.xpath(errorMessage));
        //verify amount of errors
        Assert.assertEquals(0, errorMessages.size());
    }

    @Step("Select gender")
    public void selectGender(Gender gender) {
        if (gender == Gender.Frau) {
            driver.findElement(By.xpath(frauRadioButton)).click();
        } else if (gender == Gender.Herr) {
            driver.findElement(By.xpath(herrRadioButton)).click();
        } else {
            log.error("Please check gender value");
            Assert.fail();
        }
    }

    @Step("Input first name")
    public void inputFirstName(String firstName) {
        driver.findElement(By.id(firstNameInput)).sendKeys(firstName);
    }

    @Step("Input last name")
    public void inputLastName(String lastName) {
        driver.findElement(By.id(lastNameInput)).sendKeys(lastName);
    }

    @Step("Input date of birth")
    public void setDateOfBirth(String dateOfBirth) {
        driver.findElement(By.id(dateOfBirthInput)).sendKeys(dateOfBirth);
    }

    @Step("Input phone number")
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(By.id(phoneNumberInput)).sendKeys(phoneNumber);
    }

    @Step("Input user personal info")
    public void setUserPersonalInfo(Gender gender,
                                    String firstName,
                                    String lastName,
                                    String dateOfBirth,
                                    String phoneNumber
    ) {
        selectGender(gender);
        inputFirstName(firstName);
        inputLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setPhoneNumber(phoneNumber);
    }

    @Step("Input place of birth")
    public void setPlaceOfBirth(String placeOfBirth) {
        driver.findElement(By.id(placeOfBirth)).sendKeys(placeOfBirth);
    }


    public enum Gender {
        Frau,
        Herr
    }
}
