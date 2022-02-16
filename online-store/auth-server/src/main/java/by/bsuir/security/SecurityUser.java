package by.bsuir.security;

import by.bsuir.constant.ref.UserStatusRef;
import by.bsuir.entity.domain.UserStatus;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SecurityUser implements UserDetails {
    private String email;
    private String password;
    private String phone;
    private Collection<? extends GrantedAuthority> authorities;
    private UserStatus userStatus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return userStatus.getStatusId().equals(UserStatusRef.ACTIVE.getId());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !userStatus.getStatusId().equals(UserStatusRef.BANNED.getId());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userStatus.getStatusId().equals(UserStatusRef.ACTIVE.getId());
    }
}
