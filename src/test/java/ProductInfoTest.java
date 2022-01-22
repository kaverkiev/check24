import RestEntities.ProductInfo.ProductInfo;
import RestEntities.RestClient;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.testng.annotations.Test;

@Slf4j
public class ProductInfoTest {

    private static final String id1 = "200007";
    private static final String id2 = "abcd";
    private static final String id3 = "5456";

    // TODO: add DataProvider in csv format and move all test data in separate csv file

    @Description("Get Product Info")
    @Test(priority = 10, description = "Get Product Info")
    public void getProductInfo() {
        ProductInfo response = RestClient.getProductInfo(id1);
        assert response != null;
        int productId = response.getProductId();
        log.info("Product id: " + productId);
        Assert.assertEquals(0, productId);
        String sectionName = response.getTabs().getCashWithdrawal().getTabContent().getSections().getCostOfAtm().getRows()[0].getLabel();
        log.info("Label: " + productId);
        Assert.assertEquals("Inland", sectionName);
    }

    // TODO: add negative cases

    @Description("Get Product Info with 404 error")
    @Test(priority = 20, description = "Get Product Info")
    public void getProductInfoNegative404() {
        try {
            ProductInfo response = RestClient.getProductInfo(id2);
        } catch (HttpClientErrorException.NotFound e) {
            log.info("Page not found");
        }
    }

    @Description("Get Product Info with 204 error")
    @Test(priority = 30, description = "Get Product Info")
    public void getProductInfoNegative204() {
        ProductInfo response = RestClient.getProductInfo(id3);
    }
}
