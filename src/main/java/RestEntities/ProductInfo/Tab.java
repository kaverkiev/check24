package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tab {

    @JsonProperty
    private String tabName;

    @JsonProperty
    private TabContent tabContent;

}
