package com.sample.graphql;

import java.util.Optional;

import javax.transaction.Transactional;

import com.sample.domain.entity.User;
import com.sample.repository.UserRepository;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class UserQuery implements GraphQLQueryResolver{
    
    private final UserRepository userRepository;

    public User read(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.get();
    }

    
}
