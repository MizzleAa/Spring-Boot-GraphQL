package com.sample.graphql;

import java.util.Optional;

import javax.transaction.Transactional;

import com.sample.domain.entity.User;
import com.sample.payload.request.CreateUser;
import com.sample.payload.request.DeleteUser;
import com.sample.repository.UserRepository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class UserMutation implements GraphQLMutationResolver{
    
    private final UserRepository userRepository;

    public User create(CreateUser createUser){
        User user = User.builder().email(createUser.getEmail()).password(createUser.getPassword()).build();
        userRepository.save(user);
        return user;
    }

    public Boolean delete(DeleteUser deleteUser){
        Optional<User> user = userRepository.findByEmail(deleteUser.getEmail());
        Assert.isNull(user.isPresent(), "해당 유저는 존재하지 않습니다.");
        userRepository.deleteAllByEmail(user.get().getEmail());
        return true;
    }
}
