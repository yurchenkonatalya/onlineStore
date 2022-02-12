package by.bsuir.entity.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegDto {
    private String email;
    private String password;
    private String repeatPassword;
    private String phoneNumber;
}
