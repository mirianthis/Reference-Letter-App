package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.RecommendationReqLetter;
import gr.hua.dit.referenceLetterApp.model.User;
import gr.hua.dit.referenceLetterApp.repository.ReqLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReqLetterServiceImpl implements ReqLetterService{

    @Autowired
    private ReqLetterRepository reqRepo;

    @Override
    public List<RecommendationReqLetter> findAllReqLetters() {
        return reqRepo.findAll();
    }

    @Override
    public Optional<RecommendationReqLetter> findReqLetterById(int id) {
        return reqRepo.findById(id);
    }

    @Override
    public RecommendationReqLetter findReqLetterByCreatedBy(String createdBy) {
        RecommendationReqLetter reqLetter = reqRepo.findReqLetterByCreatedBy(createdBy);
        return reqLetter;
    }

    @Override
    public RecommendationReqLetter findReqLetterBySendTo(String sendTo) {
        RecommendationReqLetter reqLetter = reqRepo.findReqLetterBySendTo(sendTo);
        return reqLetter;
    }

    @Override
    public RecommendationReqLetter saveReqLetter(RecommendationReqLetter newReqLetter) {
        RecommendationReqLetter reqLetter = reqRepo.save(newReqLetter);
        return  reqLetter;
    }

    @Override
    public RecommendationReqLetter updateReqLetter(String createdBy, RecommendationReqLetter reqLetter) {
        RecommendationReqLetter retrieveReqLetter = reqRepo.findReqLetterByCreatedBy(createdBy);

        if(retrieveReqLetter==null){
            try{
                throw new Exception("Req Letter Not Found");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        reqRepo.save(reqLetter);
        return reqRepo.findReqLetterByCreatedBy(createdBy);
    }
}
