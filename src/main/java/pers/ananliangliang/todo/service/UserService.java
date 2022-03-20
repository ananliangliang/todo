package pers.ananliangliang.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ananliangliang.todo.domain.Authority;
import pers.ananliangliang.todo.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = repository.getByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user [%s] not found", username)));
        final var authorities = user.getAuthorities()
                .stream().map(Authority::getAuthority).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return new User(username, user.getPassword(), authorities);
    }
}
