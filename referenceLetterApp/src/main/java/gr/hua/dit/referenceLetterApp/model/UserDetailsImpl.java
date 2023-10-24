package gr.hua.dit.referenceLetterApp.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {


    private static final long serialVersionUID = 1L;

    private Optional<User> user;

    public UserDetailsImpl(Optional<User> user) {

        super();
        this.user=user;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.user.get().getRole().toUpperCase()));
//		System.out.println("inside details impl "+grantedAuthorities.get(0).getAuthority());
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {

        return this.user.get().getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.get().getIt();
    }


    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public Optional<User> getUserDetails() {
        return user;
    }

}


