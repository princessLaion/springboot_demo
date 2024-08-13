package com.lrp.springboot.learn_spring_boot.dao;

import com.lrp.springboot.learn_spring_boot.exception.UserNotFoundException;
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

    private Predicate<? super User> isUserMatch(Integer userId) {
        return user -> user.getId().equals(userId);
    }

    public List<User> retrieveAllUser() {
        return users;
    }

    public User retrieveUser(Integer id) {
        return users.stream()
                .filter(isUserMatch(id))
                .findFirst()
                .orElseThrow(
                        () -> new UserNotFoundException("id: " + id)
                );
    }


    public void deleteUser(Integer id) {
        users.removeIf(isUserMatch(id));
    }

    /**
     * Another option of returning the deleted User info.
     */
    public User deleteUserWithInfo(Integer id) {
        User user = retrieveUser(id);
        users.removeIf(isUserMatch(id));

        return user;
    }

    public User addUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

}
