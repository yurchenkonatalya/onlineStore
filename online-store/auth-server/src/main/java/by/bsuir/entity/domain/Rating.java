package by.bsuir.entity.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating_ref")
public class Rating {

    @Id
    @NotNull
    @Column(name = "rating_id")
    private Integer ratingId;

    @Column(name = "rating_number")
    private Integer ratingNumber;

}
