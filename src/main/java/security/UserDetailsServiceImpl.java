package security;

import com.project.mycapstone.springboot.database.dao.UserRoleDAO;
import com.project.mycapstone.springboot.database.dao.UsersDAO;
import com.project.mycapstone.springboot.database.entity.UserRole;
import com.project.mycapstone.springboot.database.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // this class is used by spring security to fetch the user from the database
        // and create the user roles

        Users users = usersDAO.findByEmail(username);

        if (users == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        List<UserRole> userRoles = userRoleDao.findByUserId(users.getId());

        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(users.getEmail(),
                users.getPassword(), accountIsEnabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, springRoles);
    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

}
