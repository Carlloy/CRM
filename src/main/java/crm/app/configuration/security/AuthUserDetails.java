package crm.app.configuration.security;

import crm.app.data.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDetails implements UserDetails {

    private static final String userBlocked = "BLOCKED";
    private final String userName;
    private final String password;
    List<GrantedAuthority> authorities;

    public AuthUserDetails(AppUser appUser) {
        this.userName = appUser.getEmail();
        this.password = appUser.getPassword();
        authorities = new ArrayList<>();
        appUser.getRole().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase())));
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
        return authorities.stream().noneMatch(s -> s.getAuthority().equals(userBlocked));
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
