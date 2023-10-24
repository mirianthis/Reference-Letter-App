package gr.hua.dit.referenceLetterApp.repository;

import gr.hua.dit.referenceLetterApp.model.ThirdParty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty,String> {
    ThirdParty findByEmail(String email);

    ThirdParty findByField(String field);
}
