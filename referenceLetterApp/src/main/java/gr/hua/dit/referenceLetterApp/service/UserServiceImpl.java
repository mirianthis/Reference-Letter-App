package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.User;
import gr.hua.dit.referenceLetterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }


    public Optional<User> findUserByIt(String it) {
        return userRepo.findByIt(it);
    }


    public User findByLastName(String lastName) {
        User user = userRepo.findByLastName(lastName);
        return user;
    }

    @Override
    public User saveUser(User newUser){
        User user = userRepo.save(newUser);
        return user;
    }
    @Override
    public User updateUser(String it,User user) {

        Optional<User> retrievedUser=userRepo.findByIt(it);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepo.save(user);
        return userRepo.findByIt(it).get();

    }

    @Override
    public User deleteUser(String userId) {

       Optional<User> retrievedUser=userRepo.findByIt(userId);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepo.deleteById(userId);
        return retrievedUser.get();



    }

}
