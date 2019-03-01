package teamdcp.phonebook.Conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teamdcp.phonebook.Services.ServiceImpl.ContactServiceImpl;
import teamdcp.phonebook.Services.ServiceImpl.UserServiceImpl;
import teamdcp.phonebook.models.Contact;
import teamdcp.phonebook.models.User;

import java.util.List;

@Controller
public class MainController {

    private final UserServiceImpl userServiceImpl;
    private final ContactServiceImpl contactServiceImpl;

    @Autowired
    public MainController(UserServiceImpl userServiceImpl,ContactServiceImpl contactServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.contactServiceImpl = contactServiceImpl;
    }

    @GetMapping("/")
    public String Home(Model model){
        List<User> all = userServiceImpl.findAll();
        model.addAttribute("user",new User("user","surname"));
        model.addAttribute("findAll",all);
        return "Home";
    }
    
    @GetMapping("/userDetails/{id}")
    public String singlUser(@PathVariable("id") Integer id,
                            Model model){
        User user = userServiceImpl.getById(id);
        model.addAttribute("user",user);
        return "SinglUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String name,
                           @RequestParam String surname){
        userServiceImpl.save(new User(name,surname));
        return "redirect:/";
    }


    @PostMapping("/userDetails/remove")
    public String remove(@RequestParam int id){
        //Integer id1= Integer.parseInt(id);
        userServiceImpl.deleteUsersById(id);
        return "redirect:/";
    }
    @PostMapping("/userDetails/update")
    public String update(User user
                         ){
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/userDetails/showContact")
    public String showContact(@RequestParam int id , Model model){
        List<Contact> byUserId = contactServiceImpl.findByUserId(id);
        model.addAttribute("byUserId",byUserId);
        return "ShowContacts";
    }

    @GetMapping("/userDetails/contactDetails/{id}")
    public String contactDetails(@PathVariable Integer id ,
                                 Model model){
        Contact singlContact = contactServiceImpl.getById(id);
        model.addAttribute("singlContact",singlContact);
        return "SinglContact";
    }
    @PostMapping("/userDetails/saveContact")
    public String saveContact(@RequestParam String phone,
                              @RequestParam String email,
                              @RequestParam int id,Model model){
        User byId = userServiceImpl.getById(id);
        Contact contact = new Contact(email,phone);
        contact.setUser(byId);
        contactServiceImpl.save(contact);
        List<Contact> byUserId = contactServiceImpl.findByUserId(id);
        model.addAttribute("byUserId",byUserId);
        return "ShowContacts";
    }
    @GetMapping("/userDetails/showContact/remove")
    public String removeContact(@RequestParam int id,
                                Model model
                                ){
        contactServiceImpl.deleteContactById(id);
        return "redirect:/";
    }
    @PostMapping("/showContact/update")
    public String updateContact(@RequestParam int id,
                                @RequestParam int userId,
                                Contact contact,
                                Model model){
        System.out.println(contact);
        User byId = userServiceImpl.getById(userId);
        contact.setUser(byId);
        contactServiceImpl.save(contact);
        return "redirect:/";
    }

}
