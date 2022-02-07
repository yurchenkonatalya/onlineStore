package by.bsuir.entity.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer userId;

    @Column(name = "user_email")
    @NotNull
    private String userEmail;

    @Column(name = "user_hash_pass")
    @NotNull
    private String userHashPass;

    @Column(name = "actual_date")
    @NotNull
    private LocalDateTime actualDate;

    @Column(name = "user_phone")
    @NotNull
    private String userPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private UserRole userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_status_id", referencedColumnName = "user_status_id")
    private UserStatus userStatus;

}
