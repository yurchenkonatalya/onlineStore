package by.bsuir.security;

import by.bsuir.entity.domain.User;
import by.bsuir.entity.domain.UserRole;
import by.bsuir.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class SecurityUserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public SecurityUserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepo.findByUserEmail(username);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("Account is not exists");
        }
        User user = userOptional.get();
        return SecurityUser
                .builder()
                .email(user.getUserEmail())
                .password(user.getUserHashPass())
                .phone(user.getUserPhone())
                .userStatus(user.getUserStatus())
                .authorities(createAuthority(user.getUserRole()))
                .build();
    }

    private Collection<? extends GrantedAuthority> createAuthority(UserRole userRole){
        return List.of(new SimpleGrantedAuthority(userRole.getRoleName()));
    }
}
