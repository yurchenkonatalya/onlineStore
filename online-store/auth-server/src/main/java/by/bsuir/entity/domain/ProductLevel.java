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
@Table(name = "product_level_ref")
public class ProductLevel {

    @Id
    @Column(name = "product_level_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private Integer productLevelId;

    @Column(name = "product_level_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String productLevelName;
}
