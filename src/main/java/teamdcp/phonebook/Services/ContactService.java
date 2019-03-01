package teamdcp.phonebook.Services;

import teamdcp.phonebook.models.Contact;

import java.util.List;

public interface ContactService {
    void save(Contact contact);
    List<Contact> findAll();
    List<Contact> findByUserId( int id);
    Contact getById(Integer id);
    void deleteContactById(int id);
}
