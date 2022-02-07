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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_status_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer statusId;

    @Column(name = "user_status_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String statusName;
}
