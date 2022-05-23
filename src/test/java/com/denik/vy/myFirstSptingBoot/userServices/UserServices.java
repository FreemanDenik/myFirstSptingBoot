package com.denik.vy.myFirstSptingBoot.userServices;

import com.denik.vy.myFirstSptingBoot.models.User;
import com.denik.vy.myFirstSptingBoot.repositories.UserRepository;
import com.denik.vy.myFirstSptingBoot.services.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserServices {
    @Autowired
    public UserServiceImp userServices;
    @Autowired
    public UserRepository repository;
    @Test
    void getOneUser() {
        User userNotNull = userServices.user(2);
        User userNull = userServices.user(999);
        Assert.notNull(userNotNull, "user нулевой");
        Assert.isNull(userNull, "user не нулевой");
    }
//    @Test
//    void findByName() {
//        User user = repository.findByName("Bob");
//
//        Assert.notNull(user, "нулевой");
//        Assert.hasText(user.getName(), "Bob");
//    }
}
