package RestEntities.ProductInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tabs {

    @JsonProperty
    private Tab general;

    @JsonProperty
    private Tab payment;

    @JsonProperty
    private Tab cashWithdrawal;

    @JsonProperty
    private Tab fees;

    @JsonProperty
    private Tab additionalInfoAndBonus;

    @JsonProperty
    private Tab insurance;

    @JsonProperty
    private Tab travel;

}
