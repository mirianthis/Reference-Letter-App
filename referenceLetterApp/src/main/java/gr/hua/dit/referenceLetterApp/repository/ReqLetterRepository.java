package gr.hua.dit.referenceLetterApp.repository;

import gr.hua.dit.referenceLetterApp.model.RecommendationReqLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReqLetterRepository extends JpaRepository<RecommendationReqLetter,Integer> {
    RecommendationReqLetter findReqLetterBySendTo(String sendTo);

    RecommendationReqLetter findReqLetterByCreatedBy(String createdBy);
}
