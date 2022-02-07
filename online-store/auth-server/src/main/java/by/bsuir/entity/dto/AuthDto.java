package by.bsuir.entity.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDto {
    private String email;
    private String password;
}
