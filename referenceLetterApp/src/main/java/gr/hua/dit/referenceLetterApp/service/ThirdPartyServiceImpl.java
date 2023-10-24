package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.ThirdParty;
import gr.hua.dit.referenceLetterApp.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService{

    @Autowired
    private ThirdPartyRepository thirdPartyRepo;

    @Override
    public List<ThirdParty> findAllThirdParties() {
        return thirdPartyRepo.findAll();
    }

    @Override
    public ThirdParty findThirdPartyByEmail(String email) {
        ThirdParty tp = thirdPartyRepo.findByEmail(email);
        return tp;
    }

    @Override
    public ThirdParty findThirdPartyByField(String field) {
        ThirdParty tp = thirdPartyRepo.findByField(field);
        return tp;
    }

    @Override
    public ThirdParty saveThirdParty(ThirdParty newThirdParty) {
        ThirdParty tp = thirdPartyRepo.save(newThirdParty);
        return tp;
    }
}
