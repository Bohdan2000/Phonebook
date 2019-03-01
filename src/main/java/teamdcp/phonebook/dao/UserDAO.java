package teamdcp.phonebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teamdcp.phonebook.models.User;

public interface UserDAO extends JpaRepository<User,Integer> {

    void deleteUsersById(int id);

    User getById(int id);
}
