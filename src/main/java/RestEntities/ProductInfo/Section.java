package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Section {

    @JsonProperty
    private Row [] rows;
}
