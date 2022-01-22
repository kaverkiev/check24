import Base.TestBase;
import Pages.CreditCardPage;
import Pages.RegisterPage;
import Utils.Globals;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CreditCardPageTest extends TestBase {

    private CreditCardPage creditCardPage = new CreditCardPage();
    private RegisterPage registerPage = new RegisterPage();

    @Description("Verify cookies")
    @Test(priority = 10)
    public void verifyCookies() {
        String ppsetParameter = getCookieParameterByName(Globals.COOKIES_PPSET);
        Assert.assertEquals("kreditkarte", ppsetParameter);
    }

    // TODO: add DataProvider in csv format and move all test data in separate csv file
    @Description("Guest register test scenario")
    @Test(priority = 20)
    public void guestRegisterTest() throws InterruptedException {
        creditCardPage.acceptCookies();
        creditCardPage.selectProductById(creditCardPage.getFirstProductId());
        Thread.sleep(5000);  // TODO: need replace for wait method
        registerPage.inputEmail("konstantin.averkiev@gmail.com");
        registerPage.selectGuestMode();

        // validate empty form
        registerPage.verifyBlankFormErrors();

        // validate form with user info
        registerPage.setUserPersonalInfo(RegisterPage.Gender.Frau,"Konstantin", "Averkiev", "27.04.1984", "+491711811198");
        registerPage.verifyErrorMessageNotDisplayed();
        registerPage.setPlaceOfBirth("Belarus");
    }

}
