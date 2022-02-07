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
@Table(name = "token")
public class Token {

    @Id
    @NotNull
    @Column(name = "token")
    private String token;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
