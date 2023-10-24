package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.User;
import gr.hua.dit.referenceLetterApp.model.UserDetailsImpl;
import gr.hua.dit.referenceLetterApp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user=userRepo.findByIt(username);

//		System.out.println("inside impl "+user);

        if(user==null) {
            System.out.println("exception thrown");
            throw new UsernameNotFoundException(username + "not found");
        }
        return new UserDetailsImpl(user);
    }

}