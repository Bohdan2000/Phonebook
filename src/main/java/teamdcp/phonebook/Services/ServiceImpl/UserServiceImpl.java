package teamdcp.phonebook.Services.ServiceImpl;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamdcp.phonebook.Services.UserService;
import teamdcp.phonebook.dao.ContactDAO;
import teamdcp.phonebook.dao.UserDAO;
import teamdcp.phonebook.models.Contact;
import teamdcp.phonebook.models.User;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.List;


@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final ContactDAO contactDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO,ContactDAO contactDAO) {
        this.userDAO = userDAO;
        this.contactDAO=contactDAO;
    }

    @Transactional
    @PostConstruct
    public void postConstract(){
        User user1 = new User("Igor", "Kuku");
        this.userDAO.save(user1);
        Contact contact1 = new Contact("qwe@gamil.com", "123");
        Contact contact2 = new Contact("asd@gamil.com", "312");
        Contact contact3 = new Contact("zxc@gamil.com", "454");
        contact1.setUser(user1);
        contact2.setUser(user1);
        contact3.setUser(user1);
        this.contactDAO.save(contact1);
        this.contactDAO.save(contact2);
        this.contactDAO.save(contact3);
        this.userDAO.save(new User("Oleg","Lala"));
        this.userDAO.save(new User("Taras","Tutu"));
        this.userDAO.save(new User("Roman","Mumu"));
    }


    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Transactional
    @Override
    public void deleteUsersById(int id) {
        userDAO.deleteUsersById(id);
    }
}
