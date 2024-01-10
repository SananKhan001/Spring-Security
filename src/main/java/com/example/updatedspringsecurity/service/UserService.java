package com.example.updatedspringsecurity.service;

import com.example.updatedspringsecurity.enum_entity.Authority;
import com.example.updatedspringsecurity.model.User;
import com.example.updatedspringsecurity.repository.UserRepository;
import com.example.updatedspringsecurity.request.UserRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class UserService implements UserDetailsManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User createUser(UserRequest userRequest){
        User.UserBuilder userBuilder = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()));

        if (userRequest.getStudent() != null){
            userBuilder.authority(Authority.STUDENT);
        }
        else userBuilder.authority(Authority.TEACHER);

        createUser(userBuilder.build());

        return userRepository.findByUsername(userRequest.getUsername());
    }

    @Override
    public void createUser(UserDetails user) {
        userRepository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user) {
        // To Be Implemented
    }

    @Override
    public void deleteUser(String username) {
        // To Be Implemented
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // To Be Implemented
    }

    @Override
    public boolean userExists(String username) {
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
