package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductInfo {

    @JsonProperty
    private int productId;

    @JsonProperty
    private Tabs tabs;

}
