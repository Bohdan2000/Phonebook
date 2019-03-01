package teamdcp.phonebook.Services.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamdcp.phonebook.Services.ContactService;
import teamdcp.phonebook.dao.ContactDAO;
import teamdcp.phonebook.models.Contact;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactDAO contactDAO;

    @Autowired
    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }


    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public List<Contact> findByUserId(int id) {
        return contactDAO.findByUserId(id);
    }
    @Override
    public Contact getById(Integer id) {
        return contactDAO.getById(id);
    }

    @Transactional
    @Override
    public void deleteContactById(int id) {
        contactDAO.deleteContactById(id);
    }
}
