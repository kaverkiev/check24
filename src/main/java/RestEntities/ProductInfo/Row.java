package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Row {

    @JsonProperty
    private String label;

    @JsonProperty
    private ToolTip toolTip;

    @JsonProperty
    private Benefits [] benefits;

    @JsonProperty
    private boolean featuredDetail;
}
