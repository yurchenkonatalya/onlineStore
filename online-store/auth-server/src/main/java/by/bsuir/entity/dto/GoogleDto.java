package by.bsuir.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoogleDto {
    @JsonProperty("access_token")
    private String accessToken;
}
