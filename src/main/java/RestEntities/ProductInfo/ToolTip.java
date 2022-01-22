package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToolTip {

    @JsonProperty
    private String icon;

    @JsonProperty
    private Overlay overlay;

}
