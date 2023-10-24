package gr.hua.dit.referenceLetterApp.service;


import gr.hua.dit.referenceLetterApp.model.ThirdParty;

import java.util.List;


public interface ThirdPartyService {
    public List<ThirdParty> findAllThirdParties();

    public ThirdParty findThirdPartyByEmail(String email);

    public ThirdParty findThirdPartyByField(String field);

    public ThirdParty saveThirdParty(ThirdParty newThirdParty);

}
