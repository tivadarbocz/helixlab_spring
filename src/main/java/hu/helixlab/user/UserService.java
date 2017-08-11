package hu.helixlab.user;

import hu.helixlab.email.EmailService;
import hu.helixlab.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017.08.09..
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    Iterable<User> findAll(){

        return userRepository.getEnabledUser(true);
    }

    User findUserById(int id){
        return userRepository.findOne(id);
    }

    User createUser(User user){

        //TODO email küldés
        emailService.sendMail("sf","fdsfds","fsf");
        user.setPassword(SecurityUtil.base64encode(SecurityUtil.generatePassword(10)));
        return userRepository.saveAndFlush(user);
    }

    User updateUserById(int id, User user){
        if(userRepository.findOne(id).getId() == id){
            return userRepository.saveAndFlush(user);
        }
        else{
            throw new NullPointerException();
        }
    }

    void deleteUserById(int id){
        User user = userRepository.findOne(id);
        if(user != null){
            userRepository.delete(user);
        }
    }

}
