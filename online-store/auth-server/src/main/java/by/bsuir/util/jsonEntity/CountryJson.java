package by.bsuir.util.jsonEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryJson {

    @JsonProperty("name")
    private String name;

    @JsonProperty("regions")
    private RegionJson[] regionJsons;
}
