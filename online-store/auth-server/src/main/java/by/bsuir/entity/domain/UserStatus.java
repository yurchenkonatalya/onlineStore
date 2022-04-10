package by.bsuir.entity.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user_status_ref")
public class UserStatus {

    @Id
    @Column(name = "user_status_id")
    @NotNull

    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer userStatusId;

    @Column(name = "user_status_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String userStatusName;
}
