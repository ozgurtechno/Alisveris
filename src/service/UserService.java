package service;

import entity.Item;
import entity.User;
import exception.ItemNotFoundException;
import exception.UserNotFoundException;

import java.util.List;
import java.util.Scanner;

public interface UserService {

    List<User> getAllUser();

    User geUserById(int id) throws UserNotFoundException;

    User addUser();

    void deleteUserById(int id) throws UserNotFoundException;

    void updateUser(User user);
}
