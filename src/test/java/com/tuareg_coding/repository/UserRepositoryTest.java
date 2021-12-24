package com.tuareg_coding.repository;

import com.tuareg_coding.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUser() {
        User user = User.builder()
                .firstName("Hamdi Ag")
                .lastName("Anara")
                .email("hamdi@gmail.com")
                .password("password")
                .build();

        userRepository.save(user);

    }

}