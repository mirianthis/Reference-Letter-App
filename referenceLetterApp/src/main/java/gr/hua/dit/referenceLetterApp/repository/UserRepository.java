package gr.hua.dit.referenceLetterApp.repository;

import gr.hua.dit.referenceLetterApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLastName(String lastName);

    Optional<User> findByIt(String it);

    void deleteUserByIt(String it);

}
