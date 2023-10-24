package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAllUsers();

    public Optional<User> findUserByIt(String it);

    public User findByLastName(String lastName);

    public User saveUser(User newUser);

    User updateUser(String it, User user);

    User deleteUser(String userId);
}
