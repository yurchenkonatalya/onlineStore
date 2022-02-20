package by.bsuir.entity.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
public class UserGoogleResponse {

    @JsonProperty("issued_to")
    private String issuedTo;

    @JsonProperty("audience")
    private String audience;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("expires_in")
    private Integer expireIn;

    @JsonProperty("email")
    private String email;

    @JsonProperty("verified_email")
    private Boolean verifiedEmail;

    @JsonProperty("access_type")
    private String accessType;

}
