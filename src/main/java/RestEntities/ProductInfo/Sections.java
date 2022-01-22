package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sections {

    @JsonProperty
    private Section general;

    @JsonProperty
    private Section payment;

    @JsonProperty
    private Section costOfAtm;

    @JsonProperty
    private Section feeDetails;

    @JsonProperty
    private Section bonus;

    @JsonProperty
    private Section insurance;

    @JsonProperty
    private Section travel;

}
