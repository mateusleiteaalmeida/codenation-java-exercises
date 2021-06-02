package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Código elaborado com o auxílio do grupo de estudos conduzido pelo Lucas Zago
@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).get();
        UserDetails userDetails = null;
        if (user == null) throw new UsernameNotFoundException("Usuário não encontrado.");
        userDetails = org.springframework.security.core.userdetails
                .User.withUsername(user.getEmail()).password(user.getPassword()).roles("user").build();
        return userDetails;
    }
}
