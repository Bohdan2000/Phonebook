package teamdcp.phonebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teamdcp.phonebook.models.Contact;


import java.util.List;

public interface ContactDAO extends JpaRepository<Contact,Integer> {
    @Query("select u from Contact u where u.user.id=:xxx")
    List<Contact> findByUserId(@Param("xxx") int id);


    void deleteContactById( int id);

    Contact getById(Integer id);

}
