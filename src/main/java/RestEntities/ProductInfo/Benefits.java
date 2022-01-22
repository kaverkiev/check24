package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Benefits {

    @JsonProperty
    private String value;

    @JsonProperty
    private String benefitType;
}
