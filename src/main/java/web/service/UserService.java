package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void removeUserById(Long id);


    void edit(Long id, User u);
}
