package gr.hua.dit.referenceLetterApp.service;

import gr.hua.dit.referenceLetterApp.model.RecommendationReqLetter;
import gr.hua.dit.referenceLetterApp.model.User;

import java.util.List;
import java.util.Optional;

public interface ReqLetterService {
    public List<RecommendationReqLetter> findAllReqLetters();

    public Optional<RecommendationReqLetter> findReqLetterById(int id);

    public RecommendationReqLetter findReqLetterByCreatedBy(String createdBy);

    public RecommendationReqLetter findReqLetterBySendTo(String sendTo);

    public RecommendationReqLetter saveReqLetter(RecommendationReqLetter newReqLetter);

    RecommendationReqLetter updateReqLetter(String createdBy, RecommendationReqLetter reqLetter);

}
