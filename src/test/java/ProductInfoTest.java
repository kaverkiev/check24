import RestEntities.ProductInfo.*;
import RestEntities.RestClient;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.testng.annotations.Test;

@Slf4j
public class ProductInfoTest {

    private static int productId;
    private static String sectionName;
    private static String id1 = "200007";
    private static String id2 = "abcd";
    private static String id3 = "5456";

    // TODO: add DataProvider in csv format and move all test data in separate csv file

    @Description("Get Product Info")
    @Test(priority = 10, description = "Get Product Info")
    public void getProductInfo() {
        ProductInfo productInfo = RestClient.getProductInfo(id1);
        assert productInfo != null;
        productId = productInfo.getProductId();
        log.info("Product id: " + productId);
        sectionName = productInfo.getTabs().getCashWithdrawal().getTabContent().getSections().getCostOfAtm().getRows()[0].getLabel();
        Assert.assertEquals("Inland", sectionName);
    }

    // TODO: add negative cases
}
