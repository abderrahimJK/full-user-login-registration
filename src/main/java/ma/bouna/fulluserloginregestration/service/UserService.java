package ma.bouna.fulluserloginregestration.service;

import ma.bouna.fulluserloginregestration.entities.User;

import java.util.List;

public interface UserService {

    public User getUser(Long id);
    public List<User> getUsers();
    public User addUser(User user);
    public User updateUser(User user);
    public void DeleteUser(User user);
    User getUserByMail(String email);
}
