package ex.bookstore.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ex.bookstore.domain.User;
import ex.bookstore.repos.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailServiceImpl(UserRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User current = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, current.getPasswordHash(),
        AuthorityUtils.createAuthorityList(current.getRole()));
        return user;
    }
}
