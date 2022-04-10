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
@Table(name = "role_ref")
public class UserRole {

    @Id
    @Column(name = "role_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private Integer roleId;

    @Column(name = "role_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String roleName;
}
