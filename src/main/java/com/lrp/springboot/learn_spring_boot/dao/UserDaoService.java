package com.lrp.springboot.learn_spring_boot.dao;

import com.lrp.springboot.learn_spring_boot.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Piolo Milby", LocalDate.now().minusYears(10)));
        users.add(new User(2, "Sam Pascual", LocalDate.now().minusYears(3)));
        users.add(new User(3, "James Marsden", LocalDate.now().minusYears(5)));
    }

    public List<User> retrieveAllUser() {
        return users;
    }

    public User retrieveUser(Integer id) {
        Predicate<? super User> userMatch = user -> user.getId() == id;
        return users.stream()
                .filter(userMatch)
                .findFirst().get();
    }

    public void addUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
    }
}
