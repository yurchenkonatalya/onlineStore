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
@Table(name = "product_status_ref")
public class ProductStatus {

    @Id
    @Column(name = "product_status_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private Integer productStatusId;

    @Column(name = "product_status_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String productStatusName;
}
