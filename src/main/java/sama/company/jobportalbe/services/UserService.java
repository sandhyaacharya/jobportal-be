package sama.company.jobportalbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sama.company.jobportalbe.models.ApplicationUser;
import sama.company.jobportalbe.models.Role;


import java.beans.BeanProperty;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the details service");
        if (!username.equals("sama")) throw new UsernameNotFoundException("Not sama");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));
        return new ApplicationUser(1, "sama", encoder.encode("hello"), roles);
    }
}