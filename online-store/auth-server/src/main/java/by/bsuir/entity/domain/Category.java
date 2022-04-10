package by.bsuir.entity.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "category_ref")
public class Category {
    @Id
    @Column(name = "category_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    @JsonProperty("id")
    private Integer categoryId;

    @Column(name = "category_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    @JsonProperty("name")
    private String categoryName;

}
