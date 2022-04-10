package by.bsuir.entity.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @Email
    private String userEmail;

    @Column(name = "user_hash_pass")
    private String userHashPass;

    @Column(name = "actual_date")
    @NotNull
    private LocalDateTime actualDate;

    @Column(name = "user_phone")
   // @Size(min = 9, max = 9)
    private String userPhone;

    @Column(name = "user_google_id")
    private String userGoogleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private UserRole userRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_status_id", referencedColumnName = "user_status_id")
    private UserStatus userStatus;

}
