package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TabContent {

    @JsonProperty
    private Sections sections;

    @JsonProperty
    private String productInformationSheet;
}
