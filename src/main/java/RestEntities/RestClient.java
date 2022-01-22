package RestEntities;

import RestEntities.ProductInfo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestClient {

    public static HttpEntity<String> createHttpRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }

    public static ProductInfo getProductInfo(String id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ProductInfo> response = restTemplate.exchange("https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/" + id, HttpMethod.GET, createHttpRequest(), ProductInfo.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("Product info list");
                return response.getBody();
            }
            return null;
        } catch (HttpStatusCodeException e) {
            log.error("Response Status: " + e.getStatusCode());
            throw e;
        }
    }

}
