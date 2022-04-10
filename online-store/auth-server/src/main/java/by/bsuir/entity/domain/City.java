package by.bsuir.entity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "city_ref")
public class City {

    @Id
    @Column(name = "city_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private Integer cityId;

    @Column(name = "city_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String cityName;

}
