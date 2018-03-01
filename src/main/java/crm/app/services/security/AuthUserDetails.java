package crm.app.services.security;

import crm.app.data.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDetails implements UserDetails {

    private static final String USER_BLOCKED = "ROLE_BLOCKED";
    private final String userName;
    private final String password;
    private List<GrantedAuthority> authorities;

    public AuthUserDetails(AppUser appUser) {
        this.userName = appUser.getEmail();
        this.password = appUser.getPassword();
        authorities = new ArrayList<>();
        appUser.getRole().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase())));
    }

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
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return authorities.stream().noneMatch(s -> s.getAuthority().equals(USER_BLOCKED));
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
