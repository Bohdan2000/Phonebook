package teamdcp.phonebook.Services;

import teamdcp.phonebook.models.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User getById(int id);
    void deleteUsersById(int id);
}
